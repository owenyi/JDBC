package com.encore.cons;

import com.encore.util.MyDate;

// 개발자 정보를 담고 있는 클래스..
public class Programmer {
	// 1. 필드 선언...
	public String name;     // API, Library
	public MyDate birthday; // 내가 만든 클래스
	public float salary;
	public int bonus;
	
	// 2. 주입
//	public void setProgrammer(String name, MyDate birthday, float salary, int bonus) {
//		this.name = name;
//		this.birthday = birthday;
//		this.salary = salary;
//		this.bonus = bonus;
//	}
	public Programmer() {} // 기본 생성자
	
	public Programmer(String name, MyDate birthday, float salary, int bonus) { // 명시적 생성자
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	// 3. 필드 값 받아오기
	public String getProgrammer() {
		return name + ", " + birthday.getDate() + ", " + salary + ", " + bonus;
	}
	
	// +. 개발자의 연봉을 리턴하는 기능
	public float getAnnualSalary() {
		return salary * 12 + bonus;
	}

	// 기능 추가
	public String getName() {
		return name;
	}
	
}
