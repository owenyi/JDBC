package com.sumgo.child;

import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private int bonus;
	
	public Engineer(String name, MyDate birthday, int salary, String tech, int bonus) {
		super(name, birthday, salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + ", " + tech + ", " + bonus;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}
	
	public int getBonus() {
		return bonus;
	}
}