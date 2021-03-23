package com.encore.service;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;

/*
 * 상속 관계에 있는 다양한 subclass들을 핸들링하는 기능만으로 이루어진 서비스 클래스...
 */
public class EmployeeService {
	/*
	 * 1step
	 * ::
	 * public void manageManager(Manager m) {}
	 * public void manageEngineer(Engineer eg) {}
	 * public void manageSecretary(Secretary s) {}
	 * 
	 * 2step -- Overloading : 메서드 이름은 같고 처리하는 데이터(매개 변수)를 달리하는 기법   << Rule >>
	 * ::                                                                      0. 하나의 클래스애서만 적용되는 기법
	 * public void manageEmployee(Manager m) {}                                1. 메서드 이름은 반드시 같아야 한다.
	 * public void manageEmployee(Engineer eg) {}                              2. 메서드 매개변수는 반드시 달라야 한다.
	 * public void manageEmployee(Secretary s) {}                              3. 메서드 리턴타입은?...can differ
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
