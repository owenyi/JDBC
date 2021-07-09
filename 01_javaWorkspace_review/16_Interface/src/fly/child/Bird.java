package fly.child;

import fly.parent.Flyer;

public class Bird implements Flyer {

	@Override
	public void fly() {
		System.out.println("Bird...fly...");
	}

	@Override
	public void land() {
		System.out.println("Bird...land...");
	}
	
	public void layEggs() {
		System.out.println("새가...알을 까다...");
	}

}
