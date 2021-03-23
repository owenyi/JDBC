package looping.test;
/*
 * �ݺ��� �߿��� ���� ���� ���Ǵ�
 * for���� ��� �����ϴ��� ��Ȯ�ϰ� �����Ѵ�.
 * 
 * for (�ʱ��; ���ǽ�; ������) {
 *     code block;
 * }
 */
public class LoopingBasicTest1 {

	public static void main(String[] args) {
		System.out.println("========for=======\n");
		for (int i = 0; i < 10; i++) { // ���⼭�� i ��µ� ������ �� �� ������? ������ i�� �� code block�� ������ �����
			System.out.println("Hello for Looping..." + i);
		}

		System.out.println("\n========while=======\n");
		int i = 0;
		while (i < 10) {
			System.out.println("Hello while Looping..." + i);
			i++;
		}
		
		System.out.println("\n========do while=======\n");
		int j = 10;
		do {
			System.out.println(j + "...Always Print...");
			j++;
		} while (j < 10);
	}

}
