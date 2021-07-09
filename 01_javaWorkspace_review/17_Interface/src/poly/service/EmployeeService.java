package poly.service;

import poly.vo.Employee;

public interface EmployeeService {
	// �� 6���� Template Method�� ����
	void printInfo(Employee e); // �տ� public abstract ����
	void printAllInfo(Employee[] ea);
	Employee findByEmpId(Employee[] ea, String empId);
	Employee[] findByAddress(Employee[] ea, String addr);
	int getAnnualSalary(Employee e);
	int getTotalCost(Employee[] ea);
}
