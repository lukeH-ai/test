package com.boot.redis.config;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


/**
 * @Auther : xiaobao
 * @Date : 2019/7/18 15:09
 * @Description : redis监听器
 */

/**
 * 监听所有过期事件 （注入spring容器即可，无需在redisConfig中指定监听器）
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {


    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }


    /**
     * 针对redis数据失效事件，进行数据处理
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        System.out.println("expiredKey : "+ expiredKey);
//        if (expiredKey.startsWith("test-topic-expiration")) {
//            System.out.println("检测到过期消息" + expiredKey.replace("test-topic-expiration", ""));
//        }
    }
}
