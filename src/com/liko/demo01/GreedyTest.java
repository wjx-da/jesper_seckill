package com.liko.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//̰���㷨
public class GreedyTest {
    public static void main(String[] args) {
        //�����㲥��̨,���뵽Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //��������̨���뵽broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("����");
        hashSet1.add("�Ϻ�");
        hashSet1.add("���");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("����");
        hashSet2.add("����");
        hashSet2.add("����");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("�ɶ�");
        hashSet3.add("�Ϻ�");
        hashSet3.add("����");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("�Ϻ�");
        hashSet4.add("���");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("����");
        hashSet5.add("����");

        //���뵽map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas ������еĵ���
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("����");
        allAreas.add("�Ϻ�");
        allAreas.add("���");
        allAreas.add("����");
        allAreas.add("����");
        allAreas.add("�ɶ�");
        allAreas.add("����");
        allAreas.add("����");
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
