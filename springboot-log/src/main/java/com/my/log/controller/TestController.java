package com.my.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Slf4j
@RestController
public class TestController {

    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    @GetMapping("/test01")
    public void test01() {
        log.info("日志的正确姿势要点：[{}] and [{}]", "严格log格式打印", "对还有第二点");
        log.info("测试打印用户名：[{}] and 密码：[{}]", "username", 123456);
        System.out.println("==================================");
        log.warn("日志的正确姿势要点：[{}]", "严格log格式打印");
        log.warn("测试打印用户名：[{}]", "username");
        log.warn("测试打印密码：[{}]", 123456);
        System.out.println("==================================");
        log.error("记录错误日志：[{}]", "异常问题001");
        log.error("记录错误日志：[{}]", "6677777");
        log.error("记录错误日志：[{}]", new Date().getTime());

        System.out.println("===================================");
        sys_user_logger.info("用户日志记录：[{}]","终于有用户日志啦，啊哈哈");

    }

}
