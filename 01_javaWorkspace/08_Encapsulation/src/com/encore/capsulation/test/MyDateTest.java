package com.encore.capsulation.test;

import java.util.Scanner;

import com.encore.capsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md1 = new MyDate();
//		md.month = 13; // 13���� ����
//		md.day = 33; // 33���� ����
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Month : ");
		int m1 = sc.nextInt();
		md1.setMonth(m1);

		System.out.print("Day : ");
		int d1 = sc.nextInt();
		md1.setDay(d1);
		
		System.out.println(md1);
		
		System.out.println("������ " + md1.getMonth() + "�� " + md1.getDay() + "�� �Դϴ�.");


		MyDate md2 = new MyDate();
		// day�� ���� �Է�
		System.out.print("Day : ");
		int d2 = sc.nextInt();
		md2.setDay(d2);

		System.out.print("Month : ");
		int m2 = sc.nextInt();
		md2.setMonth(m2);
		
		System.out.println("������ " + md2.getMonth() + "�� " + md2.getDay() + "�� �Դϴ�.");
	}
}
