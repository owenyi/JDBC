package exam.test;
/* Modifier --> Access Modifier | Usage Modifier
 * Usage Modifier : static, final, abstract
 * 상수 표현할 때 static + final
 * 
 * final : "내가 마지막이야"를 의미하는 키워드
 * final 변수 --> "내가 마지막 변수야" --> 상수 지정, 재할당(변경) 금지
 * final 클래스 --> "내가 마지막 클래스야" --> 단말 노드, 상속 금지
 * final 메소드 --> "내가 마지막 메소드야" --> 오버라이딩 금지
 */
class A { 
	public static final int BASE_SALARY = 300; // 상수인 변수의 이름은 모두 대문자&언더바 사용
	public final String test() {
		return "Overridng 금지";
	}
}

final class B {
	
}

//class C extends A {
//	public String test() {
//		
//	}
//}

//class D extends B {
//	
//}

public class StaticExamTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
