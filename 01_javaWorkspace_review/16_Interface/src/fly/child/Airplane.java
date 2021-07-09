package fly.child;

import fly.parent.Flyer;
/*
 * 인터페이스를 부모로 둔 자식 클래스는
 * 부모의 추상 메서드를 모두 구현하도록 강제된다.
 */
public class Airplane implements Flyer { // extends 대신 implements

	@Override
	public void fly() {
		System.out.println("Airplane...fly...");
	}

	@Override
	public void land() {
		System.out.println("Airplane...land...");
	}
	
}
