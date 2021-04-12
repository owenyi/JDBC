package array.test;

public class ArrayTest {

	public static void main(String[] args) {
		int[] odds = { 1, 3, 5, 7, 9 };
		String[] weeks = { "월", "화", "수", "목", "금", "토", "일" };
		System.out.println(odds[2]); // 5
//		System.out.println(weeks[7]); // error
		System.out.println(odds.length);
	}

}
