package com.liko.demo01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import static javafx.scene.input.KeyCode.Y;

public class horse {
    //�@����P�Ǐ����Ͻ��_ʼ���
    // ���̵�����
    private static int X;
    // ���̵�����
    private static int Y;
    //����һ�����飬������̵ĸ���λ���Ƿ񱻷��ʹ�
    private static boolean[] visited;
    //ʹ��һ�����ԣ�����Ƿ����̵�����λ�ö�������
    private static boolean finished; // ���Ϊtrue,��ʾ�ɹ�
    public static void main(String[] args) {
        System.out.println("��ʿ�����㷨����ʼ����~~");
        //������ʿ�����㷨�Ƿ���ȷ
        X = 6;
        Y = 6;
        Random l=new Random();

        int row = l.nextInt(5)+1; //�����ʼλ�õ��У���1��ʼ���
        int column = l.nextInt(5)+1; //�����ʼλ�õ��У���1��ʼ���
        System.out.println("��"+row+"��==��"+column+"��");

        //��������
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];//��ʼֵ����false
        //����һ�º�ʱ
        long start = System.currentTimeMillis();
        traversalChessboard1(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("����ʱ: " + (end - start) + " ����");

        //������̵�������
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    private static void traversalChessboard1(int[][] chessboard, int i, int j, int i2) {
        //��¼��������һ��
        chessboard[i][j]=i2;
        //�������λ���ѷ���
        visited[i*X+j]=true;
        //��ȡ��ǰλ�ÿ����ߵ���һ��λ�õļ���
        ArrayList<Point> ps = next1(new Point(i, j));
        //��ps��������,����Ĺ�����Ƕ�ps�����е�Point�������һ����λ�õ���Ŀ�����зǵݼ�����
        sort(ps);
        while(!ps.isEmpty()) {
            Point p = ps.remove(0);//ȡ����һ�������ߵ�λ��
            //�жϸõ��Ƿ��Ѿ����ʹ�
            if(!visited[p.y * X + p.x]) {//˵����û�з��ʹ�
                traversalChessboard1(chessboard, p.y, p.x, i2 + 1);
            }
        }
        //�ж�����Ƿ����������ʹ��   step ��Ӧ���ߵĲ����Ƚ� ��
        //���û�дﵽ���������ʾû��������񣬽�����������0
        //˵��: step < X * Y  ���������������
        //1. ���̵�Ŀǰλ��,��Ȼû������
        //2. ���̴���һ�����ݹ���
        if(i2 < X * Y && !finished ) {
            chessboard[i][j] = 0;
            visited[i * X + j] = false;
        } else {
            finished = true;
        }

    }

    private static ArrayList<Point> next1(Point point) {
        ArrayList<Point> ps = new ArrayList<Point>();
        //����һ��Point
        Point p1 = new Point();
        //��ʾ���������5���λ��
        if((p1.x = point.x -2) >= 0 && (p1.y = point.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������6���λ��
        if((p1.x = point.x - 1) >=0 && (p1.y=point.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //�ж����������7���λ��
        if ((p1.x = point.x + 1) < X && (p1.y = point.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������0���λ��
        if ((p1.x = point.x + 2) < X && (p1.y = point.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������1���λ��
        if ((p1.x = point.x + 2) < X && (p1.y = point.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������2���λ��
        if ((p1.x = point.x + 1) < X && (p1.y = point.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������3���λ��
        if ((p1.x = point.x - 1) >= 0 && (p1.y = point.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������4���λ��
        if ((p1.x = point.x - 2) >= 0 && (p1.y = point.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }
    //���ݵ�ǰ���һ�������е���һ����ѡ��λ�ã����зǵݼ�����, ���ٻ��ݵĴ���
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                //��ȡ��o1����һ��������λ�ø���
                int count1 = next1(o1).size();
                //��ȡ��o2����һ��������λ�ø���
                int count2 = next1(o2).size();
                if(count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }

        });
    }
}
