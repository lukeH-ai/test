package com.load_balance;

import java.util.HashMap;
import java.util.Map;

public class IpMap {
    //带路由的IP列表 ，key代表 ip , value代码 ip 的权重
    public static Map<String, Integer> serverWeightMap = new HashMap<String, Integer>();

    //注：当前列表中的权重有重复的情况
    static {
        serverWeightMap.put("192.168.0.1", 1);
        serverWeightMap.put("192.168.0.2", 1);
        serverWeightMap.put("192.168.0.3", 1);
        serverWeightMap.put("192.168.0.4", 2);
        serverWeightMap.put("192.168.0.5", 3);
        serverWeightMap.put("192.168.0.6", 3);
        serverWeightMap.put("192.168.0.7", 3);
        serverWeightMap.put("192.168.0.8", 4);
        serverWeightMap.put("192.168.0.9", 4);
        serverWeightMap.put("192.168.0.10", 1);
    }

}
