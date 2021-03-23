package com.encore.service;

import java.util.ArrayList;

import com.encore.vo.Employee;

// ����� Template�� ��� ���� �������̽�...
public interface EmployeeMapService {
	
	void addEmployee(Employee e); // public abstract�� ����
	void deleteEmployee(String empId);
	void updateEmployee(Employee e);
	
	// Method Overloading
	ArrayList<Employee> findEmployees(String addr);
	ArrayList<Employee> findEmployees();
	
}
