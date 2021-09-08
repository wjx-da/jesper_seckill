package com.liko.demo01;public class String_Z_Sub_Transform {
    /*
     * ������
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
     * �������ͷ     (0 * 8    ,          , 1 * 8    ,          ,....)
     * Ȼ�������     (0 * 8 + 1, 0 * 8 + 7, 1 * 8 + 1, 1 * 8 + 7,....)
     *               (0 * 8 + 2, 0 * 8 + 6, 1 * 8 + 2, 1 * 8 + 6,....)
     *               (0 * 8 + 3, 0 * 8 + 5, 1 * 8 + 3, 1 * 8 + 5,....)
     * ������β     (0 * 8 + 4,          , 1 * 8 + 4,          ,....)
     *
     * ���ֹ��ɾ��ǣ����˵�һ�к����һ�У��м��е���û��ȱ�ٵģ����һ�г��⣩;
     * ����һ�к͵ڶ��п���һ�����壬 ԭ�ַ���s���ա�V��������䣬��ÿ��������V����Ԫ�ؿ���һ�Σ�segment����
     * ��ôһ�ε�Ԫ�ظ���Ϊ 2 * numRows - 2(��2����Ϊ�ڶ��еĵ�һ�к����һ��û��Ԫ��)��
     * ÿ��Ԫ�ض�������a * b + c��ʾ�����ҵ�һ�е�c1�͵ڶ��е�c2��c1 + c2 = segment
     * */
    public static String convert(String s, int numRows) {
        //��s�ĳ���С������ʱ��ֱ�ӷ���s
        //������Ϊ1ʱ��Ҳֱ�ӷ���s
        if (s.length() < numRows || numRows == 1){
            return s;
        }
        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(s.length());
        // ���ͷ
        for (int i = 0; i * segment < s.length(); i++){
            target.append(s.charAt(i * segment));
        }
        // �����
        for (int i = 0; i < numRows - 2; i++){
            for (int j = 0; j * segment  + i + 1 < s.length(); j++ ){
                // ���һ�εĵ�һ��
                target.append(s.charAt(j * segment + i + 1));
                // ���һ�εĵڶ��У�����Ҫ�жϵڶ��ж�Ӧλ���Ƿ���Ԫ�أ�Ҳ�����������ܳ���s�ĳ���
                //(segment - i - 1)ͨ��������ʽ���ó��ڶ�����Ӧλ���ϵ��ַ��±�
                if (j * segment + (segment - i - 1) < s.length()){
                    target.append(s.charAt(j * segment + (segment - i - 1)));
                }
            }
        }
        // ���β
        //numRows - 1�ó���һ�е�������һ�����±꣬i * segment������λ
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
