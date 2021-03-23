package com.encore.service.impl;

import java.util.ArrayList;

import com.encore.service.EmployeeListService;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

/*
 * 1. �������̽��� ��ӹ޾Ƽ� ����
 * 2. �̱��� ����
 */
public class EmployeeListServiceImpl implements EmployeeListService{

	private ArrayList<Employee> el;
	
	private static EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		el = new ArrayList<Employee>();
	};
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {
		if (el.contains(e)) {
			System.out.println(e.getName() + "���� �̹� ȸ�� ��ܿ� ���ԵǾ� �ֽ��ϴ�.");
			return;
		}
		else {
			el.add(e);
			System.out.println(e.getName() + "���� ȸ������ ���ԵǾ����ϴ�.");
		}
		
//		boolean find = false; // flag
//		for (Employee employee : el) {
//			if (employee.getEmpId().equals(e.getEmpId())) {
//				find = true;
//				System.out.println(e.getName() + "���� �̹� ȸ�� ��ܿ� ���ԵǾ� �ֽ��ϴ�.");
//				return;
//			}				
//		}
//		if (find == false) {
//			el.add(e);
//			System.out.println(e.getName() + "���� ȸ������ ���ԵǾ����ϴ�.");
//		}
	}
	@Override
	public void deleteEmployee(String empId) {
		for (Employee e : el) {
			if (e.getEmpId().equals(empId)) {
				el.remove(e);
				return;
			}
		}
	
//		for (Employee e : el) {
//			if (e.getEmpId().equals(e.getEmpId())) {
//				el.remove(e);
//				System.out.println(e.getName() + "���� ȸ�� ��ܿ��� �����߽��ϴ�.");
//				return;
//			}			
//		}
//		System.out.println("�����Ϸ��� ����� ���� ȸ�� �߿��� �������� �ʽ��ϴ�.");
	}
	@Override
	public void updateEmployee(Employee e) {
		for (Employee emp : el) {
			if (e.getEmpId().equals(emp.getEmpId())) {
				// empId�� PK�� ����x
				emp.setName(e.getName());
				emp.setAddr(e.getAddr());
				emp.setSalary(e.getSalary());
				
				if (emp instanceof Manager) {
					((Manager) emp).changeDept(((Manager) e).getDept());
				} else if (emp instanceof Engineer) {
					((Engineer) emp).changeBonus(((Engineer) e).getBonus());
					((Engineer) emp).changeTech(((Engineer) e).getTech());
				}
			}
		}
	}
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> employees = new ArrayList<Employee>(); // null�� �ϸ� ������
		for (Employee e : el) {
			if (e.getAddr().equals(addr))
				employees.add(e);
		}
		return employees;
	}
	@Override
	public void findEmployees() {
		for (Employee e : el) {
			System.out.println(e);
		}
	}
	
	
}
