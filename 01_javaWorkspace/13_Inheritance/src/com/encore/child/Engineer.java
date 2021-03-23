package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee{
	
	// 자신만의 멤버를 추가
	private String tech;
	
	public Engineer(String name, MyDate birthDay, double salary, String tech) { 
		super(name, birthDay, salary);
		this.tech = tech;
//		this.name = name;
//		this.birthDay = birthDay;
//		this.salary = salary;
//		this.tech = tech;
	}
	@Override
	public String getDetails() {
		return super.getDetails() +  ", " + tech;
	}
}
