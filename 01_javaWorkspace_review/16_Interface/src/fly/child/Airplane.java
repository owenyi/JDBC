package fly.child;

import fly.parent.Flyer;
/*
 * �������̽��� �θ�� �� �ڽ� Ŭ������
 * �θ��� �߻� �޼��带 ��� �����ϵ��� �����ȴ�.
 */
public class Airplane implements Flyer { // extends ��� implements

	@Override
	public void fly() {
		System.out.println("Airplane...fly...");
	}

	@Override
	public void land() {
		System.out.println("Airplane...land...");
	}
	
}
