package loop.test;

public class LoopingTest1 {

	public static void main(String[] args) {
		int[] odds = { 1, 3, 5, 7, 9 };
		
		// for문으로 모든 원소 출력
		System.out.println("===== for문 =====");
		for (int i = 0; i < odds.length; i++) {
			System.out.println(i + ", " + odds[i]);
		}
		
		// while문으로 모든 원소 출력
		System.out.println("\n===== while문 =====");
//		int i = 0;
//		while (i < odds.length) {
//			System.out.println(i + ", " + odds[i]);
//			i++;
//		}
		System.out.println("\n===== while문 한 줄로 작성 =====");
		int i = 0;
		while (i < odds.length) System.out.println(i + ", " + odds[i++]);
	}

}