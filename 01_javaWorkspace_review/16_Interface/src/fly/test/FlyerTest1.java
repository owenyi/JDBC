package fly.test;

import fly.child.Airplane;
import fly.child.Bird;
import fly.child.Superman;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		// polymorphism 이용하여 객체 생성
		Flyer airplane = new Airplane();
		Flyer bird = new Bird();
		Flyer superman = new Superman();
		
		Flyer[] fa = { airplane, bird, superman };
		
		// for, instanceof 이용해서 각각 자식 클래스의 기능을 전부 다 호출
		for (Flyer f : fa) {
			System.out.println("================");
			f.fly();
			f.land();
			if (f instanceof Bird)
				((Bird) f).layEggs();
			else if (f instanceof Superman)
				((Superman) f).stopBullet();
		}
	}

}
