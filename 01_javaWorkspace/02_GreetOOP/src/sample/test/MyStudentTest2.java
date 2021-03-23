package sample.test;

import sample.MyStudent2;

/*
 * MyStudentTest.java의 문제점
 *  : 학생 수가 늘어날 때마다
 *    일일이 필드에 해당하는 값을 넣어줘야하는 번거러움이 있다.
 *    
 *    프로그램은 작성시 실제 값이 하드코딩 되어지면 안된다.
 * 해결책
 *  필드에 값을 직접 넣으면 안 되니 값이 필드에 입력되는 기능을 새롭게 하나 정의하면 된다.
 */

public class MyStudentTest2 {

	public static void main(String[] args) {
		MyStudent2 m1 = new MyStudent2();
		MyStudent2 m2 = new MyStudent2();
		MyStudent2 m3 = new MyStudent2();
		
		m1.setField("이상순", 27, "연수구");
		m2.setField("이창규", 28, "분당구");
		m3.setField("이태원", 57, "미추홀구");
		
		m1.printInfo();
		m2.printInfo();
		m3.printInfo();
	}

}
