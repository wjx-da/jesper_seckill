package com.liko.demo01;

import java.util.Arrays;
import java.util.List;

public class KnapsackProblemTest {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值 这里val[i] 就是前面讲的v[i]
        int m = 4; //背包的容量
        int n = val.length; //物品的个数
        final List<int[]> ints = Arrays.asList(w);

        //n为个数，m为容量
       int[][] x=new int[n+1][m+1];
       int[][] p=new int[n+1][m+1];
        Arrays.fill(x[0], 0);
        for (int i = 0; i < x.length; i++) {
            x[i][0]=0;
        }
        for (int i=1;i< x.length;i++){
            for (int j =1; j < x[0].length; j++) {
                if(w[i-1]>j){
                    x[i][j]=x[i-1][j];
                }else {
                    //当上一次背包价值小于这次加入这个物品和未放入之前的物品价值总和，更新并记录
                   if(x[i-1][j]<val[i-1]+x[i-1][j-w[i-1]]){
                       x[i][j]=val[i-1]+x[i-1][j-w[i-1]];
                       p[i][j]=1;//记录当前更新的值和物品;
                   }else {
                       x[i][j]=x[i-1][j];
                   }
                }
            }
        }
        //输出一下v 看看目前的情况
        for(int i =0; i < x.length;i++) {
            for(int j = 0; j < x[i].length;j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
        //输出最后我们是放入的哪些商品
        //遍历path, 这样输出会把所有的放入情况都得到, 其实我们只需要最后的放入
        for(int i = 0; i < p.length; i++) {
            for(int j=0; j < p[i].length; j++) {
                if(p[i][j] == 1) {
                    System.out.print("path[i][j]==="+i+"===="+j);
                }

            }System.out.println();
        }
        //打印出目标商品：
        int i= p.length-1;
        int j=p[0].length-1;
        while (i>0&&j>0){
            if(p[i][j]==1){
                j-=w[i-1];
                System.out.println(i);
            }
            i--;
        }
    }
}
