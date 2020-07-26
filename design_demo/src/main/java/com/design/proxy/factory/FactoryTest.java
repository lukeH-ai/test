package com.design.proxy.factory;

import com.design.proxy.Impl.UserServiceImpl;
import com.design.UserService;

import java.lang.reflect.Proxy;

public class FactoryTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        test02();
    }


    /**
     * 建接口实例，通过jdk动态代理创建代理对象
     * 该测试旨在通过代理模式为接口功能进行增强 （即前置通知，后置通知，有别于装饰模式通过继承抽象类进行增强）
     */
    public static void test01(){
        UserService userService = new UserServiceImpl();
        ProxyFactory01 proxyFactory = new ProxyFactory01(userService);
        UserService userProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, proxyFactory);
        System.out.println(userProxy.selectUser("1").toString());
    }

    /**
     * 不创建接口实例，直接jdk动态代理创建代理对象
     * 该测试模仿 mybatis 中 dao层创建动态代理调用接口方法（即调用invoke方法，进而可以进行数据库操作，最后返回 result）
     */
    public static void test02(){
        ProxyFactory02 proxyFactory = new ProxyFactory02(UserService.class);
        UserService userProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, proxyFactory);
        System.out.println(userProxy.selectUser("1").toString());
    }


}
