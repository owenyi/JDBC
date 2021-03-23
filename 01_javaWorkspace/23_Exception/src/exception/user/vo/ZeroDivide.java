package exception.user.vo;
// 사용자 정의 Exception으로 만들어보자...
public class ZeroDivide extends Exception{

	public ZeroDivide() {
		this("This is UserException...ZeroBoomException..."); // 아래 생성자에 default 값 넣어준 거
	}

	public ZeroDivide(String message) {
		super(message);
	}
	
}
