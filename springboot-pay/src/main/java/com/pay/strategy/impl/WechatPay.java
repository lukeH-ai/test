package com.pay.strategy.impl;

import com.pay.strategy.IStrategyPay;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
public class WechatPay implements IStrategyPay {
    @Override
    public String toPayHtml() {
        return "微信支付";
    }
}
