package com.liko.demo01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MyTest {
    public static int lengthOfLongestSubstring1(String s) {
        int[] table=new int[128];
        Arrays.fill(table, -1);
        int sum=0;
        int target=0;
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i);
            target=Math.max(target,table[index]+1);
            sum=Math.max(sum,i-target+1);
            table[index]=i;
        }

        return sum;
    }
        public static int lengthOfLongestSubstring(String s) {
            HashMap<Integer,Integer> map=new HashMap<>();
            int sum=0;
            int target=0;
            for (int i = 0; i < s.length(); i++) {
                int index=s.charAt(i);
               target=Math.max(target,((map.containsKey(index))? map.get(index):-1)+1);
               sum=Math.max(sum,i-target+1);
               map.put(index,i);
            }

        return sum;
        }

    public static void main(String[] args) {
        String s="s sd sffad";
        System.out.println(lengthOfLongestSubstring1(s));
        /*final int[] ints = searchRange(new int[]{5,7,7,8,8,10,10}, 10);
        for (int y:ints) {
            System.out.println(y);
        }*/
        System.out.println(searchInsert(new int[]{5, 7, 7, 8, 8, 10, 10}, 10));
    }
    public static int searchInsert(int[] nums, int target) {
        int x=0,l=0,r=nums.length-1;
        while (l<r){
            x=(l+r+1)/2;
            if(nums[x]==target){
                return x;
            }
            if(nums[r]>target&&target>nums[x]){
               l=x+1;
            }
            else {
               r=x-1;
            }
        }
        return x;
    }
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public static int search(int[] nums, int target) {
        int n=nums.length;
    if(n==0){ return -1; }
    if(n==1){return nums[0]==target ? 0:-1;}
    int l=0;int r=n-1;
    while (l<r){
        int mid=(l+r)/2;
        if(nums[mid]==target){
            return mid;
        }
        if (nums[0] <= nums[mid]) {
            if(nums[0]<=target&&target<=nums[mid]){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }else {
            if(nums[n-1]>=target&&target>=nums[mid]){
                l=mid+1;
            }else {
               r=mid-1;
            }
        }
    }
    return -1;
    }
 @Test
    public void xx() {
     System.out.println(Character.isDigit('5'));
     final int[] ints = countBits(2);
     for (int y:ints
          ) {
         System.out.println(y);
     }
     String[] strings=new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
     maxProduct(strings);
 }
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] nums = new int[len];
        // 用一个 int 数字统计每个字符串里面 abcd26  个字符出现的位置 a 用 0代替 b 用 1
        // 则 abc 可以表示为 111 def 可以表示为 111000 如果不包含重复字符的字符串转换二进制后做与运算肯定为 0
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 如果两个字符串不包含相同元素 那么与运算肯定为 0
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
    public int[] countBits(int n) {
        int[] num=new int[n];
        num[0]=0;   num[1]=1;
        for(int i=2;i<n;i++){
            if(i%2==0){
                num[i]=num[i/2];
            }else{
                num[i]=num[i-1];
            }
        }
        return num;
    }
}
