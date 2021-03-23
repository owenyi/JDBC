package com.encore.service.impl;

import java.util.ArrayList;

import com.encore.service.EmployeeListService;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

/*
 * 1. 인터페이스를 상속받아서 정의
 * 2. 싱글턴 패턴
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
			System.out.println(e.getName() + "님은 이미 회원 명단에 가입되어 있습니다.");
			return;
		}
		else {
			el.add(e);
			System.out.println(e.getName() + "님이 회원으로 가입되었습니다.");
		}
		
//		boolean find = false; // flag
//		for (Employee employee : el) {
//			if (employee.getEmpId().equals(e.getEmpId())) {
//				find = true;
//				System.out.println(e.getName() + "님은 이미 회원 명단에 가입되어 있습니다.");
//				return;
//			}				
//		}
//		if (find == false) {
//			el.add(e);
//			System.out.println(e.getName() + "님이 회원으로 가입되었습니다.");
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
//				System.out.println(e.getName() + "님을 회원 명단에서 삭제했습니다.");
//				return;
//			}			
//		}
//		System.out.println("삭제하려는 대상이 현재 회원 중에는 존재하지 않습니다.");
	}
	@Override
	public void updateEmployee(Employee e) {
		for (Employee emp : el) {
			if (e.getEmpId().equals(emp.getEmpId())) {
				// empId는 PK로 수정x
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
		ArrayList<Employee> employees = new ArrayList<Employee>(); // null로 하면 에러남
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
