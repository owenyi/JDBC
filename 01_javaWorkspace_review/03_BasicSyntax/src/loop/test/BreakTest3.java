package loop.test;

import java.util.Scanner;

public class BreakTest3 {

	public static void main(String[] args) {
		// 999를 입력할 때까지 자연수를 입력 받아서 내용을 출력
		Scanner sc = new Scanner(System.in);

		int n = 0;
		while (true) {
			n = sc.nextInt();
			System.out.println(n);
			if (n == 999) break;
		}
	}

}
