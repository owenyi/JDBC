package condition.test;

import java.util.Scanner;

public class SwitchGradeTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� ���� ������ �Է��ϼ���>>>");
		int score = sc.nextInt(); // 0���� 100���� �Է�
		
		switch ((int) (score - 1) / 10) {
//			case 100:
//			case 95:
			case 9:
				System.out.println("A");
				break;
		
//			case 90:
//			case 85:
			case 8:
				System.out.println("B");
				break;

//			case 80:
//			case 75:
			case 7:
				System.out.println("C");
				break;
			
			default:
				System.out.println("Try Again...");
				break;
		}
	}

}
