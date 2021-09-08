package com.liko.demo01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maximum_Non_repetitive_Substring {
    //����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ���
    /*����: s = "abcabcbb"
    ���: 3
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
    ����: s = "bbbbb"
    ���: 1
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
*/
    public static int lengthOfLongestSubstring1(String s) {
        // ��¼�ַ���һ�γ��ֵ�λ��
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // ���ڿ�ʼλ��
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);//ͨ���ַ�assic����������±�
            //ͨ�� last[index] + 1���ó��ַ����ֵ�λ�����ַ����У�����һ�ε�λ�öԱȣ�
            //��λ�÷�������ʱ��Ϊ����ȫ����ʼ��Ϊ-1�����start���䣬��λ�ò��䣬start+1������start
            start = Math.max(start, last[index] + 1);
            // ͨ��i - start + 1���ó������ϴγ����ظ��ַ���ѭ�����������ͳ����ظ��ַ�֮ǰ��
            //��һ�β��ظ��ַ������ȶԱȣ�������
            res   = Math.max(res, i - start + 1);
            last[index] = i;//��¼�ַ��������ַ����е�λ�ü�ס���Ա���һ�������ظ��ַ�ʱ����start
        }
        return res;
    }

    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            //����map���Ƿ���s.charAt(i)�����оͷ����±꣬��û�оͷ���-1
            int index = map.getOrDefault(s.charAt(i), -1);
            //ͨ����map�л�ȡ���±�+1������һ�ε��±����Աȣ������ȡ�õ��ַ���map��ȡ�ã�˵��
            //�ظ��ַ�������¼��һ�ε��ַ��±꣬����l������һ�ε��±�
            l = Math.max(l, index + 1);
            //ͨ��i-l+1�����������ظ��ַ������Ȳ�����һ�ε����ظ��ַ������Ƚ��жԱȣ���ȡ���ֵ
            maxL = Math.max(maxL, i - l + 1);
            map.put(s.charAt(i), i);//�����ַ�����map�в������±꣬�Ա���һѭ��ȡ�±�
        }
        return maxL;//����Ŀ���ַ����в������ظ��ַ���"��Ӵ�"�ĳ��ȡ�
    }
    public static void main(String[] args) {
        String s="  00000";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
