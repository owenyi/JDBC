package com.encore.test;

import java.util.Scanner;

public class SwitchGradeTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 시험 성적을 입력하세요>>>");
		
		int score = sc.nextInt();
		
		switch (score) {
			case 90:
			case 95:
			case 100:
				System.out.println("A..");
				break; // 얘를 주석처리하면 어떻게 될까?
			
			case 80:
			case 85:
				System.out.println("B..");
				break;
			
			case 70:
			case 75:
				System.out.println("C");
				break;
				
			default:
				System.out.println("TryAgain...");
				break;
		}

	}

}
