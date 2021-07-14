package poly.service.impl;

import poly.service.EmployeeService;
import poly.vo.Employee;
import poly.vo.Engineer;
/*
 * Singleton Pattern
 * �ϳ��� Ŭ�����κ��� �ϳ��� ��ü�� �����ϵ��� �ϴ� ����
 * 1. Ŭ���� �ȿ��� �ϴ� ��ü �ϳ�(private static) ����
 * 2. �ٸ� ��(Ŭ����)���� ��ü ������ ���� ���ϵ��� ���Ƶд�.
 *    �⺻ �����ڴ� ������ �ʾƵ� public���� ������� �ִ�...private���� ���Ƶд�.
 * 3. ����� ���� �ϳ��� ��ü�� ��𼭵� ���� �� �� �ֵ��� public�� �޼��带 �����д�.
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
