package poly.service.impl;

import poly.service.EmployeeService;
import poly.vo.Employee;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee[] findByAddress(Employee[] ea, String addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAnnualSalary(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCost(Employee[] ea) {
		// TODO Auto-generated method stub
		return 0;
	}

}
