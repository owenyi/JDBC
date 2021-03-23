package com.encore.test1;

import java.util.Scanner;

public class CatchAMouseTest {

	private static String algoSolv(int catA, int catB, int mouse) {
		int distanceA = Math.abs(mouse - catA);
		int distanceB = Math.abs(mouse - catB);
		
		if (distanceA < distanceB) {
			return "CatA Catch!";
		} else if (distanceB < distanceA) {
			return "CatB Catch!";
		} else {
			return "Mouse Escapes";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("고양이 A, B, 쥐의 위치를 입력하세요 : ");
		
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		String result = algoSolv(catA, catB, mouse);
		System.out.println(result);
	}

}
