package exception.runtime.test;
/*
 * 예외를 처리하는 방법 2번째...throws사용해본다.
 */
class Throws {
	
	// go() 수행 중 예외가 발생...그걸 던지니...go()를 호출한 곳에서 예외처리를 직접 하세요
	public void go() throws ArithmeticException{ // static이면?
		int i = 10;
		int j = 0;
		
		System.out.println("2. 0을 분모로 하면 안됩니다...");
		if (i / j == 0) // ArithmeticException
			System.out.println("ArithmeticException때문에 출력 안됨...");
	}
	
}
public class RuntimeExceptionTest4 {

	public static void main(String[] args) {
		
		Throws t = new Throws();
		System.out.println("1. go() calling...");
		try {
			t.go();
		} catch (ArithmeticException e) {
			System.out.println("3. 호출한 지점에서 예외를 잡았습니다.");
		}
		
	}

}
