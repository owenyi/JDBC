package com.encore.cons.test;

import com.encore.cons.Programmer;
import com.encore.util.MyDate;

public class ProgrammerTest { // 테스트 클래스는 다른 말로 실행 클래스

	public static void main(String[] args) {
		// 1. 객체 생성...Programmer의 식구들을 메모리에 올리기 위해
		// 2. 메소드 호출
		// 3. 개발자의 정보가 콘솔창에 출력되도록 작성, birthday의 정보가 1980-1-1

//		MyDate md = new MyDate();
//		md.setDate(1980, 1, 1);
//		
//		Programmer pro = new Programmer();
//		Programmer pro1 = new Programmer();
//		
//		pro.setProgrammer("James", md, 543.21f, 300);
//		pro1.setProgrammer("Peter", md, 234.56f, 150);
//
//		pro = pro1;
//		
//		System.out.println(pro.getProgrammer());
//		System.out.println(pro1.getProgrammer());
		
		/*
		 * 1. pro1, pro2객체를 생성...
		 * 2. 생성자를 이용해서 필드에 직접 값을 할당
		 * 3. 필드 정보를 콘솔창으로 출력..
		 * 4. Peter의 연봉은 450000.0달러 입니다. 출력이 되도록 로직을 완성하세요.
		 */
		
//		MyDate md = new MyDate(1980, 1, 1);
//		Programmer pro1 = new Programmer("James", md, 300000.0f, 300);
//		Programmer pro2 = new Programmer("Peter", md, 450000.0f, 500);
		
		Programmer pro1 = new Programmer("James", new MyDate(1980, 1, 1), 300000.0f, 10000);
		Programmer pro2 = new Programmer("Peter", new MyDate(1980, 1, 1), 400000.0f, 20000);
		
		System.out.println(pro1.getProgrammer());
		System.out.println(pro2.getProgrammer());
		
		System.out.println("\n================================================================\n");
		System.out.println(pro2.getName() + "의 연봉은 " + pro2.getAnnualSalary() + "달러 입니다.");
	}

}
