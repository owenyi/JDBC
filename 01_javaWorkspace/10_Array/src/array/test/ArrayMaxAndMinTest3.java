package array.test;
/*
 * int 타입의 배열을 만든다...랜덤한 값의 정수를 집어 넣는다.
 * 여러 숫자들 중에서 가장 큰 수와 가장 작은 수를 찾아내는 알고리즘을 작성..
 * 
 */
public class ArrayMaxAndMinTest3 {

	public static void main(String[] args) {
		int[] scores = {79, 88, 91, 44, 99, 55, 96};
		
		int max = scores[0]; // 배열의 첫번째 값으로 기본 값을 초기화한다...
		int min = scores[0];
		
//		for (int i = 0; i < scores.length; i++) {
//			if (max < scores[i]) max = scores[i];
//			if (min > scores[i]) min = scores[i];
//		}
		
		// Advanced For | ForEach..."뭐가 어디에서 도는가?"
		for (int score : scores) {
			if (max < score) max = score;
			if (min > score) min = score;
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("===============================\n");
	}

}
