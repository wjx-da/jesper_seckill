package com.liko.demo01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maximum_Non_repetitive_Substring {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    /*输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*/
    public static int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);//通过字符assic来获得数组下标
            //通过 last[index] + 1来得出字符出现的位置在字符串中，和上一次的位置对比，
            //若位置发生更新时因为数组全部初始化为-1，因此start不变，若位置不变，start+1并更新start
            start = Math.max(start, last[index] + 1);
            // 通过i - start + 1来得出距离上次出现重复字符的循环次数，并和出现重复字符之前的
            //上一次不重复字符串长度对比，并更新
            res   = Math.max(res, i - start + 1);
            last[index] = i;//记录字符出现在字符串中的位置记住，以便下一次遇到重复字符时运算start
        }
        return res;
    }

    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            //查找map中是否有s.charAt(i)，若有就返回下标，若没有就返回-1
            int index = map.getOrDefault(s.charAt(i), -1);
            //通过从map中获取的下标+1来和上一次的下标来对比，若这次取得的字符在map中取得，说明
            //重复字符串，记录上一次的字符下标，否则l还是上一次的下标
            l = Math.max(l, index + 1);
            //通过i-l+1来获得这次无重复字符串长度并和上一次的无重复字符串长度进行对比，来取最大值
            maxL = Math.max(maxL, i - l + 1);
            map.put(s.charAt(i), i);//将该字符存入map中并更新下标，以便下一循环取下标
        }
        return maxL;//返回目标字符串中不含有重复字符的"最长子串"的长度。
    }
    public static void main(String[] args) {
        String s="  00000";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
