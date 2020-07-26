package com.boot.redis.controller;

import com.boot.redis.config.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PublishService service;

    /**
     * 发布订阅测试
     */
    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public String contextLoads() {
        for (int i = 0; i < 2; i++) {
            service.publish("test-topic", "hello~~~" + i);
        }
        return "success";
    }

    /**
     * 过期消息监听测试
     */
    @RequestMapping(value = "/expiration", method = RequestMethod.GET)
    public String testExpiration() {
        for (int i = 0; i < 2; i++) {
            service.publishExpiration("test-topic-exp:" + i, "hello_" + i, 20l);
        }
        return "success";
    }
}
