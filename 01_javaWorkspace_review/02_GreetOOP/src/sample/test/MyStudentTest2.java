package sample.test;

import sample.MyStudent2;

/*
 * MyStudentTest.java�� ������
 *  : �л� ���� �þ ������
 *    ������ �ʵ忡 ���� �־�����ϴ� ���ŷο��� �ִ�.(�� �� �ۼ�)
 *    
 *    ���α׷��� �ۼ��� ���� ���� �ϵ��ڵ��Ǿ����� �� �ȴ�.
 * 
 * �ذ�å
 *  : �ʵ忡 ���� ���� ������ �� �Ǵ� ���� �ʵ忡 �ԷµǴ� ����� ����� �ȴ�.
 */
public class MyStudentTest2 {

	public static void main(String[] args) {
		
		MyStudent2 ms1 = new MyStudent2();
		MyStudent2 ms2 = new MyStudent2();
		
		ms1.setField("�̻��", 27, "��õ");
		ms2.setField("���ù�", 21, "��õ");
		
		ms1.printInfo();
		ms2.printInfo();
		
	}

}
