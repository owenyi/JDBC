package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Manager extends Employee{
	
	// �ڽŸ��� ����� �߰�
	private String dept;
	
	public Manager(String name, MyDate birthDay, double salary, String dept) { 
		super(name, birthDay, salary);
		this.dept = dept;
	}

	@Override
	public String getDetails() {
		return super.getDetails() +  ", " + dept;
	}

	// Manager Ŭ�������� ����� �߰�
	public void changeDept(String dept) {
		this.dept = dept;
	}
}
