package exam.test;
/*
 * Modifier --> Access Modifier | Usage Modifier
 * Usage Modifer :: static, final, abstract
 * static + final �ַ� �Բ� ���δ�.
 * 
 * final :: "���� �������̾�" �� �ǹ��ϴ� Ű����
 * final + ���� --> "���� ������ ������" --> ��� ����, ���Ҵ� ����
 * final + Ŭ���� --> "���� ������ Ŭ������" --> �ܸ����, ��� ����
 * final + �޼��� --> "���� ������ �޼����" --> �������̵� ����
 */

class A {
	public static final int BASE_SALARY = 300; // ����� ������ �̸��� ��� �빮�� & ����� ���
	public final String test() {
		return "Overriding ����";
	}
}

final class B { // ��� ����
	
}

//class C extends A {
//	public String test() {
//		
//	}
//}

//class D extends B {
//	
//}

public class StaticExamTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
