package array.test;
// 배열 선언, 생성, 초기화 과정을 작성
// for문 사용해서 배열 안에 들어있는 값들을 출력
public class ArrayBasicTest1 {

	public static void main(String[] args) {
		// 1. 배열 선언 + 생성
		int[] arr = new int[3];
		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
		// 2. 할당
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		for (int num : arr) System.out.println(num);
	}

}