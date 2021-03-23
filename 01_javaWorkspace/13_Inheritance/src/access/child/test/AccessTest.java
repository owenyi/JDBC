package access.child.test;

import access.parent.Parent;

class Child extends Parent{
	public void accessTest() {
		System.out.println(publicTest);
		System.out.println(protectedTest); // ����
//		System.out.println(defaultTest); // not visible...���� �Ұ�
//		System.out.println(privateTest);
	}
	
	@Override
	public void access() {
		super.access();
		System.out.println("��ӹ��� �ʵ�� :: " +publicTest);
		System.out.println("��ӹ��� �ʵ�� :: " +protectedTest);
	}
}

public class AccessTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.accessTest();
		System.out.println("===================");
		c.access();
	}

}
