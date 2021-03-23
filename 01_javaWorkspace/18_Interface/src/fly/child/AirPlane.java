package fly.child;

import fly.parent.Flyer;

public class AirPlane implements Flyer{ // expends ´ë½Å implements

	@Override
	public void fly() {
		System.out.println("AirPlane...fly...");
	}

	@Override
	public void take_off() {
		System.out.println("AirPlane..take_off...");
	}

	@Override
	public void land() {
		System.out.println("AirPlane...land...");
	}
}
