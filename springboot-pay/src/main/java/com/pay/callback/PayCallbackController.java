package com.pay.callback;

import com.pay.callback.template.ali.AliPayCallBackTemplate;
import com.pay.callback.template.wechat.WechatPayCallBackTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 回调
 *
 * @author Luke
 * @date 2020/3/10
 */
@RestController
@RequestMapping("/callback")
public class PayCallbackController {

    @Autowired
    private AliPayCallBackTemplate aliPayCallBackTemplate;
    @Autowired
    private WechatPayCallBackTemplate wechatPayCallBackTemplate;

    @GetMapping("/AliPayCallBack")
    public String AliPayCallBack(HttpServletRequest req, HttpServletResponse resp){
        return aliPayCallBackTemplate.asyncCallBack(req,resp);
    }
    @PostMapping("/WechatPayCallBack")
    public String WechatPayCallBack(HttpServletRequest req, HttpServletResponse resp){
        return wechatPayCallBackTemplate.asyncCallBack(req,resp);
    }
}
