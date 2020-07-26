package com.pay.strategy.factory;

import com.mysql.jdbc.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略bean工厂
 *
 * @author Luke
 * @date 2020/3/10
 */
public class StrategyBeanFactory {

    //1.定义缓存策略bean对象map
    private static Map<String, Object> startegyBean = new ConcurrentHashMap();

    //2.定义获取策略bean方法
    public static Object getStrateyBean(String classAddress) {
        if (StringUtils.isNullOrEmpty(classAddress)) {
            return null;
        }
        if (startegyBean != null && startegyBean.get(classAddress) != null) {
            return startegyBean.get(classAddress);
        }
        try {
            Class<?> clazz = Class.forName(classAddress);
            Object bean = clazz.newInstance();
            startegyBean.put(classAddress, bean);
            return bean;
        } catch (Exception e) {
            return null;
        }
    }

}
