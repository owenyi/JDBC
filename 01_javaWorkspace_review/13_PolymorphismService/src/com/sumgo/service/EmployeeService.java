package com.sumgo.service;

import com.sumgo.vo.Employee;
import com.sumgo.vo.Engineer;
import com.sumgo.vo.Manager;

public class EmployeeService {
	
	public void printAllInfo(Employee[] arr) {
		for (Employee e : arr) {
			System.out.println(e);
		}
	}
	
	public void printAddInfo(Employee[] arr, String empId) {
		for (Employee e : arr) {
			if (e.getEmpId().equals(empId)) {
				if (e instanceof Manager)
					System.out.println("부서 : " + ((Manager) e).getDept());
				else if (e instanceof Engineer)
					System.out.println("기술 : " + ((Engineer) e).getTech() + ", 보너스 : " + ((Engineer) e).getBonus());
				else
					System.out.println("추가 정보 없음");
			}
		}
	}
	
}
