package com.rate.limiter.counter;


public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            TestThread testThread = new TestThread();
            testThread.start();
        }
    }
}
