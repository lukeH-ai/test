package com.rate.limiter.counter;

public class TestThread extends Thread{

    @Override
    public void run() {
//        CountRateLimiterDemo1.exec();
        CountRateLimiterDemo2.exec();
    }
}
