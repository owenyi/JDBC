package fly.child;

import fly.parent.Flyer;

public class SuperMan implements Flyer{ // expends ��� implements

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
	
	// �ڽĸ��� �޼���...
	public String stop_Bullet() {
		return "���Ƿ� �Ѿ��� ����";
	}
}
