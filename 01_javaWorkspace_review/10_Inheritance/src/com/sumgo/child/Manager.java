package com.sumgo.child;

import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class Manager extends Employee {
	private String dept;

	public Manager(String name, MyDate birthday, int salary, String dept) {
		super(name, birthday, salary);
		this.dept = dept;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + "dept=" + dept;
	}
}