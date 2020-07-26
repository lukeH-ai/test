package com.boot.redis.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 订阅指定渠道的消息（在redisConfig中配置渠道名称）
 */
public class SubscribeListener implements MessageListener {
    /**
     * 订阅接收发布者的消息
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 缓存消息是序列化的，需要反序列化。然而new String()可以反序列化，但静态方法valueOf()不可以
        System.out.println(new String(pattern) + "主题发布：" + new String(message.getBody()));
    }
}
