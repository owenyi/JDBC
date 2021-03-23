package fly.parent;
// 날으는 것과 관련된 추상 기능을 모아 놓은 인터페이스
/*
 * 인터페이스의 구성요소
 * 1. static final 상수
 * 2. public abstract 메서드
 */
public interface Flyer {
	// 필드가 없다...상수는 존재
	public static final int SIZE = 100;
	public abstract void fly(); // abstract method...선언부만 있고 구현부가 없는 메서드
	void take_off(); // 메서드 리턴 타입 앞에 무조건 public abstract가 생략되어 있음
	void land();
}
