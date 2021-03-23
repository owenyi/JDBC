package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

/*
 * �θ� Ŭ���� Employee�κ��� ��� ���� �����ް�
 * �ڱ��ڽŸ��� ����� �߰��ϴ� �ڽ� Ŭ����...
 * 
 * ������ ȣ��, ��ü�� ������ ��
 */
public class Manager extends Employee{
	
	// �ڽŸ��� ����� �߰�
	private String dept;
	
	public Manager(String name, MyDate birthDay, double salary, String dept) { 
//		this.name = name;
//		this.birthDay = birthDay;
//		this.salary = salary;
		super(name, birthDay, salary);
		this.dept = dept;
	}

	//Method Overriding
	/*
	 * ��Ӱ��迡���� �Ͼ��.
	 * 1step : �θ� ���� ����� �����޴´�...ȣ���Ѵ�
	 * 2step : �װ� �ڽſ� �°� ���ľ���.
	 * 
	 * Overriding�� Rule
	 * 0. ��Ӱ����� �� Ŭ���� ���� �Ͼ�� �Ѵ�
	 * 1. �޼ҵ� ����δ� ��� ��ġ�ؾ� �Ѵ�
	 * 2. �����δ� �ݵ�� �޶�� �Ѵ�
	 * --> �ϴ� ���� �޶��������� ���ο� �޼ҵ尡 ���������.
	 *     �޼ҵ� ������
	 */
//	public String getDetails() {
//		return name + ", " + birthDay.getDate() + ", " + salary + ", " + dept;
//	}
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() +  ", " + dept;
	}
}
