package sample.test;

import sample.MyStudent;

/*
 * 1. MyStudent ��ü�� ����...ms + �ʵ� �ʱ�ȭ
 * 2. MyStudent�� �޼ҵ带 ȣ��
 */
public class MyStudentTest {

	public static void main(String[] args) {
		// 1.
		MyStudent ms = new MyStudent();
		ms.name = "�̻��";
		ms.age = 27;
		ms.address = "��õ";
		// ���α׷��� �ϵ� �ڵ��Ǿ�����...��ü�� ������ ������ �� ���� �Ἥ ���� �ʱ�ȭ ����� ��
		
		// 2.
		ms.printInfo();
	}

}
