package com.sumgo.child;

import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class Secretary extends Employee {
	private String boss;

	public Secretary(String name, MyDate birthday, int salary, String boss) {
		super(name, birthday, salary);
		this.boss = boss;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + boss;
	}
	
	public void changeBoss(String boss) {
		this.boss = boss;
	}
}
