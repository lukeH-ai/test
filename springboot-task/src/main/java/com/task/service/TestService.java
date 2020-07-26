package com.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestService {
    public static Random random = new Random();

    @Async("asyncExecutor")
    public void asyncExecutor(int number) throws InterruptedException {
        Thread.sleep(random.nextInt(number));
        System.out.println(" ======= 执行asyncExecutorT方法 ======= ");
        System.out.println("线程名称2:" + Thread.currentThread().getName());
        System.out.println("============================================");
    }

    @Scheduled(cron = "0/3 * * * * ? ")//定时任务的执行时间ian
    public void taskScheduler() {
        //自己的定时任务业务逻辑
        System.out.println("=========== 执行定时任务" + Thread.currentThread().getName() + " ============");
        System.out.println("============================================");
    }
}
