package exception.runtime.test;

public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		
		String[] str = {
				"Hello Java",
				"No, I mean it",
				"Nice to meet you"
		};

		int i = 0;
		while (i < 4) {
			try {
				System.out.println(str[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch1!!"); // 뒤의 catch는 동작하지 않는다...
			} catch(Exception e) {
				System.out.println("Nice Catch2!!");
			}
			i++;
		}
		System.out.println("the end...");
		
	}

}
