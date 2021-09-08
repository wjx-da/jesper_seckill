package com.liko.demo01;


import java.util.*;

public class Longest_Substring_Palindrome {
    public static void main(String[] args) {

       /* String s="ccdcccccc";
        System.out.println(longestPalindrome2(s));*/
        //["ad","ae","af","bd","be","bf","cd","ce","cf"]
        //[ad, ae, af, bd, be, bf, cd, ce, cf]
        //   System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
        //System.out.println(letterCombinations1("23"));
        //System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
       /* ListNode head=new ListNode(1);
        System.out.println(removeNthFromEnd(head, 1));*/
        // System.out.println(isValid("(]"));
    /*ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4)));
        System.out.println(mergeTwoLists(l1, l2));*/
      /*  System.out.println(generateParenthesis2(3));*/
     /*  ListNode x= new ListNode(1,new ListNode(5,new ListNode(9,new ListNode(2,new ListNode(9,new ListNode(11,new ListNode(12)))))));

        ListNode x1=new ListNode(2,new ListNode(9,new ListNode(11)));
        System.out.println(swapPairs2(x));
       ListNode[] t=new ListNode[2];
       t[0]=x;t[1]=x1;
        System.out.println(mergeKLists11(t));*/
      /*  int[] num=new int[]{0,0,0,1,1,1,2,2,3,3,4};
        int l=removeDuplicates(num);
        System.out.println(l);
        for (int i = 0; i < l; i++) {
            System.out.println(num[i]);
        }*/
        System.out.println(strStr1("mississsippi","isssi"));
    }
    public int divide(int dividend, int divisor) {
        int i = 0;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }
        long res = 543213;
        return (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) res;
    }
    public static int strStr1(String haystack, String needle) {
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
    public static int strStr(String haystack, String needle) {
        int n1=needle.length();
        if(n1==0){
            return n1;
        }

        int n=haystack.length();
        int pre=0,next=0,tail=0;
        while (pre<n){
            if(n1>n-pre){
                return -1;
            }
            if(tail==n1){
                break;
            }
            char h=haystack.charAt(pre+next);
            char h1=needle.charAt(tail);
            if(h==h1){
            next++;
            tail++;
            }else if(tail!=0&&h!=h1){
                pre++;
                next=tail=0;
            }else {
                pre++;
            }

        }
        if(pre==n||tail<n1){
          return -1;
        }
        return pre;
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int l=1;
        ListNode result=new ListNode(-1,head);
        ListNode pre=result;
        ListNode p1=null;
        ListNode t1=null;
        while(head!=null){
            if(l==k){
                p1 =pre.next;
                t1 =head.next;
                head.next=null;
                pre.next=reverseList(p1);
                pre=p1;
                p1.next=t1;
                head=t1;
                l=1;
            }else{
                l++;
                head=head.next;
            }
        }
        return result.next;
    }
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode list=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return list;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode swapPairs2(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode next=head.next;
        ListNode mid=null;
        ListNode x=next;
        while (next!=null){
            if(mid!=null){
                mid.next=next;
            }
            mid=head;
            head.next=next.next;
            next.next=mid;
            if(mid.next!=null&&mid.next.next!=null){
                head=mid.next;
                next=head.next;
            }else {
                break;
            }

        }
        return x;
    }

    public static ListNode mergeKLists11(ListNode[] lists) {
        ListNode dump = new ListNode();
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int[] keyArr = new int[2 * 10000 + 1];
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                keyArr[cur.val + 10000]++;
                cur = cur.next;
            }
        }
        ListNode temp = dump;
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == 0) {
                continue;
            } else {
                while (keyArr[i]-- > 0) {
                    temp.next = new ListNode(i - 10000);
                    temp = temp.next;
                }
            }
        }
        return dump.next;
    }

    //分治算法：
    public ListNode mergeKLists(ListNode[] lists) {
        return Divide_And_Aonquer(lists,0,lists.length-1);
    }
    public ListNode Divide_And_Aonquer(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }if(l>r){
            return null;
        }
        int mid=(r+l)>>1;
        return findHead(Divide_And_Aonquer(lists,l,mid),Divide_And_Aonquer(lists,mid+1,r));
    }
    public ListNode findHead(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return l1==null? l2:l1;
        }
        ListNode head=new ListNode(-1);
        ListNode first=head;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                first.next=l2;
                l2=l2.next;
            }else {
                first.next=l1;
                l1=l1.next;
            }
            first=first.next;
        }
        first.next=l1==null?l2:l1;
        return head.next;
      }

   static   List<String> list=new ArrayList<>();
    public static List<String> generateParenthesis2(int n) {
    add1("",n,n);
    return list;
    }
    public  static void add1(String s,int l,int r){
        if(l==0&&r==0){
            list.add(s);
            return;
        }
        if(l==r){
            add1(s+"(",l-1,r);
        }
       else if(l<r){
           if(l>0){
               add1(s+"(",l-1,r);
           }
           add1(s+")",l,r-1);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }
    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode f1=head;
    while (l1!=null&&l2!=null){
        if(l1.val<l2.val){
            f1.next=l1;

            l1=l1.next;

        }else {
            f1.next=l2;
            l2=l2.next;
        }
        f1=f1.next;
    }
   f1.next=l1==null? l2:l1;
    return head.next;
    }
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        Deque<Character> stack1 = new LinkedList<Character>();
        Map<Character,Integer> map=new HashMap<Character, Integer>(){{put('(',1);put('[',2);put('{',3);}};
        Map<Character,Integer> map1=new HashMap<Character, Integer>(){{put(')',1);put(']',2);put('}',3);}};
        char[] chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
        if(map.containsKey(c)){
            stack.push(c);
        }
            if (map1.containsKey(c)) {
                stack1.push(c);
            }
        }
        while (!stack.isEmpty()&&!stack1.isEmpty()){
            char l=stack.pop();
            int p=map.get(l);
            char l1=stack1.pop();
            int p1=map1.get(l1);
            if(p!=p1){
                stack.push(l);
                stack1.push(l1);
                break;
            }
        }
        if(!stack.isEmpty()||!stack1.isEmpty()){
            return false;
        }else {
            return true;
        }

    }
    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    Map<Integer,ListNode> map=new HashMap<>();
    int i=0;
    ListNode p=head;
    while (p!=null){
        map.put(i,p);
        p=p.next;
        i++;
    }
        ListNode target = null;
        if(i==1){
           head=null;
        }else if(i==n){
            head=head.next;
        }else {
             target=map.get(i-n-1);
             target.next=target.next.next;
        }
    return head;

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums.length<4){ return lists; }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j <nums.length-2; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l=j+1;int r=nums.length-1;
                while (l<r){
                    int total=nums[l]+nums[r]+nums[j]+nums[i];
                    if(total<target){ l++; }
                   else if(total>target){ r--; }
                   else if(total==target){
                        lists.add(Arrays.asList(nums[l],nums[r],nums[j],nums[i]));
                      /*  l++;r--;*/
                        while (l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                        while (r>l&&nums[r]==nums[r-1]){
                           r--;
                        }
                        r--;
                    }
                }
            }

        }
        return lists;
    }
        public static List<String> letterCombinations1(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
            return combinations;
        }

        public static void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                              String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || "".equals(digits)) {
            return new ArrayList<>();
        }
    Map<Integer, String[]> map=new HashMap<>();
    map.put(2,new String[]{"a","b","c"}); map.put(3,new String[]{"d","e","f"}); map.put(4,new String[]{"g","h","i"});
    map.put(5,new String[]{"j","k","l"}); map.put(6,new String[]{"m","n","o"}); map.put(7,new String[]{"p","q","r","s"});
    map.put(8,new String[]{"t","u","v"}); map.put(9,new String[]{"w","x","y","z"});
        if (digits.length() <2) {
           return Arrays.asList(map.get(Integer.parseInt(digits)));
        }
        String[] p=map.get(Integer.parseInt(digits.substring(0,1)));
        char[]chars=digits.toCharArray();

        for (int i = 1; i < digits.length(); i++) {
         p=add(p,map.get(Integer.parseInt(digits.substring(i,i+1))));
        }
    return Arrays.asList(p);
    }
    public static String[] add(String[] s1,String[] s2){
    int l=s1.length*s2.length;
    String[] ss=new String[l];
    int ll=0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
               ss[ll]=s1[i]+s2[j];ll++;
            }
        }
        return ss;
    }
    public static int threeSumClosest(int[] nums, int target) {
        /*  Arrays.sort(nums);
      int result=nums[0]+nums[1]+nums[2];
      for(int i=0;i<nums.length-2;i++){
          int l=i+1;int r=nums.length-1;
          while(l<r){
              int mid=nums[i]+nums[r]+nums[l];
              if(Math.abs(mid-target)<Math.abs(result-target)){
                  result=mid;
              }
              if(mid>target){
                  r--;
              }else if(mid<target){
                  l++;
              }else{
                  return target;
              }
          }
      }
      return result;*/
        int n=nums.length;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;//
        int reslut=0;
        for(int i=0;i<n-2;i++){
            int k=n-1;int j=i+1;
                while(j<k){
                  int  mm=nums[i]+nums[j]+nums[k]-target;
                   if(Math.abs(min)>Math.abs(mm)){
                       reslut=nums[i]+nums[j]+nums[k];
                       System.out.println(nums[i]+"  =="+nums[j]+" ===="+nums[k]);
                       min=mm;
                   }if(reslut>target){
                    k--;
                }else if(reslut<target){
                       j++;
                    }else {
                       return target;
                    }
            }
        }
        return reslut;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int total=-nums[i];
            int k=nums.length-1;
            for (int j = i+1; j <nums.length ; j++) {
                if(j>0&&nums[j]==nums[j-1]){
                    continue;
                }
                while (k>j&&nums[k]+nums[j]>total){
                    k--;
                }
                if(k==j){break;}
                if(nums[k]+nums[j]==total){
                    List<Integer> list=new ArrayList<>();
                    list.add(total);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }
        }
return lists;
    }

    public  static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        //通过这个循环将连续的一样的字符回文记录
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散，判断从这个中间开始向左右扩散判断是不是以当前位置为中心的回文
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        //和上一次的回文长度进行对比，来找出最长的回文并将其计入坐标
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        //将判断后的相同字符导致的回文的右坐标返回，下次就以这个回文的下一个为中心来向左右扩散判断是否能形成回文
        return ans;

    }
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        StringBuilder stringBuilder=new StringBuilder();
        Map<Character,Integer> map =new HashMap<>();
        char[] cc=s.toCharArray();
        char c=' ';
        for (int i = 0; i < cc.length; i++) {
            c=cc[i];
            if(map.containsKey(c)){
                int l=i;
                char ll=cc[i+1];
                int p=map.get(c);
              if(p==0&&l<cc.length-1){l+=1;}
                return String.valueOf(cc,p,l);
            }
            map.put(c,i);
        }
    return String.valueOf(cc[0]);
    }
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度，从子串长度为二开始枚举，一直到子串长度为总字符串长度，遍历判断回文
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //j-i<3表示只要是字符串小于等于3，就一定是回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                        //如果大于三，就看上一次是不是回文，若是即是，若不是即不是：
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
