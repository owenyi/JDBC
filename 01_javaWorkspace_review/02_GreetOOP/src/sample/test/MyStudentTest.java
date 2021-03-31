package sample.test;

import sample.MyStudent;

/*
 * 1. MyStudent 객체를 생성...ms + 필드 초기화
 * 2. MyStudent의 메소드를 호출
 */
public class MyStudentTest {

	public static void main(String[] args) {
		// 1.
		MyStudent ms = new MyStudent();
		ms.name = "이상순";
		ms.age = 27;
		ms.address = "인천";
		// 프로그램이 하드 코딩되어졌다...객체를 생성할 때마다 세 줄을 써서 값을 초기화 해줘야 됨
		
		// 2.
		ms.printInfo();
	}

}
