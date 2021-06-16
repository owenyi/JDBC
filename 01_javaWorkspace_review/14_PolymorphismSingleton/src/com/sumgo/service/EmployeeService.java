package com.sumgo.service;

import com.sumgo.vo.Employee;
import com.sumgo.vo.Engineer;
import com.sumgo.vo.Manager;

/*
 * Singletone Pattern
 * 하나의 클래스로부터 하나의 객체만 생성하도록하는 패턴
 * 1. 클래스 안에서 객체 하나 생성
 *    private static 객체를 생성한다.
 * 2. 다른 곳(클래스)에서는 객체 생성을 하지 못하도록 막아준다.
 *    private 생성자() {}
 * 3. 만들어 놓은 하나의 객체를 어디서든지 가져다 쓸 수 있도록 public 메소드를 만들어준다.
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
					System.out.println("부서 : " + ((Manager) e).getDept());
				else if (e instanceof Engineer)
					System.out.println("기술 : " + ((Engineer) e).getTech() + ", 보너스 : " + ((Engineer) e).getBonus());
				else
					System.out.println("추가 정보 없음");
			}
		}
	}
	
}
