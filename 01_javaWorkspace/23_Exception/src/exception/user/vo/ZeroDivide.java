package exception.user.vo;
// ����� ���� Exception���� ������...
public class ZeroDivide extends Exception{

	public ZeroDivide() {
		this("This is UserException...ZeroBoomException..."); // �Ʒ� �����ڿ� default �� �־��� ��
	}

	public ZeroDivide(String message) {
		super(message);
	}
	
}
