package com.encore.test1;

import java.util.Scanner;

public class Pattern369Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		boolean first = num / 10 % 3 == 0; // ù��° �ڸ��� 3�� ����̸� true �ƴϸ� false
		boolean second = num % 10 % 3 == 0;// �ι�° �ڸ��� ...
		
		System.out.print("��� : ");
		if (first && second) System.out.println("@@");
		else if (first || second) System.out.println("@");
		else System.out.println(num);
	}

}
