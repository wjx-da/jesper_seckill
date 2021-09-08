package com.LRUTestDemo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wjx
 */
public class DemoLRU01<k,v> extends LinkedHashMap{
    private int capacity;
    /*true:
       *   [1=a, 2=b, 3=c]
           [2=b, 3=c, 4=d]
           [2=b, 4=d, 3=c]
           [2=b, 4=d, 3=c]
           [2=b, 4=d, 3=c]
           [4=d, 3=c, 5=e]
       *
       false:
    *       [1=a, 2=b, 3=c]
            [2=b, 3=c, 4=d]
            [2=b, 3=c, 4=d]
            [2=b, 3=c, 4=d]
            [2=b, 3=c, 4=d]
            [3=c, 4=d, 5=e]
 */
    public DemoLRU01(int capacity) {
        super(capacity, (float) 0.75,false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        DemoLRU01 demoLRU01=new DemoLRU01(3);
        demoLRU01.put(1,"a"); demoLRU01.put(2,"b"); demoLRU01.put(3,"c");
        System.out.println(demoLRU01.entrySet());
        demoLRU01.put(4,"d");
        System.out.println(demoLRU01.entrySet());
        demoLRU01.put(3,"c");
        System.out.println(demoLRU01.entrySet());
        demoLRU01.put(3,"c");
        System.out.println(demoLRU01.entrySet());
        demoLRU01.put(3,"c");
        System.out.println(demoLRU01.entrySet());
        demoLRU01.put(5,"e");
        System.out.println(demoLRU01.entrySet());
    }

}
