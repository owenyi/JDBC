package array.test;
// �迭 ����, ����, �ʱ�ȭ ������ �ۼ�
// for�� ����ؼ� �迭 �ȿ� ����ִ� ������ ���
public class ArrayBasicTest1 {

	public static void main(String[] args) {
		// 1. �迭 ���� + ����
		int[] arr = new int[3];
		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
		// 2. �Ҵ�
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		for (int num : arr) System.out.println(num);
	}

}