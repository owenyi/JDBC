package com.sumgo.encapsulation.test;

import java.util.Scanner;

import com.sumgo.encapsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md1 = new MyDate();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Month : ");
		int m1 = sc.nextInt();
		md1.setMonth(m1);
		
		System.out.println("Day : ");
		int d1 = sc.nextInt();
		md1.setDay(d1);
		
		System.out.println("������ " + md1.getMonth() + "�� " + md1.getDay() + "�� �Դϴ�.");
	}

}
