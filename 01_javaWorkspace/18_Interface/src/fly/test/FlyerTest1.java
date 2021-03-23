package fly.test;

import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		// 1. polymorphism ������� �ڽ� ��ü�� 3�� ����...bird, superman, airplane
		// �������̽��� ��ü ������ ����� �ƴϰ�...��ü �����ϱ� ���� Ÿ�����μ��� �����Ѵ�!!!
		// Flyer flyer = new Flyer();
		
		Flyer bird = new Bird();
		Flyer superman = new SuperMan();
		Flyer airplane = new AirPlane();
		
		Flyer[] fa = { bird, superman, airplane };
		
		// 2. for, instanceof �̿��ؼ� ���� �ڽ�Ŭ������ ����� ���� �� ȣ��...
		for (Flyer f : fa) {
			System.out.println("\n====================");
			f.fly(); // virtual method invocation
			f.take_off();
			f.land();
			if (f instanceof Bird) {
				System.out.println(((Bird) f).layEggs());
			} else if (f instanceof SuperMan) {
				System.out.println(((SuperMan) f).stop_Bullet());
			}
		}

	}

}
