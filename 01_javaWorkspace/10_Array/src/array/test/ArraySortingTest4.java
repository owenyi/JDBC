package array.test;

import java.util.Random;

/*
 * Sorting - - - 정렬
 * ::
 * 배열과 같은 자료구조에 있어서는
 * 정렬에 대한 요구사항이 빈번하게 일어난다.
 */
public class ArraySortingTest4 {

	public static void main(String[] args) {
		Random r = new Random();
//		int a = r.nextInt();
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10); // 0~9 사이의 임의의 정수 값
		}

		System.out.println("정렬 전 : ");
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
		System.out.println("\n정렬 후 : ");
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
	}

}
