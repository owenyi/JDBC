package sample.test;

import sample.MyStudent;

/*
 * 1. MyStudent 객체 생성..ms
 * 2. MyStudent의 메소드 호출
 */

public class MyStudentTest {

	public static void main(String[] args) {
		// 1.
		MyStudent ms = new MyStudent();
		// 2.
		ms.name = "이상순";
		ms.age = 27;
		ms.address = "인천";
		// 프로그램이 하드코딩되면 프로그램이라고 할 수 없음
		ms.printInfo();
	}

}
