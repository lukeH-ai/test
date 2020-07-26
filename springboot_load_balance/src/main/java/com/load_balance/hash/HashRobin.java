package com.load_balance.hash;

import com.load_balance.IpMap;

import java.util.*;

/**
 * 源地址哈希（Hash）法
 *
 * 源地址哈希法的优点在于：保证了相同客户端IP地址将会被哈希到同一台后端服务器，直到后端服务器列表变更。
 * 根据此特性可以在服务消费者与服务提供者之间建立有状态的session会话。
 *
 * 源地址哈希算法的缺点在于：除非集群中服务器的非常稳定，基本不会上下线，否则一旦有服务器上线、下线，
 * 那么通过源地址哈希算法路由到的服务器是服务器上线、下线前路由到的服务器的概率非常低，如果是session则取不到session，
 * 如果是缓存则可能引发"雪崩"。如果这么解释不适合明白，可以看我之前的一篇文章MemCache超详细解读，一致性Hash算法部分。
 */
public class HashRobin {

    public static String getServer(String remoteIp) {
        //重建map ,避免服务上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        //获取ip列表
        Set<String> keySet = serverMap.keySet();
        //将ip列表放入list中，便于下标获取ip
        List<String> list = new ArrayList<String>();
        list.addAll(keySet);
        int code = remoteIp.hashCode();
        int size = list.size();
        //取模方式从list中获取值
        int pos = code % size;
        System.out.println("取模下标为： " + pos);
        return list.get(pos);
    }

}
