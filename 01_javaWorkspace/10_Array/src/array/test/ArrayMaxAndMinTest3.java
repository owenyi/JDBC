package array.test;
/*
 * int Ÿ���� �迭�� �����...������ ���� ������ ���� �ִ´�.
 * ���� ���ڵ� �߿��� ���� ū ���� ���� ���� ���� ã�Ƴ��� �˰����� �ۼ�..
 * 
 */
public class ArrayMaxAndMinTest3 {

	public static void main(String[] args) {
		int[] scores = {79, 88, 91, 44, 99, 55, 96};
		
		int max = scores[0]; // �迭�� ù��° ������ �⺻ ���� �ʱ�ȭ�Ѵ�...
		int min = scores[0];
		
//		for (int i = 0; i < scores.length; i++) {
//			if (max < scores[i]) max = scores[i];
//			if (min > scores[i]) min = scores[i];
//		}
		
		// Advanced For | ForEach..."���� ��𿡼� ���°�?"
		for (int score : scores) {
			if (max < score) max = score;
			if (min > score) min = score;
		}
		
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
		System.out.println("===============================\n");
	}

}
