package sample.test;

import sample.MyStudent2;

/*
 * MyStudentTest.java�� ������
 *  : �л� ���� �þ ������
 *    ������ �ʵ忡 �ش��ϴ� ���� �־�����ϴ� ���ŷ����� �ִ�.
 *    
 *    ���α׷��� �ۼ��� ���� ���� �ϵ��ڵ� �Ǿ����� �ȵȴ�.
 * �ذ�å
 *  �ʵ忡 ���� ���� ������ �� �Ǵ� ���� �ʵ忡 �ԷµǴ� ����� ���Ӱ� �ϳ� �����ϸ� �ȴ�.
 */

public class MyStudentTest2 {

	public static void main(String[] args) {
		MyStudent2 m1 = new MyStudent2();
		MyStudent2 m2 = new MyStudent2();
		MyStudent2 m3 = new MyStudent2();
		
		m1.setField("�̻��", 27, "������");
		m2.setField("��â��", 28, "�д籸");
		m3.setField("���¿�", 57, "����Ȧ��");
		
		m1.printInfo();
		m2.printInfo();
		m3.printInfo();
	}

}
