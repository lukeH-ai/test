package com.pay.strategy.impl;

import com.pay.strategy.IStrategyPay;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
public class AliPay implements IStrategyPay {
    @Override
    public String toPayHtml() {
        return "支付宝";
    }
}
