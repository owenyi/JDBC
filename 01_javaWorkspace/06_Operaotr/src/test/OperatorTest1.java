package test;

public class OperatorTest1 {

	public static void main(String[] args) {
		
		// 식구들을 메모리에 올린다 -> 결론 : 주소값 할당
		Operator o1 = new Operator(); // 100
		Operator o2 = new Operator(); // 200
		//
		System.out.println("\n==");
		// ==
		System.out.println(o1); // test.Operator@4926097b --> at(@) 4926097b(주소값)
		System.out.println(o2);
		System.out.println(o1 == o2);
		o1 = o2;
		//
		System.out.println("===true가 나오려면 주소값이 같아져야하니 덮어써줘야 한다.===");
		//
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1 == o2);
		
		
		int i = 5; // 지역 변수, 메소드 블락 안에 있다.
		int j = 3; // 지역 변수를 사용할 때는 반드시 초기화해야함, 왜냐면 기본 값이 없음.
		
//		int k;
//		System.out.println(k); --> error
		
		
		System.out.println("\n%");
		// %
		System.out.println("연산자 % :: " + i % j);

		
		System.out.println("\n!=");
		// !=
		System.out.println(i == j);
		System.out.println(i != j);

		
		System.out.println("\n==, --");
		// ++(1씩 증가), --(1씩 감소)
		int k = 10;
		System.out.println(k++);
		System.out.println(k);
		
		int m = 10;
		System.out.println(++m);
		System.out.println(m);
		
		System.out.println("\n논리 연산자");
		// 논리 연산자
		System.out.println(o1.test1() | o1.test2()); // ture or ture == true
		System.out.println(o1.test1() & o1.test2()); // true and false == false
		
		
		System.out.println("\nShort Circuit");
		// Short Circuit
		System.out.println(o1.test1() || o1.test2()); // ture or ture == true
		System.out.println(o1.test1() && o1.test2()); // true and false == false
		
	}

}

class Operator { // 이 앞에 public 붙이면 error남, 파일명 OperatorTest1.java이기 때문에 class OperatorTest1 앞에만 public을 붙일 수 있음
	public boolean test1() {
		System.out.println("test1() Calling...");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() Calling...");		
		return false;
	}
}