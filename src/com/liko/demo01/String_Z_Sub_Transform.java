package com.liko.demo01;public class String_Z_Sub_Transform {
    /*
     * 分析：
     * PAYPALISHIRING
     * numRows = 4
     * P   I   N             0   6    12
     * A L S I G             1 5 7 11 13
     * Y A H R               2 4 8 10
     * P   I                 3   9
     *
     * numRows = 5
     * P   H                 0   8     16    24
     * A S I                 1 7 9  15 17 23 25
     * Y I R                 2 6 10 14 18 22 26
     * P L I G               3 5 11 13 19 21 27
     * A   N                 4   12    20    28
     *
     * 首先输出头     (0 * 8    ,          , 1 * 8    ,          ,....)
     * 然后输出体     (0 * 8 + 1, 0 * 8 + 7, 1 * 8 + 1, 1 * 8 + 7,....)
     *               (0 * 8 + 2, 0 * 8 + 6, 1 * 8 + 2, 1 * 8 + 6,....)
     *               (0 * 8 + 3, 0 * 8 + 5, 1 * 8 + 3, 1 * 8 + 5,....)
     * 最后输出尾     (0 * 8 + 4,          , 1 * 8 + 4,          ,....)
     *
     * 发现规律就是：除了第一行和最后一行，中间行的列没有缺少的（最后一列除外）;
     * 将第一列和第二列看作一个整体， 原字符串s按照‘V’进行填充，把每个填满‘V’的元素看做一段（segment），
     * 那么一段的元素个数为 2 * numRows - 2(减2是因为第二列的第一行和最后一行没有元素)，
     * 每个元素都可以用a * b + c表示，并且第一列的c1和第二列的c2有c1 + c2 = segment
     * */
    public static String convert(String s, int numRows) {
        //当s的长度小于行数时，直接返回s
        //当行数为1时，也直接返回s
        if (s.length() < numRows || numRows == 1){
            return s;
        }
        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(s.length());
        // 输出头
        for (int i = 0; i * segment < s.length(); i++){
            target.append(s.charAt(i * segment));
        }
        // 输出体
        for (int i = 0; i < numRows - 2; i++){
            for (int j = 0; j * segment  + i + 1 < s.length(); j++ ){
                // 输出一段的第一列
                target.append(s.charAt(j * segment + i + 1));
                // 输出一段的第二列，首先要判断第二列对应位置是否有元素，也就是索引不能超过s的长度
                //(segment - i - 1)通过这个表达式来得出第二列相应位置上的字符下标
                if (j * segment + (segment - i - 1) < s.length()){
                    target.append(s.charAt(j * segment + (segment - i - 1)));
                }
            }
        }
        // 输出尾
        //numRows - 1得出第一列的最下面一个的下标，i * segment向右移位
        for (int i = 0; i * segment + numRows - 1 < s.length(); i++){
            target.append(s.charAt(i * segment + numRows - 1));
        }
        return target.toString();
    }
    public static String convert1(String s, int numRows) {
        if(s.isEmpty()||numRows==1){
            return s;
        }
    int totle=numRows*2-2;
    StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i*totle < s.length(); i++) {
            stringBuilder.append(s.charAt(i*totle));
        }
        for (int i = 0; i < numRows-2; i++) {
            for (int j = 0; j*totle +1+i< s.length(); j++) {
            stringBuilder.append(s.charAt(j*totle+i+1));
            if(j*totle+(totle-i-1)<s.length()){
                stringBuilder.append(s.charAt(j*totle+(totle-i-1)));
            }
            }
        }
        for (int i = 0; i*totle+numRows-1 <s.length() ; i++) {
            stringBuilder.append(s.charAt(i*totle+numRows-1));
        }//PINALSIGYAHRPAHN
         //PINALSIGYAHRPI
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows=4;
        System.out.println(convert1(s, numRows));
    }
}
