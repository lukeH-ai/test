package com.design.decoration.factory;

import com.design.decoration.Impl.OneCache;
import com.design.decoration.Impl.ThreeCache;
import com.design.decoration.Impl.TwoCache;

public class Factory {
    public static void main(String[] args) {
        test02();
    }

    /**
     * 增强二级缓存测试
     */
    public static void test01(){
        TwoCache twoCache = new TwoCache(new OneCache());
        System.out.println(twoCache.selectUser("1").toString());
        System.out.println("--------------------------------------");
        System.out.println(twoCache.selectUser("1").toString());
    }

    /**
     * 增强三级缓存测试
     */
    public static void test02(){
        ThreeCache threeCache = new ThreeCache(new TwoCache(new OneCache()));
        System.out.println(threeCache.selectUser("1").toString());
        System.out.println("--------------------------------------");
        System.out.println(threeCache.selectUser("1").toString());
    }
}
