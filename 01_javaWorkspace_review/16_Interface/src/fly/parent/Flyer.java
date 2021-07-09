package fly.parent;

// 날다, 착지하다의 추상 기능을 모아 놓은 인터페이스
/*
 * 인터페이스의 구성 요소
 * 1. static final 상수
 * 2. public abstract 메서드
 */
public interface Flyer {
	// 필드가 없다...상수는 존재
	public static final int SIZE = 100;
	// abstract method...선언부만 있고 구현부가 없는 메서드
	public abstract void fly();
	// public abstract를 생략할 수 있다.
	void land();
}
