package fly.child;

import fly.parent.Flyer;

public class Superman implements Flyer {

	@Override
	public void fly() {
		System.out.println("Superman...fly...");
	}

	@Override
	public void land() {
		System.out.println("Superman...land...");
	}
	
	public void stopBullet() {
		System.out.println("수퍼맨이...총알 막다...");
	}

}
