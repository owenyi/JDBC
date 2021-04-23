package array.test;
/*
 * 배열의 선언, 생성, 할당을 한꺼번에
 * 
 * 배열의 특징
 * 1. 배열은 resizing할 수 없다.
 *    처음 잡은 사이즈를 변경하면
 *    새로운 배열이 하나 생긴다.
 *    
 * 2. 배열은 객체다.
 *    new 키워드를 통해서 생성...Heap에 올라간다.
 *    하지만 Class Type이 존재하지 않는다.
 *    length만 있다.
 *    
 * 3. 배열은 resizing 안 도지ㅣ만
 *    사이즈가 다른 배열의 데이터를 복사해와서 사용할 수는 있따.
 *    System.arraycopy()를 사용한다.
 */
public class ArrayBasicTest2 {

	public static void main(String[] args) {
		// 배열의 선언, 생성, 할당을 한꺼번에
		int[] arr = {11, 22, 33};
		System.out.println("주소값 : " + arr);
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
		System.out.println("\n==================");
		// 44, 55를 추가
		arr = new int[5];
		arr[3] = 44;
		arr[4] = 55;
		
		System.out.println("주소값 : " + arr);
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
		System.out.println("\n==================Array Copy");
		int[] target = {1, 2, 3, 4, 5, 6};
		int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		System.arraycopy(source, 3, source, 0, 2);
		for (int i = 0; i < target.length; i++) System.out.println(target[i]);
	}

}