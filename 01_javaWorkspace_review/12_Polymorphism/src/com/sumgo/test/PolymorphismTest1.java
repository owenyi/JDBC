package com.sumgo.test;

import com.sumgo.child.Engineer;
import com.sumgo.child.Manager;
import com.sumgo.child.Secretary;
import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class PolymorphismTest1 {

	public static void main(String[] args) {
		// 클래스 잘 동작하나 확인
		Employee emp = new Employee("James", new MyDate(1982, 3, 2), 3000);
		Manager m = new Manager("Robert", new MyDate(1981, 4, 2), 3500, "Accounting");
		Engineer eg = new Engineer("Gosling", new MyDate(1978, 1, 2), 3300, "JAVA", 200);
		Secretary s = new Secretary("Peter", new MyDate(1988, 1, 2), 3400, "Robert");
		
		m.changeDept("Marketing");
		
		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());
		
		///// Polymorphism /////
		System.out.println("=====Polymorphism=====");
		
		Employee emp1 = new Manager("Robert", new MyDate(1981, 4, 2), 3500, "Accounting");
		Employee emp2 = new Engineer("Gosling", new MyDate(1978, 1, 2), 3300, "JAVA", 200);
		Employee emp3 = new Secretary("Peter", new MyDate(1988, 1, 2), 3400, "Robert");
		
		// Virtual Method Invocation
		// 딱 한 경우 : 자식이 메서드 오버라이딩을 했을 때
		// 컴파일 시점 - 부모의 메소드
		// 런타임 시점 - 자식의 메소드
		System.out.println(emp1.getDetails());
		System.out.println(emp2.getDetails());
		System.out.println(emp3.getDetails());
		
		// Object Casting
		System.out.println(((Engineer) emp2).getBonus());;
	}

}
