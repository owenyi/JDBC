package loop.test;

public class LoopingTest1 {

	public static void main(String[] args) {
		int[] odds = { 1, 3, 5, 7, 9 };
		
		// for������ ��� ���� ���
		System.out.println("===== for�� =====");
		for (int i = 0; i < odds.length; i++) {
			System.out.println(i + ", " + odds[i]);
		}
		
		// while������ ��� ���� ���
		System.out.println("\n===== while�� =====");
//		int i = 0;
//		while (i < odds.length) {
//			System.out.println(i + ", " + odds[i]);
//			i++;
//		}
		System.out.println("\n===== while�� �� �ٷ� �ۼ� =====");
		int i = 0;
		while (i < odds.length) System.out.println(i + ", " + odds[i++]);
	}

}