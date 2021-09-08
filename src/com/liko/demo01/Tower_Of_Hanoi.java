package com.liko.demo01;

public class Tower_Of_Hanoi {
    public static void main(String[] args) {
        hanNuoTa(3,'a','b','c');
    }



    public  static void hanNuoTa(int nums,char a,char b,char c){
        if(nums==1){
            System.out.println("第"+nums+"个盘"+a+"-->"+c);
        }else {
            hanNuoTa(nums-1,a,c,b);
            System.out.println("第"+nums+"个盘"+a+"-->"+c);
            hanNuoTa(nums-1,b,a,c);

        }
    }
}
