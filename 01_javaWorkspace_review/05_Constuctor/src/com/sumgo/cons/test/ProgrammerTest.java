package com.sumgo.cons.test;

import com.sumgo.cons.Programmer;
import com.sumgo.util.MyDate;

public class ProgrammerTest {

	public static void main(String[] args) {
		// 1. pro1, pro2 객체 생성 + 생성자로 필드에 값 할당
		// Taekmin
		// 2. 필드 정보를 콘솔창으로 출력
		// 3. Taekmin의 연봉은 ...달러입니다...출력되도록 로직 작성
		
		Programmer pro1 = new Programmer("Taekmin", "남자", "Java", 2, new MyDate(2001, 12, 5));
		Programmer pro2 = new Programmer("Suelgi", "여자", "python", 5, new MyDate(1996, 7, 8));
		
		System.out.println(pro1.getInfo()); // 2001-12-5
		System.out.println(pro2.getInfo());
		
	}

}
