package loop.test;

public class ContinueTest4 {

	public static void main(String[] args) {
		// 1���� 10���� �� Ȧ���� ����ϴ� ���α׷� �ۼ�
		// continue ����ؼ� �ۼ�
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) continue;
			System.out.println(i);
		}
	}

}
