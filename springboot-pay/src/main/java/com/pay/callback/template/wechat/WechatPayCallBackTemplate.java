package com.pay.callback.template.wechat;

import com.pay.callback.template.AbstractPayCallBackTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
@Component
public class WechatPayCallBackTemplate extends AbstractPayCallBackTemplate {
    /**
     * 实现以下验签，失败返回进行重试，异步通知业务逻辑
     */
    @Override
    public Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public String failResult() {
        return null;
    }

    @Override
    public String asyncService(Map<String, String> verifySignature) {
        return null;
    }
}
