package fly.test;

import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;
import fly.parent.Flyer;

public class FlyerTest1 {

	public static void main(String[] args) {
		// 1. polymorphism 방식으로 자식 객체를 3개 생성...bird, superman, airplane
		// 인터페이스는 객체 생성의 대상이 아니고...객체 생성하기 위한 타입으로서만 존재한다!!!
		// Flyer flyer = new Flyer();
		
		Flyer bird = new Bird();
		Flyer superman = new SuperMan();
		Flyer airplane = new AirPlane();
		
		Flyer[] fa = { bird, superman, airplane };
		
		// 2. for, instanceof 이용해서 각각 자식클래스의 기능을 전부 다 호출...
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
