package com.encore.service;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;

/*
 * ��� ���迡 �ִ� �پ��� subclass���� �ڵ鸵�ϴ� ��ɸ����� �̷���� ���� Ŭ����...
 */
public class EmployeeService {
	/*
	 * 1step
	 * ::
	 * public void manageManager(Manager m) {}
	 * public void manageEngineer(Engineer eg) {}
	 * public void manageSecretary(Secretary s) {}
	 * 
	 * 2step -- Overloading : �޼��� �̸��� ���� ó���ϴ� ������(�Ű� ����)�� �޸��ϴ� ���   << Rule >>
	 * ::                                                                      0. �ϳ��� Ŭ�����ּ��� ����Ǵ� ���
	 * public void manageEmployee(Manager m) {}                                1. �޼��� �̸��� �ݵ�� ���ƾ� �Ѵ�.
	 * public void manageEmployee(Engineer eg) {}                              2. �޼��� �Ű������� �ݵ�� �޶�� �Ѵ�.
	 * public void manageEmployee(Secretary s) {}                              3. �޼��� ����Ÿ����?...can differ
	 * 
	 * 3step
	 * public void manageEmployee(Employee e) {}
	 */
	public static final int MAX_CUSTOMERS = 100;
	
	public void manageEmployee(Employee e) {
		if (e.getName().equals("Peter")) {
			System.out.println(e.getDetails());
		}
		if (e instanceof Manager) {
			
		}
		if (e instanceof Engineer) {
			System.out.println("Annual Salary :: " + (e.getSalary() * 12 + ((Engineer) e).getBonus()));
		}
		if (e instanceof Secretary) {
			
		}
	}
	
	public void printAllEmployee(Employee[] emps) {
		for (Employee e : emps) 
			System.out.println(e.getDetails());
	}
}
