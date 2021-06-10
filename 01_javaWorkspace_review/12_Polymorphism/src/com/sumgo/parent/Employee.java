package com.sumgo.parent;

import com.sumgo.util.MyDate;

public class Employee {
	public static final int BASIC_SALARY = 3000;
	private String name;
	private MyDate birthday;
	private int salary;
	
	public Employee() {};
	public Employee(String name, MyDate birthday) {
		this(name, birthday, BASIC_SALARY);
	}
	public Employee(String name, MyDate birthday, int salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getDetails() {
		return name + ", " + birthday + ", " + salary;
	}
	public int getSalary() {
		return salary;
	}
}
