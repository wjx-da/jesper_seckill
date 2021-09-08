package com.liko.demo01;

import java.util.*;

/**
 * @author wjx
 */
public class Test1 {
    /*
    *   I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
*/
    public int romanToInt1(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static  int romanToInt(String s) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int nums=0;
        String s1=s;
        for (int i = 0; i < values.length; i++) {
            while (s.contains(reps[i])){
                if(s.substring(0,1).equals(reps[i])){
                    s=s.substring(1);
                    nums=nums+values[i];
                    continue;
                }
                if(i<values.length-1&&s.contains(reps[i+1])){
                    s=s.substring(2);
                    nums=nums+values[i+1];
                    i++;
                }else {
                    s=s.substring(1);
                    nums=nums+values[i];
                }
            }
        }
        return nums;
    }
    public static String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<values.length;i++){
            while (num>=values[i]) {
                stringBuilder.append(reps[i]);
                num -= values[i];
                }
            }
        return stringBuilder.toString();
    }
    public static int maxArea1(int[] height){
        int l=0;int r=height.length-1;
        int max=0;
        while (l<r){
            int h=Math.min(height[l],height[r]);
            max=Math.max(max,h*(r-l));
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
    public static int maxArea(int[] height) {
        if(height.length <= 1) {
            return -1;
        }
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if(height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return res;
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];//二维数组来记录是否匹配
        f[0][0] = true;//若两个字符串都为空，即true
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    public static boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
    public static boolean isPalindrome1(int x){
        if(x<0) { return false; }
        if(x<10){return true;}
        List<Integer> list=new ArrayList<>();
        int r=0;int l=0,p=x;
        while (x!=0){
        r=x%10;
        x=x/10;
         l=l*10+r;
        }
        if(l==p){
            return true;
        }
    return false;
    }
    public static boolean isPalindrome(int x) {
    if(x<0){return false;}
    String s=String.valueOf(x);
    StringBuilder stringBuilder=new StringBuilder();
    String s1 = stringBuilder.append(s).reverse().toString();
        System.out.println(s1+"======"+s);
    if(s.equals(s1)){
        return true;
    }
    return false;
    }
    public static void main(String[] args) {
      /*  System.out.println(Integer.MIN_VALUE==-2147483648);
        System.out.println(divide(Integer.MAX_VALUE ,-1));*/
        // System.out.println(romanToInt(  "MMCCCXCIX"));
        //System.out.println(intToRoman(1994));
        // System.out.println(maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
       /*String s = "aab" ,p = "c*a*b";
        System.out.println(isMatch(s, p));*/
        // System.out.println(isPalindrome1(121));
      /*  int [] n=new int[]{-1,0,1,1,2,-1,-1,-4};
        System.out.println(threeSum(n));*/
       /* String[] strs = {"a","a","b"};
        System.out.println(longestCommonPrefix(strs));*/
        /*String s="    -0000005000000   ";
        System.out.println(myAtoi(s));*/
       /* System.out.println(strStr(" ppsppsdppsppsdf", "ppsppsdf"));*/
  /*  int[] p = Kmptemp("ppppflspf");
        for (int y: p) {
            System.out.println(y);
        }*/
        String[] s=new String[]{"foo"};
        System.out.println(findSubstring("barfoothefoobarman", s));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,int[]> map=new HashMap<>();
        int n=words.length;
        for (int i=0;i<n;i++){
            map.put(i,Kmptemp(words[i]));
        }
        for (int i=0;i<words.length;i++){
            int[] x=map.get(i);
            int r=strStr(s,x,words[i]);
            if(r==-1){
                continue;
            }
            list.add(i);
        }
        return list;
    }
    public static int strStr(String s,int [] x,String s1){
        int n=s1.length(),m=s.length();
        if(n==0){ return 0; }
        for (int i=0,j=0;i<m;i++){
            while (j>0&&s.charAt(i)!=s1.charAt(j)){
                j=x[j-1];
            }
            if (s.charAt(i) == s1.charAt(j)) {
                j++;
            }
            if(j==n){
                return i-n-1;
            }
        }
        return -1;
    }
    public static   int[] Kmptemp(String s){
        int n=s.length();
        int[] a=new int[n];
        if(n==0){return a;}
        for (int i = 1,j=0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j=a[i-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            a[i]=j;
        }
        for (int i:a) {
            System.out.print("\t"+i);
        }
        return a;
    }
    public static   int divide(int dividend, int divisor) {
        System.out.println(dividend+"=========="+divisor);
        if(dividend==0){        return 0;          }
        if(divisor==1){         return dividend;   }
        if(divisor==-1){
            if(dividend<0){
                if(dividend==Integer.MIN_VALUE){
                    return Integer.MAX_VALUE;
                }
                return -dividend; }
            return -dividend;  }
        boolean flag=false;
        if(dividend<0&&divisor>0){       flag=true;}
        if(dividend>0&&divisor<0){       flag=true;}
        if(flag){
            dividend=(dividend<0)? -dividend:dividend;
            divisor=(divisor<0)? -divisor:divisor;
        }
        int ll=del(dividend,divisor);
        if(flag){
            return -ll;
        }
        return  ll;
    }
    public static int del(int dividend,int divisor){
        if(dividend<divisor){
            return 0;
        }
        int temp=1;
        int t=divisor;
        while((t<<1)<dividend){
            t=t<<1;
            temp++;
        }
        return temp+del(dividend-t,divisor);
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for(int p:pi){
            System.out.println(p);
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){return "";}
        boolean flag=false;
        StringBuilder stringBuilder=new StringBuilder();
        String s=strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(stringBuilder.length()!=0){
                s=stringBuilder.toString();
                flag=true;
                stringBuilder.setLength(0);
            }
            for (int j = 0; j < strs[i].length(); j++) {
            if(j<s.length()&&(s.charAt(j)==strs[i].charAt(j))){
                stringBuilder.append(s.charAt(j));
            }else {
                if(j==0){
                    s="";
                }
                break;
            }
            }
        }
        if(stringBuilder.length()!=0){
            s=stringBuilder.toString();
            flag=true;
            stringBuilder.setLength(0);
        }
        if(flag){
            return s;
        }
        return "";
    }
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (!Character.isDigit(str.charAt(0))//判断是不是数字
                && str.charAt(0) != '-' && str.charAt(0) != '+')//当第一位不是-或+号时
        {
            return 0;
        }
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';//判断第一位是不是-号不是为false
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;//判断第一位是不是数字，是就为0，
        while (i < str.length() && Character.isDigit(str.charAt(i))) {//当str为遍历玩且是数字时循环
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {//当循环期间就已经大于Integer.MAX_VALUE并且不是负数，就直接返回int最大值
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;//通过neg判断是否为正负数
    }

}
class Solution {
    public static int reverse(int x) {
       long num=0;
       while (x!=0){
           num=num*10+x%10;
           x=x/10;
       }
       return (int) num==num ? (int) num :0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-5));
    }
}

class Solution2{
    public static void main(String[] args) {
        String s="    -0000005000000   ";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    //通过map集合和数组的方式将每一次情况可能发生的时候放进去，
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
        /*	         ' '	+/-	    number	    other
        start	    start	signed	in_number	end
        signed	    end	     end	in_number	end
        in_number	end	     end	in_number	end
        end	        end	     end	end	        end
        */
    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';//c-'0'直接就取得这个c的int值，递归进行相加
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {//通过signed获取是否为负数
            sign = c == '+' ? 1 : -1;//判断是否为‘+’
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}