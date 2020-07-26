package com.rate.limiter.counter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountRateLimiterDemo2 {
    private static Semaphore semphore = new Semaphore(5);

    public static void exec() {
        if (semphore.getQueueLength() > 5) {
            System.out.println("当前等待排队的任务数大于5，请稍候再试...");
        }
        try {
            semphore.acquire();
            System.out.println("semphore加 -- " + semphore.getQueueLength());
            // 处理核心逻辑
            TimeUnit.SECONDS.sleep(1);
            System.out.println("--" + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semphore.release();
            System.out.println("semphore减 -- " + semphore.getQueueLength());
        }
    }
}
