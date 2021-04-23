package array.test;

public class ArraySortingTest3 {

	public static void main(String[] args) {
		int[] arr = {3, 5, 7, 4, 2, 1, 6};
		
		System.out.println("Á¤·Ä Àü : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				int temp = 0;
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
				for (int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println("");
			}
		}
	}

}
