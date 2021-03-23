package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{
	
	// �ڽŸ��� ����� �߰�
	private String nameOfBoss;
	
	public Secretary(String name, MyDate birthDay, double salary, String nameOfBoss) { 
		super(name, birthDay, salary);
		this.nameOfBoss = nameOfBoss;
	}
	@Override
	public String getDetails() {
		return super.getDetails() +  ", " + nameOfBoss;
	}
}
