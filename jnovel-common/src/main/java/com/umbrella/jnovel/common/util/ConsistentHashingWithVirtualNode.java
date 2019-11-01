package com.umbrella.jnovel.common.util;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description 一致性hash算法（带虚拟节点）
 * @Author becktte
 * @Date 2019/9/19
 * @Version 1.0
 **/
public class ConsistentHashingWithVirtualNode {
    /**
     * 需要加入到hash环的服务器列表
     */
    private static String[] server = {"192.168.0.1:1010", "192.168.0.2:1010", "192.168.0.3:1010", "192.168.0.4:1010"};
    /**
     * 真实节点
     */
    private static List<String> realNodes = new LinkedList<String>();
    /**
     * 虚拟节点
     */
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();

    private static int NODE_NUMBER = 5;

    static {
        //先将服务器加入真实节点中
        for (int i = 0; i < server.length; i++) {
            realNodes.add(server[i]);
        }
        //再将虚拟节点加入真实节点中
        for (String value : realNodes) {
            for (int i = 0; i < NODE_NUMBER; i++) {
                String virtualNodeName = value + "-VN" + i;
                int hash = getHash(virtualNodeName);
                virtualNodes.put(hash, virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加，hash值为" + hash);
            }
        }
    }


    /**
     * 得到当前路由的节点
     * @param key
     * @return
     */
    private static String getServer(String key) {
        int hash = getHash(key);
        //得到大于该hash值所有的map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String server;
        if (subMap.isEmpty()) {
            //如果没有大于该hash的服务器,则从第一个node开始
            Integer i = virtualNodes.firstKey();
            server = virtualNodes.get(i);
        } else {
            //如果有的话,则取最近的一个node
            Integer i = subMap.firstKey();

            server = subMap.get(i);
        }
        return server.substring(0, server.indexOf("-VN"));
    }

    /**
     * 得到hash值
     * 使用FNV1_32_HASH算法计算hash值
     * @param key
     * @return
     */
    private static int getHash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] keys = {"月亮", "星星", "太阳"};
        for (int i = 0; i < keys.length; i++) {
            System.out.println("[" + keys[i] + "]加入到[" + getServer(keys[i]) +
                    "]服务器中，其hash值为" + getHash(keys[i]));
        }
    }
}
