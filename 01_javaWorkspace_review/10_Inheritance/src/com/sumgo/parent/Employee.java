package com.sumgo.parent;

import com.sumgo.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private int salary;
	
	public Employee(String name, MyDate birthday, int salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getDetails() {
		return "[name=" + name + ", birthday=" + birthday + ", salary=" + salary + "]";
	}
}
