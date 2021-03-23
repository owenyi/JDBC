package exception.compile.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * 모두 Exception으로 처리하면 안되는가?
 * 예외라는 것은 매우 다양한 상황에서 발생할 수 있음
 * 이럴 때 모든 예외를 Exception 상위 클래스로 뭉뚱그려서 하나로 처리하는 것은 그다지 좋은 방법이 아니다.
 * --> 공통적인 카테고리의 예외는 한 가지로 묶어주는 것도 좋다.
 * --> 그렇지만 어느정도는 세분화하는 것이 좋다.
 */
public class CompileExceptionTest6 {

	public static void main(String[] args) {
		
		try {
			Class.forName("exception.compile.test.CompileExceptionTest6"); // FQCN
			new FileInputStream("Hello");
			DriverManager.getConnection("aaa");
		} catch (ClassNotFoundException e) {
			System.out.printf("해당 클래스를 찾을 수가 없습니다...: %s%n", e.getMessage());
		} catch (FileNotFoundException | SQLException e) {
			System.out.printf("해당하는 리소스가 없습니다: %s%n", e.getMessage());
		}
		
		System.out.println("프로그램 정상종료");
		
	}

}
