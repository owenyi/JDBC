package exam.test;
/* Modifier --> Access Modifier | Usage Modifier
 * Usage Modifier : static, final, abstract
 * ��� ǥ���� �� static + final
 * 
 * final : "���� �������̾�"�� �ǹ��ϴ� Ű����
 * final ���� --> "���� ������ ������" --> ��� ����, ���Ҵ�(����) ����
 * final Ŭ���� --> "���� ������ Ŭ������" --> �ܸ� ���, ��� ����
 * final �޼ҵ� --> "���� ������ �޼ҵ��" --> �������̵� ����
 */
class A { 
	public static final int BASE_SALARY = 300; // ����� ������ �̸��� ��� �빮��&����� ���
	public final String test() {
		return "Overridng ����";
	}
}

final class B {
	
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
