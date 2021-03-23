package com.encore.capsulation.test;

import java.util.Scanner;

import com.encore.capsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md1 = new MyDate();
//		md.month = 13; // 13월이 없음
//		md.day = 33; // 33일이 없음
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Month : ");
		int m1 = sc.nextInt();
		md1.setMonth(m1);

		System.out.print("Day : ");
		int d1 = sc.nextInt();
		md1.setDay(d1);
		
		System.out.println(md1);
		
		System.out.println("오늘은 " + md1.getMonth() + "월 " + md1.getDay() + "일 입니다.");


		MyDate md2 = new MyDate();
		// day를 먼저 입력
		System.out.print("Day : ");
		int d2 = sc.nextInt();
		md2.setDay(d2);

		System.out.print("Month : ");
		int m2 = sc.nextInt();
		md2.setMonth(m2);
		
		System.out.println("오늘은 " + md2.getMonth() + "월 " + md2.getDay() + "일 입니다.");
	}
}
