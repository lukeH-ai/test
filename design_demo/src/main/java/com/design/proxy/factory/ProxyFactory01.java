package com.design.proxy.factory;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyFactory01 implements InvocationHandler {
    private Object target;

    public ProxyFactory01(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(">>>>> 前置通知");
        Object invoke = method.invoke(target, args);
        System.out.println(">>>>> 后置通知");
        return invoke;
    }

}
