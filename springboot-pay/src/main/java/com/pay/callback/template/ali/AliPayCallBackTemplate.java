package com.pay.callback.template.ali;

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
public class AliPayCallBackTemplate extends AbstractPayCallBackTemplate {
    @Override
    public Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public String failResult() {
        return "{code : 500, msg : 回调失败}";
    }

    @Override
    public String asyncService(Map<String, String> verifySignature) {
        return null;
    }
}
