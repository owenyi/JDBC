package loop.test;

import java.util.Scanner;

public class BreakTest3 {

	public static void main(String[] args) {
		// 999�� �Է��� ������ �ڿ����� �Է� �޾Ƽ� ������ ���
		Scanner sc = new Scanner(System.in);

		int n = 0;
		while (true) {
			n = sc.nextInt();
			System.out.println(n);
			if (n == 999) break;
		}
	}

}
