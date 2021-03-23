package looping.test;
/*
 * 반복문 중에서 가장 많이 사용되는
 * for문이 어떻게 동작하는지 정확하게 이해한다.
 * 
 * for (초기식; 조건식; 증감식) {
 *     code block;
 * }
 */
public class LoopingBasicTest1 {

	public static void main(String[] args) {
		System.out.println("========for=======\n");
		for (int i = 0; i < 10; i++) { // 여기서도 i 썼는데 에러가 안 난 이유는? 여기의 i는 이 code block이 끝나면 사라짐
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
