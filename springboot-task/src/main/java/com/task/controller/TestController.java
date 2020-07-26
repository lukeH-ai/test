package com.task.controller;

import com.task.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/asyncTask")
    public void asyncTask() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println("进入 asyncTask 方法 ======= ");
            testService.asyncExecutor(10000);
            System.out.println("线程名称1:" + Thread.currentThread().getName());
        }
    }

    @RequestMapping("/schedulerTask")
    public void schedulerTask() {
        System.out.println("进入 schedulerTask 方法 ======= ");
        testService.taskScheduler();
        System.out.println("线程名称1:" + Thread.currentThread().getName());
    }
}
