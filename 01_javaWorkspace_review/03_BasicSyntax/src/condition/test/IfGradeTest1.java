package condition.test;

import java.util.Scanner;

public class IfGradeTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� ���� ������ �Է��ϼ���>>>");
		int score = sc.nextInt(); // 0���� 100���� �Է�
		
		// 100~90 A 90~80 B ... 70 �Ʒ� Try Again
		if (score <= 100 && score > 90) {
			System.out.println("A grade...");
		} else if (score > 80) {
			System.out.println("B grade...");
		} else if (score > 70) {
			System.out.println("C grade...");
		} else {
			System.out.println("Try Again...!!");
		}
	}

}
