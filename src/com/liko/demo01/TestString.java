package com.liko.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {
    public static void main(String[] args) {
        String p="aasdffg";
        System.out.println(p.indexOf("tdff"));
        String[] s=new String[]{"foo","bar"};
        System.out.println(solution2("barfoothefoobarman",s));
        int[] nums={4,5,2,6,3,1};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int s=0,j=0;
        boolean sp=false;
        for (int i = n - 1; i > 0; i--) {
            if(sp){
            if(nums[i]>nums[j]){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                swap(nums,n-1,++j);
                return;
            }
            }else {
                if (nums[i] > nums[i-1]) {
                    sp=true;
                    j=i-1;
                    i=n;
            }
            }
        }
        swap(nums,n-1,0);
    }
    public static void swap(int[] nums, int i, int j){
        while (j<i){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i--;j++;
        }
    }
    public static List<Integer> solution2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        if (s.length() == 0 || words.length == 0) return res;
        // ����s��û��������ʣ�ֱ�ӷ��ؿ��ַ���
        for (String word: words) {
            if (s.indexOf(word) < 0) return res;
            // map�б���ÿ�����ʣ��������ֵĴ���
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        // ÿ�����ʵĳ��ȣ� �ܳ���
        int oneLen = words[0].length(), wordsLen = oneLen * words.length;
        // ����s����С�ڵ����ܺͣ����ؿ�
        if (wordsLen > s.length()) return res;
        // ֻ���۴�0��1��...�� oneLen-1 ��ʼ���Ӵ������
        // ÿ�ν���ƥ��Ĵ��ڴ�СΪ wordsLen��ÿ�κ���һ�����ʳ��ȣ������Ҵ���ά�ֵ�ǰ����λ��
        for (int i = 0; i < oneLen; ++i) {
            // ���Ҵ���
            int left = i, right = i, count = 0;
            // ͳ��ÿ������Ҫ���word
            Map<String, Integer> subMap = new HashMap<>();
            // �Ҵ��ڲ��ܳ�����������
            while (right + oneLen <= s.length()) {
                // �õ�һ������
                String word = s.substring(right, right + oneLen);
                // �д�������
                right += oneLen;
                // words[]��û��������ʣ���ô��ǰ���ڿ϶�ƥ��ʧ�ܣ�ֱ�����Ƶ�������ʺ���
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    // �����ڵ���ͳ��map��գ�����ͳ��
                    subMap.clear();
                    // ����Ҫ��ĵ�������0
                    count = 0;
                } else {
                    // ͳ�Ƶ�ǰ�Ӵ���������ʳ��ֵĴ���
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;
                    // ���������ʳ��ֵĴ�������words[]������Ӧ�Ĵ�����������ÿ��ƥ���words������ȵ��Ӵ�
                    // �� ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                    // �ڶ���bar��Ȼ��words[]�еĵ��ʣ����Ǵ������ˣ���ô����һ�����ʳ��Ⱥ� "|barfoobarfoo|the"
                    // bar���ǲ����ϣ�����ֱ�Ӵ���������ϵ�bar֮��ʼƥ�䣬Ҳ���ǽ���������ϵ�bar����֮ǰ�ĵ���(��)ȫ�Ƴ�ȥ
                    while (subMap.getOrDefault(word, 0) > wordsMap.getOrDefault(word, 0)) {
                        // �ӵ�ǰ�����ַ�ͳ��map��ɾ�����󴰿ڿ�ʼ���������޵����е���(������һ)
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        // ���ϵĵ�������һ
                        --count;
                        // �󴰿�λ������
                        left += oneLen;
                    }
                    // ��ǰ�����ַ�������Ҫ��
                    if (count == words.length) res.add(left);
                }
            }
        }
        return res;
    }
}