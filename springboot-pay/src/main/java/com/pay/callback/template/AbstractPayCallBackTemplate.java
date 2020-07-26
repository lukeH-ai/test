package com.pay.callback.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
@Slf4j
public abstract class AbstractPayCallBackTemplate {

    /**
     * 1.验证报文参数 2.将报文日志存入数据库 3.执行异步回调业务逻辑
     * 2.通过 参数 HttpServletRequest req, HttpServletResponse resp 来实现统一接收处理
     */

    // 子类实现各自的验签
    public abstract Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resp);

    // 子类实现验签失败的返回状态，进而进行重试
    public abstract String failResult();

    // 子类实现异步业务逻辑
    public abstract String asyncService(Map<String, String> verifySignature);


    // 父类异步回调方法
    public String asyncCallBack(HttpServletRequest req, HttpServletResponse resp) {
        // 1.验证报文
        Map<String, String> verifySignature = verifySignature(req, resp);
        if(CollectionUtils.isEmpty(verifySignature)){
            return failResult();
        }
        // 2.记录日志
        String paymentId = verifySignature.get("paymentId");
        if(StringUtils.isEmpty(paymentId)) {
            return failResult();
        }
        payLog(paymentId, verifySignature);

        //3.验证报文失败201
        String result = verifySignature.get("result");
        if ("201".equals(result)) {
            return failResult();
        }

        // 4.异步业务逻辑
        return asyncService(verifySignature);
    }

    /**
     * ms:不要做成同步的，避免影响响应速度，做成多线程或者MQ方式存入数据库
     *
     * @param paymentId
     * @param verifySignature
     */
    @Async
    public void payLog(String paymentId, Map<String, String> verifySignature) {
        log.info("记录支付报文日志");
    }



}
