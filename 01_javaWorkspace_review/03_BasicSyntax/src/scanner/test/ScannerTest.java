package scanner.test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		String num2 = sc.next();
		System.out.println(num1);
		System.out.println(num2);
	}

}