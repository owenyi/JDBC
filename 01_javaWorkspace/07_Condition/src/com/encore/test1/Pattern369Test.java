package com.encore.test1;

import java.util.Scanner;

public class Pattern369Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		boolean first = num / 10 % 3 == 0; // 첫번째 자리가 3의 배수이면 true 아니면 false
		boolean second = num % 10 % 3 == 0;// 두번째 자리가 ...
		
		System.out.print("결과 : ");
		if (first && second) System.out.println("@@");
		else if (first || second) System.out.println("@");
		else System.out.println(num);
	}

}
