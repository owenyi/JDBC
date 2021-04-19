package condition.test;

import java.util.Scanner;

public class SwitchGradeTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 시험 성적을 입력하세요>>>");
		int score = sc.nextInt(); // 0부터 100까지 입력
		
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
