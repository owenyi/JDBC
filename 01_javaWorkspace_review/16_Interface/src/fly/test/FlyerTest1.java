package fly.test;

import fly.child.Airplane;
import fly.child.Bird;
import fly.child.Superman;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		// polymorphism �̿��Ͽ� ��ü ����
		Flyer airplane = new Airplane();
		Flyer bird = new Bird();
		Flyer superman = new Superman();
		
		Flyer[] fa = { airplane, bird, superman };
		
		// for, instanceof �̿��ؼ� ���� �ڽ� Ŭ������ ����� ���� �� ȣ��
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
