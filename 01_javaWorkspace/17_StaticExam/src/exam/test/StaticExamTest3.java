package exam.test;
// static initialization block...
// 초기화...
public class StaticExamTest3 {
	static int i = 0; 
	
	public static void main(String[] args) {
		// 실질적으로 이 부분이 가장 먼저 실행된다...여기에다가 초기화 알고리즘 넣는다
		// 객체생성...();...생성자 호출...필드 초기화
		
		System.out.println("1. main method static block" + i); // int i = 0; 이면 에러난다.

	}

	static { // 여태까지는 main이 제일 먼저 돈다고 알고 있었는데 그것보다 먼저 도는 static initialization block
		i = 300;
		System.out.println("2. static initialization block..." + i);
	}
}
