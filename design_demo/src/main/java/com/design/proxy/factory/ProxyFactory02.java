package com.design.proxy.factory;


import com.design.entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyFactory02 implements InvocationHandler {
    private Class<?> clazz;

    public ProxyFactory02(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(">>>>> 前置通知");
        User user = new User("测试代理模式02","123456");
        Object result = "方法名称:" + method.getName() + ",参数值:" + Arrays.toString(args) + ",clazz:" + clazz;
        System.out.println(">>>>> 后置通知 "+ result);
        return user;
    }

}
