package fly.child;

import fly.parent.Flyer;

public class SuperMan implements Flyer{ // expends 대신 implements

	@Override
	public void fly() {
		System.out.println("SuperMan...fly...");
	}

	@Override
	public void take_off() {
		System.out.println("SuperMan..take_off...");
	}

	@Override
	public void land() {
		System.out.println("SuperMan...land...");
	} 
	
	// 자식만의 메서드...
	public String stop_Bullet() {
		return "망또로 총알을 막다";
	}
}
