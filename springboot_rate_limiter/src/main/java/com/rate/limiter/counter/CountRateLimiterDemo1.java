package com.rate.limiter.counter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountRateLimiterDemo1 {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void exec() {
        if (count.get() >= 5) {
            System.out.println("请求用户过多，请稍后在试！" + System.currentTimeMillis() / 1000);
        } else {
            count.incrementAndGet();
            System.out.println("count加 -- " + count.get());
            try {
                //处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                System.out.println("--" + System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count.decrementAndGet();
                System.out.println("count减 -- " + count.get());
            }
        }
    }
}
