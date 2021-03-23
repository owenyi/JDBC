package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Manager extends Employee{
	
	// 자신만의 멤버를 추가
	private String dept;
	
	public Manager(String name, MyDate birthDay, double salary, String dept) { 
		super(name, birthDay, salary);
		this.dept = dept;
	}

	@Override
	public String getDetails() {
		return super.getDetails() +  ", " + dept;
	}

	// Manager 클래스만의 기능을 추가
	public void changeDept(String dept) {
		this.dept = dept;
	}
}
