package com.liko.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//贪心算法
public class GreedyTest {
    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        List<String> list=new ArrayList<>();
        HashSet<String> stringHashSet=new HashSet<>();
        String key=null;
        while (allAreas.size()!=0){
            key=null;
            for (String k:broadcasts.keySet()) {
                stringHashSet.clear();
                HashSet<String> m=broadcasts.get(k);
               stringHashSet.addAll(m);
               stringHashSet.retainAll(allAreas);
                if(stringHashSet.size() > 0 &&
                        (key == null || stringHashSet.size() >broadcasts.get(key).size())){
                    key = k;
                }
            }
            if(key!=null){
                list.add(key);
               allAreas.removeAll(broadcasts.get(key));
            }

        }
        System.out.println(list);
    }
}
