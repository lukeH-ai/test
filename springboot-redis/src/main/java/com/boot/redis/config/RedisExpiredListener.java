package com.boot.redis.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
/**
 * 监听指定渠道的过期事件（在redisConfig中配置渠道名称）
 */
public class RedisExpiredListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();// 建议使用: valueSerializer
        byte[] channel = message.getChannel();

        System.out.println("onMessage >> " + String.format("channel: %s, body: %s, bytes: %s"
                , new String(channel), new String(body), new String(bytes)));
    }

}
