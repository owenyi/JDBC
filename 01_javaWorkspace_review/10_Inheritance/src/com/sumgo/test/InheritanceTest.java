package com.sumgo.test;

import com.sumgo.child.Manager;
import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class InheritanceTest {

	public static void main(String[] args) {
		Employee emp = new Employee("James", new MyDate(1982, 3, 2), 3000);
		Manager m = new Manager("Robert", new MyDate(1981, 4, 2), 3500, "Accounting");

		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
	}

}
