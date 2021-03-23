package exception.user.test;

import java.util.Scanner;

/*
 * ����� ���� Exception
 * 1. ���� Ŭ������ ���� ���� �ۼ��ؼ� ���
 *    class A extends Exception{}
 * 2. ������ ������� ����
 *    Ư���� ������ �����Ǹ� ���ܸ� ���������� �������Ѽ� ���α׷��� �ڵ鸵�Ѵ�.
 *    
 * ------------------------------------------------------
 * ���� ��ȭ�� �����ϴµ�
 * ���̰� 19�� �̸��� ����� ���忡 �����ϴ� ��� ������ ���ġ �ʰ�
 * 19�� �̻��� ����� ��ȭ ������ ����� �� �ִ� ������ �ۼ�...
 * --> UnderAgeException�� �����ؼ� ����ϰڴ�.
 */
class UnderAgeException extends Exception {
	UnderAgeException() {
		this("19�� �̸��� ��ȭ ���� �ȵ˴ϴ�.");
	}
	UnderAgeException(String message) {
		super(message);
	}
}

class AdultMovieService {
	public void entrance(int age) throws UnderAgeException{
		if (age < 19) 
			throw new UnderAgeException();
		else
			System.out.println("Ticketing...Entrance OK!!!");
	}
}

public class AdultMovieExceptionTest3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Encore �����Դϴ�...���̸� �Է��ϼ���.");
		int age = sc.nextInt();
		
		AdultMovieService service = new AdultMovieService();
		try {
			service.entrance(age); // �굵 try catch ����� ������???
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}

	}

}
