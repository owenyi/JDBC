package com.sumgo.child;

import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	
	public Engineer(String name, MyDate birthday, int salary, String tech) {
		super(name, birthday, salary);
		this.tech = tech;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + "tech=" + tech;
	}
}
