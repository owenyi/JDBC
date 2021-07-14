package poly.service.impl;

import poly.service.EmployeeService;
import poly.vo.Employee;
import poly.vo.Engineer;
/*
 * Singleton Pattern
 * 하나의 클래스로부터 하나의 객체만 생성하도록 하는 패턴
 * 1. 클래스 안에서 일단 객체 하나(private static) 생성
 * 2. 다른 곳(클래스)에서 객체 생성을 하지 못하도록 막아둔다.
 *    기본 생성자는 만들지 않아도 public으로 만들어져 있다...private으로 막아둔다.
 * 3. 만들어 놓은 하나의 객체를 어디서든 갖다 쓸 수 있도록 public한 메서드를 만들어둔다.
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeServiceImpl service = new EmployeeServiceImpl(); // 1
	private EmployeeServiceImpl() {}; // 2
	public static EmployeeServiceImpl getInstance() { // 3
		return service;
	}

	@Override
	public void printInfo(Employee e) {
		System.out.println(e);
	}

	@Override
	public void printAllInfo(Employee[] ea) {
		for (Employee e : ea) service.printInfo(e);
	}

	@Override
	public Employee findByEmpId(Employee[] ea, String empId) {
		Employee emp = null;
		for (Employee e : ea) {
			if (e.getEmpId().equals(empId))
				emp = e;
		}
		return emp;
	}

	@Override
	public Employee[] findByAddress(Employee[] ea, String addr) {
		Employee[] emps = new Employee[ea.length];
		int idx = 0;
		for (Employee e : ea) {
			if (e.getAddr().equals(addr))
				emps[idx++] = e;
		}
		return emps;
	}

	@Override
	public int getAnnualSalary(Employee e) {
		int salary = 12 * e.getSalary();
		if (e instanceof Engineer) salary += ((Engineer) e).getBonus();
		return salary;
	}

	@Override
	public int getTotalCost(Employee[] ea) {
		int sum = 0;
		for (Employee e : ea) {
			sum += service.getAnnualSalary(e);
		}
		return sum;
	}

}
