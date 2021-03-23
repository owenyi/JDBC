package array.test;
/*
 * �迭�� ���� + ���� + �ʱ�ȭ ... �Ѳ�����
 * --> �� ����� �� ���� ����մϴ�.
 * 
 * �迭�� Ư¡
 *   1. �迭�� ReSizing �� �� ����.
 *      ó�� ���� ����� �����ϰ� �Ǹ�
 *      ���ο� �迭�� �ϳ� �����ȴ�.
 *      
 *   2. �迭�� ��ü��.
 *      new Ű���带 ���ؼ� ����..Heap�� �ö󰣴�.
 *      ������ Class Type�� �������� �ʴ´�.
 *      length��� �ʵ带 �ݵ�� �������
 *      �迭 ���� �������� ������ �����ϴ� �ʵ忡 �ش��Ѵ�.
 *      
 *   3. �迭�� ReSizing�� �ȵ�����
 *      ����� �ٸ� �迭�� �����͸� �����ؿͼ� ����� ���� �ִ�.
 *      System.arraycopy()�� ����Ѵ�.
 */
public class ArrayBasicTest2 {

	public static void main(String[] args) {
		int[] arr = {11, 22, 33};
		System.out.println("�ּҰ� : " + arr);
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		
		System.out.println("\n============");
		// 44, 55 ���� �ڴʰ� ���ܼ� �߰��ؾ� �Ѵ�.
		arr = new int[5];
		arr[3] = 44;
		arr[4] = 55;
		System.out.println("�ּҰ� : " + arr);
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		
		System.out.println("\n==============arraycopy()===================");
		int[] target = {1, 2, 3, 4, 5, 6};
		int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		System.arraycopy(source, 3, target, 0, 4);
		for (int i = 0; i < target.length; i++) System.out.print(target[i] + " ");
	}

}
