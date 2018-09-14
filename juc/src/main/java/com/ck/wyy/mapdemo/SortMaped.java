package com.ck.wyy.mapdemo;


import java.util.*;

/**
 * TreeMap继承了SortedMap  保证有序
 */
public class SortMaped {

    public static void main(String[] args) {

        Map<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("1b", "a");
        hashMap.put("2", "b");
        hashMap.put("4b", "d");
        hashMap.put("3", "c");
        hashMap.put("2b", "d");
        hashMap.put("3b", "c");
        Set<Map.Entry<String, Object>> entry = hashMap.entrySet();
        for(Map.Entry<String, Object> temp : entry){
            System.out.println("hashMap:"+temp.getKey()+" 值"+temp.getValue());
        }

        System.out.println("\n");

        SortedMap<String,Object> sortedMap = new TreeMap<String,Object>();
        sortedMap.put("1b", "a");
        sortedMap.put("2", "b");
        sortedMap.put("4b", "d");
        sortedMap.put("3", "c");
        sortedMap.put("2b", "d");
        sortedMap.put("3b", "c");

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        System.out.println(sortedMap.subMap("2", "3"));
        System.out.println(sortedMap.computeIfAbsent("2bb", k->"ss"));  //存在key=2bb则返回,否则ss
        System.out.println(sortedMap.putIfAbsent("3ba","www"));
        System.out.println(sortedMap.headMap("3"));
        System.out.println(sortedMap.tailMap("2"));


        Set<Map.Entry<String, Object>> entry2 = sortedMap.entrySet();
        for(Map.Entry<String, Object> temp : entry2){
            System.out.println("sortedMap:"+temp.getKey()+" 值"+temp.getValue());
        }

    }


}

