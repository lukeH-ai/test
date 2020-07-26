package com.load_balance.random;

import com.load_balance.IpMap;

import java.util.*;

/**
 * 随机（Random）法
 *
 * 整体代码思路和轮询法一致，先重建serverMap，再获取到server列表。在选取server的时候，
 * 通过Random的nextInt方法取0~keyList.size()区间的一个随机值，从而从服务器列表中随机获取到一台服务器地址进行返回。
 * 基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果。
 */
public class RandomRoundRobin {

    public static String getServer(){
        //重建map ,避免服务上下线导致的并发问题
        Map<String,Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        //获取ip列表
        Set<String> keySet = serverMap.keySet();
        //将ip列表放入list中，便于下标获取ip
        List<String> list = new ArrayList<String>();
        list.addAll(keySet);

        Random random = new Random();
        int randomCount = random.nextInt(list.size());
        return list.get(randomCount);
    }

}
