package greet.test;

import greet.MyGreet;

/*
 * MyGreet Ŭ������ �޼ҵ带 ���۽�Ű�� ���� Ŭ����...Test Ŭ����
 * Test Ŭ���� �ϴ� ��
 *   1. Ŭ������ ��ü�� ���� == �ı�(�������)���� �޸𸮿� �ö󰣴�.
 *   2. ����
 *      1) �ʵ� - - - �� �Ҵ�
 *      2) �޼ҵ� - - - ȣ��(Calling)
 */
public class MyGreetTest {

	public static void main(String[] args) {
		
		MyGreet mg = new MyGreet();
		mg.sayHello("Sangsoon");
		
	}

}
