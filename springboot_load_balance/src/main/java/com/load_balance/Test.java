package com.load_balance;

import com.load_balance.hash.HashRobin;
import com.load_balance.random.RandomRoundRobin;
import com.load_balance.round_robin.RoundRobin;
import com.load_balance.weight_random.WeightRandom;
import com.load_balance.weight_round_robin.WeightRoundRobin;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            testRoundRobin();
//            testRandomRoundRobin();
//            testWeightRoundRobin();
//            testWeightRandomRobin();
            testWeightRandomRobinByWeight();
        }
//        testHashRobin();
    }

    public static void testRoundRobin() {
        System.out.println("轮训负载均衡算法动态获取ip: " + RoundRobin.getServer());
    }

    public static void testRandomRoundRobin() {
        System.out.println("随机轮训负载均衡算法动态获取ip: " + RandomRoundRobin.getServer());
    }

    public static void testHashRobin() {
        List<String> list = new ArrayList<String>();
        list.add("192.168.1.1");
        list.add("192.168.1.2");
        list.add("192.168.1.3");
        list.add("192.168.1.4");
        list.add("192.168.1.5");
        list.add("192.168.1.6");
        list.add("192.168.1.7");
        list.add("192.168.1.8");
        list.add("192.168.1.9");
        list.add("192.168.1.10");
        list.add("192.168.1.11");
        list.add("192.168.1.12");
        list.add("192.168.1.13");

        for (String ip : list) {
            System.out.println("hash取模负载均衡算法动态获取ip: " + HashRobin.getServer(ip));
        }
    }

    public static void testWeightRandomRobin() {
        System.out.println("权重随机负载均衡算法动态获取ip: " + WeightRandom.getServer());
    }

    public static void testWeightRandomRobinByWeight() {
        System.out.println("权重随机<权重概率区间抽取>负载均衡算法动态获取ip: " + WeightRandom.getServerByWeight());
    }

    public static void testWeightRoundRobin() {
        System.out.println("权重轮训负载均衡算法动态获取ip: " + WeightRoundRobin.getServer());
    }
}
