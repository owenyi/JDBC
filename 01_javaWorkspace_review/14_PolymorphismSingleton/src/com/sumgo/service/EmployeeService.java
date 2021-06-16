package com.sumgo.service;

import com.sumgo.vo.Employee;
import com.sumgo.vo.Engineer;
import com.sumgo.vo.Manager;

/*
 * Singletone Pattern
 * �ϳ��� Ŭ�����κ��� �ϳ��� ��ü�� �����ϵ����ϴ� ����
 * 1. Ŭ���� �ȿ��� ��ü �ϳ� ����
 *    private static ��ü�� �����Ѵ�.
 * 2. �ٸ� ��(Ŭ����)������ ��ü ������ ���� ���ϵ��� �����ش�.
 *    private ������() {}
 * 3. ����� ���� �ϳ��� ��ü�� ��𼭵��� ������ �� �� �ֵ��� public �޼ҵ带 ������ش�.
 */
public class EmployeeService {
	
	private static EmployeeService service = new EmployeeService(); // 1
	private EmployeeService() {} // 2
	public static EmployeeService getInstance() { // 3
		return service;
	}
	
	public void printAllInfo(Employee[] arr) {
		for (Employee e : arr) {
			System.out.println(e);
		}
	}
	
	public void printAddInfo(Employee[] arr, String empId) {
		for (Employee e : arr) {
			if (e.getEmpId().equals(empId)) {
				if (e instanceof Manager)
					System.out.println("�μ� : " + ((Manager) e).getDept());
				else if (e instanceof Engineer)
					System.out.println("��� : " + ((Engineer) e).getTech() + ", ���ʽ� : " + ((Engineer) e).getBonus());
				else
					System.out.println("�߰� ���� ����");
			}
		}
	}
	
}
