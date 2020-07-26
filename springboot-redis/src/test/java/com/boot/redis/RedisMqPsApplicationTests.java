package com.boot.redis;

import com.boot.redis.config.PublishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 注意：该类的包名要与启动类包名一致，并且保证启动类已经存在，否则报错
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisMqPsApplicationTests {
    @Autowired
    private PublishService service;

//    @Test
//    public void contextLoads() {
//        for (int i = 0; i < 2; i++) {
//            service.publish("test-topic", "hello~~~" + i);
//        }
//    }

    @Test
    public void contextLoadsExpiration() {
        for (int i = 0; i < 1; i++) {
            service.publishExpiration("test-topic-exp:" + i, "hello_" + i, 20l);
        }
    }

}
