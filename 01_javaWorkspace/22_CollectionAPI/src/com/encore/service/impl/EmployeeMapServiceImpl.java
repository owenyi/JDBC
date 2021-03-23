package com.encore.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.service.EmployeeMapService;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

/*
 * 1. 인터페이스를 상속받아서 정의
 * 2. 싱글턴 패턴
 */
public class EmployeeMapServiceImpl implements EmployeeMapService{

//	private ArrayList<Employee> el;
	private Map<String, Employee> map;
	
	private static EmployeeMapServiceImpl service = new EmployeeMapServiceImpl();
	private EmployeeMapServiceImpl() {
		map = new HashMap<String, Employee>();
	};
	public static EmployeeMapServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {
		if (map.containsKey(e.getEmpId())) { // 이미 그런 사람이 존재한다면
			System.out.println(e.getName() + "님은 이미 등록되어있습니다.");
			return;
		} else {
			map.put(e.getEmpId(), e);
			System.out.println(e.getName() + "님이 등록되었습니다.");
		}
	}
	@Override
	public void deleteEmployee(String empId) {
		Employee emp = map.remove(empId);
		if (emp == null)
			System.out.println("삭제할 대상이 없습니다.");
		else
			System.out.println(emp.getName() + "님이 삭제되었습니다.");
	}
	@Override
	public void updateEmployee(Employee e) {
		if (map.containsKey(e.getEmpId())) {
			// 수정...update(), set()...key 유니크한 값은 그대로 두고 나머지를 수정...나머지 정보로 덮어쓴다
			//동일한 키값으로 객체를 다시 추가
			map.put(e.getEmpId(), e);
//			map.replace(e.getEmpId(), e); // 실전에서 replace는 잘 쓰지 않는다.
			System.out.println(e.getName() + "님의 회원정보가 수정되었습니다.");
			return;
		} else {
			System.out.println("삭제할 대상이 없습니다.");
		}
	}
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Employee emp = map.get(key);
			if (emp.getAddr().equals(addr))
				temp.add(emp);
		}
		return temp;
	}
	@Override
	public ArrayList<Employee> findEmployees() {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Employee emp = map.get(key);
			temp.add(emp);				
		}
		return temp;
	}
	
	
}
