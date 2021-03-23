package fly.child;

import fly.parent.Flyer;

/*
 * 인터페이스를 부모로 둔 자식 클래스는
 * 부모의 추상메서드를 모두 구현하도록 강요된다.
 */
public class Bird implements Flyer{ // expends 대신 implements

	@Override
	public void fly() {
		System.out.println("Bird...fly...");
	}

	@Override
	public void take_off() {
		System.out.println("Bird..take_off...");
	}

	@Override
	public void land() {
		System.out.println("Bird...land...");
	} 
	
	// 자식만의 메서드...
	public String layEggs() {
		return "새가 알을 까다";
	}
}
