package sample.test;

import sample.MyStudent;

/*
 * 1. MyStudent ��ü ����..ms
 * 2. MyStudent�� �޼ҵ� ȣ��
 */

public class MyStudentTest {

	public static void main(String[] args) {
		// 1.
		MyStudent ms = new MyStudent();
		// 2.
		ms.name = "�̻��";
		ms.age = 27;
		ms.address = "��õ";
		// ���α׷��� �ϵ��ڵ��Ǹ� ���α׷��̶�� �� �� ����
		ms.printInfo();
	}

}
