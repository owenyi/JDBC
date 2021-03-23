package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		// 1. 생년월일이 주소값으로 출력된다...해결 : MyDate에다가 getDate()를 출력
		// 2. Manager의 dept(부서)가 출력되지 않는다...해결 : getDetails() Overriding
		Employee emp = new Employee("James", new MyDate(1982, 3, 2), 23000.0);
		Manager m = new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT");

//		System.out.println(emp);            // toString 생략
//		System.out.println(emp.toString()); // default
//		System.out.println(emp.hashCode()); // 16진수로
//		
//		System.out.println(m);
//		System.out.println(m.toString());
//		System.out.println(m.hashCode());
		
		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
		
		Engineer eg = new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java");
		Secretary ss = new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert");
		
		System.out.println(eg.getDetails());
		System.out.println(ss.getDetails());
	}
}
