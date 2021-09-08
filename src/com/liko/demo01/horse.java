package com.liko.demo01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import static javafx.scene.input.KeyCode.Y;

public class horse {
    //這個棋盤是從左上角開始算的
    // 棋盘的列数
    private static int X;
    // 棋盘的行数
    private static int Y;
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean[] visited;
    //使用一个属性，标记是否棋盘的所有位置都被访问
    private static boolean finished; // 如果为true,表示成功
    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");
        //测试骑士周游算法是否正确
        X = 6;
        Y = 6;
        Random l=new Random();

        int row = l.nextInt(5)+1; //马儿初始位置的行，从1开始编号
        int column = l.nextInt(5)+1; //马儿初始位置的列，从1开始编号
        System.out.println("第"+row+"行==第"+column+"列");

        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];//初始值都是false
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard1(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    private static void traversalChessboard1(int[][] chessboard, int i, int j, int i2) {
        //记录棋盘上哪一步
        chessboard[i][j]=i2;
        //设置这个位置已访问
        visited[i*X+j]=true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next1(new Point(i, j));
        //对ps进行排序,排序的规则就是对ps的所有的Point对象的下一步的位置的数目，进行非递减排序
        sort(ps);
        while(!ps.isEmpty()) {
            Point p = ps.remove(0);//取出下一个可以走的位置
            //判断该点是否已经访问过
            if(!visited[p.y * X + p.x]) {//说明还没有访问过
                traversalChessboard1(chessboard, p.y, p.x, i2 + 1);
            }
        }
        //判断马儿是否完成了任务，使用   step 和应该走的步数比较 ，
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        //说明: step < X * Y  成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if(i2 < X * Y && !finished ) {
            chessboard[i][j] = 0;
            visited[i * X + j] = false;
        } else {
            finished = true;
        }

    }

    private static ArrayList<Point> next1(Point point) {
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if((p1.x = point.x -2) >= 0 && (p1.y = point.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if((p1.x = point.x - 1) >=0 && (p1.y=point.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = point.x + 1) < X && (p1.y = point.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = point.x + 2) < X && (p1.y = point.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = point.x + 2) < X && (p1.y = point.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = point.x + 1) < X && (p1.y = point.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = point.x - 1) >= 0 && (p1.y = point.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = point.x - 2) >= 0 && (p1.y = point.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }
    //根据当前这个一步的所有的下一步的选择位置，进行非递减排序, 减少回溯的次数
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                //获取到o1的下一步的所有位置个数
                int count1 = next1(o1).size();
                //获取到o2的下一步的所有位置个数
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
