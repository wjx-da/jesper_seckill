package com.liko.demo01;

import java.util.Arrays;
import java.util.List;

public class KnapsackProblemTest {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//��Ʒ������
        int[] val = {1500, 3000, 2000}; //��Ʒ�ļ�ֵ ����val[i] ����ǰ�潲��v[i]
        int m = 4; //����������
        int n = val.length; //��Ʒ�ĸ���
        final List<int[]> ints = Arrays.asList(w);

        //nΪ������mΪ����
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
                    //����һ�α�����ֵС����μ��������Ʒ��δ����֮ǰ����Ʒ��ֵ�ܺͣ����²���¼
                   if(x[i-1][j]<val[i-1]+x[i-1][j-w[i-1]]){
                       x[i][j]=val[i-1]+x[i-1][j-w[i-1]];
                       p[i][j]=1;//��¼��ǰ���µ�ֵ����Ʒ;
                   }else {
                       x[i][j]=x[i-1][j];
                   }
                }
            }
        }
        //���һ��v ����Ŀǰ�����
        for(int i =0; i < x.length;i++) {
            for(int j = 0; j < x[i].length;j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
        //�����������Ƿ������Щ��Ʒ
        //����path, �������������еķ���������õ�, ��ʵ����ֻ��Ҫ���ķ���
        for(int i = 0; i < p.length; i++) {
            for(int j=0; j < p[i].length; j++) {
                if(p[i][j] == 1) {
                    System.out.print("path[i][j]==="+i+"===="+j);
                }

            }System.out.println();
        }
        //��ӡ��Ŀ����Ʒ��
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
