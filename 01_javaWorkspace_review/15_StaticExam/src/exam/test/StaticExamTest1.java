package exam.test;
/*
 * ===== static한 키워드 성질 =====
 * 1. 객체 생성 과정 없이 메모리에 올라간다.
 * 2. 객체 생성 과정 이전에...Class File Loader 과정에서...이 때 메모리에 올라간다.
 * 3. static한 성질의 필드는 생성된 객체들에서 서로 공유한다!
 * 4. static은 static끼리 통한다.
 * 5. static블락 안에서는 this 사용 못한다.
 * 6. static과 final은 성질상 종종 함께 사용된다.
 *     ex) 상수값 선언...static final int BASIC_SALARY = 1000;
 * 7. static initialization block
 * 8. 싱글톤
 */
class Member {
	static String name1 = "철수";
	String name2 = "영희";
	
	public static void getMember1() {
		System.out.println("안녕, 난 " + name1 + "야");
//		System.out.println("안녕, 난 " + name2 + "야"); 안 된다.
	}
	public void getMember2() {
		System.out.println("안녕, 난 " + name2 + "야");
//		System.out.println("안녕, 난 " + name1 + "야"); 된다.
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) {
		// static한 성질의 메소드는 바로 접근해서 사용할 수 있다...Class이름.static메소드
		Member.getMember1();

		// getMember2()는 객체 생성 이후에 사용할 수 있다.
		Member m = new Member();
		m.getMember2();
	}

}