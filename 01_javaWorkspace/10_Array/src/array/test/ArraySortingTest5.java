package array.test;

import java.util.Arrays;
import java.util.Random;

public class ArraySortingTest5 {

	public static void main(String[] args) {
		Random r = new Random();
//		int a = r.nextInt();
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10); // 0~9 ������ ������ ���� ��
		}

		System.out.println("���� �� : ");
		for (int x : arr) System.out.print(x + " ");
		
		// ~Test4���� ���� for���� ����ؼ� Bubble Sorting�ϴ� ������ ������ ���������� ������ �� �Լ��� �ٷ� ���
		Arrays.sort(arr);
		
		System.out.println("\n���� �� : ");
		for (int x : arr) System.out.print(x + " ");
	}

}
