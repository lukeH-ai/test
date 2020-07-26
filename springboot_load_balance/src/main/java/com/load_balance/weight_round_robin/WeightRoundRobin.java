package com.load_balance.weight_round_robin;

import com.load_balance.IpMap;

import java.util.*;

/**
 * 加权轮询（Weight Round Robin）法
 * <p>
 * 与轮询法类似，只是在获取服务器地址之前增加了一段权重计算的代码，根据权重的大小，
 * 将地址重复地增加到服务器地址列表中，权重越大，该服务器每轮所获得的请求数量越多。
 */
public class WeightRoundRobin {

    private static Integer pos = 0;

    public static String getServer() {
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        List<String> list = new ArrayList<String>();
        String server = null;
        while (iterator.hasNext()) {
            server = iterator.next();
            for (int i = 0; i < serverMap.get(server); i++) {
                list.add(server);
            }
        }

        synchronized (pos) {
            if (pos > list.size()) {
                pos = 0;
            }
            server = list.get(pos);
            pos++;
        }

        return server;
    }

}
