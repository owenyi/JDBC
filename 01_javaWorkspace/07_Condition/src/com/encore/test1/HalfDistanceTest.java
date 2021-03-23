package com.encore.test1;

import java.util.Scanner;

public class HalfDistanceTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("kim's�� �Ÿ��� lim's�� �Ÿ��� �Է����ּ��� : ");
		int kims = sc.nextInt();
		int lims = sc.nextInt();
		
		System.out.println("������ Ƚ�� : ");
		int result = halfDistance(kims, lims);
		System.out.println(result);
	}

	private static int halfDistance(int kims, int lims) {
		if (kims != lims) return 1;
		else {
			int count = 0;
			while (kims != 1) { // 1�� �� ������
				count += 1;
				kims -= kims / 2; // 9 -> 9 - 4 = 5 -> 5 - 2 = 3 -> 3 - 1 = 2 -> 2 - 1 = 1
			}
			return count;
		}
	}

}
