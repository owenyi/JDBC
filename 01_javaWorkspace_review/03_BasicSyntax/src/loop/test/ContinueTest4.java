package loop.test;

public class ContinueTest4 {

	public static void main(String[] args) {
		// 1부터 10까지 중 홀수만 출력하는 프로그램 작성
		// continue 사용해서 작성
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) continue;
			System.out.println(i);
		}
	}

}
