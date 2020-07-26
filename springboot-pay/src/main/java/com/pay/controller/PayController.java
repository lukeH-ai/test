package com.pay.controller;

import com.pay.entity.Channel;
import com.pay.service.IChannelService;
import com.pay.strategy.IStrategyPay;
import com.pay.strategy.factory.StrategyBeanFactory;
import com.pay.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 描述
 *
 * @author Luke
 * @date 2020/3/10
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private IChannelService channelService;

    /**
     * 查询所有渠道
     */
    @GetMapping("/selectChannelList")
    public List<Channel> selectChannelList() {
        return channelService.selectChannelList();
    }

    /**
     * 获取支付页面
     */
    @GetMapping("/getPayHtml/{id}")
    public String getPayHtml(@PathVariable("id") int id) {
        Channel channel = channelService.getChannel(id);
        if (channel == null) {
            return "获取支付渠道失败";
        }
        IStrategyPay strateyBean = (IStrategyPay) StrategyBeanFactory.getStrateyBean(channel.getClassAddress());
        return strateyBean.toPayHtml();
    }

}
