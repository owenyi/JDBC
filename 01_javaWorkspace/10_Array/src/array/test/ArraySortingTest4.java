package array.test;

import java.util.Random;

/*
 * Sorting - - - ����
 * ::
 * �迭�� ���� �ڷᱸ���� �־��
 * ���Ŀ� ���� �䱸������ ����ϰ� �Ͼ��.
 */
public class ArraySortingTest4 {

	public static void main(String[] args) {
		Random r = new Random();
//		int a = r.nextInt();
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10); // 0~9 ������ ������ ���� ��
		}

		System.out.println("���� �� : ");
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				int temp = 0;
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("\n���� �� : ");
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
	}

}
