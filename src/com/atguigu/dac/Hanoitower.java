package com.atguigu.dac;

public class Hanoitower {

	public static void main(String[] args) {
		hanoiTower(4, 'A', 'B', 'C',0);
	}
	
	//��ŵ�����ƶ��ķ���
	//ʹ�÷����㷨
	
	public static void hanoiTower(int num, char a, char b, char c,int x) {
		//���ֻ��һ����
		if(num == 1) {
			System.out.println("��1���̴� " + a + "->" + c);
			x++;
			System.out.println(x);
		} else {
			//��������� n >= 2 ������������ǿ��Կ����������� 1.���±ߵ�һ���� 2. �����������
			//1. �Ȱ� ������������� A->B�� �ƶ����̻�ʹ�õ� c
			hanoiTower(num - 1, a, c, b,x);
			//2. �����±ߵ��� A->C
			System.out.println("��" + num + "���̴� " + a + "->" + c);
			x++;
			//3. ��B���������� �� B->C , �ƶ�����ʹ�õ� a��  
			hanoiTower(num - 1, b, a, c,x);
			
		}
	}

}
