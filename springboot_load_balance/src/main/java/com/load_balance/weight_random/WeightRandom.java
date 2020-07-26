package com.load_balance.weight_random;

import com.load_balance.IpMap;

import java.util.*;

/**
 * 加权随机（Weight Random）法
 * <p>
 * 与轮询法类似，只是在获取服务器地址之前增加了一段权重计算的代码，根据权重的大小，
 * 将地址重复地增加到服务器地址列表中，权重越大，该服务器每轮所获得的请求数量越多。
 */
public class WeightRandom {

    private static Integer pos = 0;

    /**
     * 通过将地址重复的增加到服务地址列表，占用内存的方式获取ip
     * @return
     */
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
        Random random = new Random();
        int randomCount = random.nextInt(list.size());
        return list.get(randomCount);
    }

    /**
     *     不占用内存通过权重划分概率区间进行获取ip
     */
    public static String getServerByWeight() {

        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        List<String> list = new ArrayList<String>();
        list.addAll(keySet);

        int random = -1;
        try {
            //计算总权重
            double sumWeight = 0;
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                sumWeight += serverMap.get(iterator.next());
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for (int i = 0; i < list.size(); i++) {
                d2 += Double.parseDouble(String.valueOf(serverMap.get(list.get(i)))) / sumWeight;
                if (i == 0) {
                    d1 = 0;
                } else {
                    d1 += Double.parseDouble(String.valueOf(serverMap.get(list.get(i - 1)))) / sumWeight;
                }
                if (randomNumber >= d1 && randomNumber <= d2) {
                    random = i;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("生成机数出错，出错原因：" + e.getMessage());
        }

        return list.get(random);
    }



}
