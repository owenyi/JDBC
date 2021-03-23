package poly.service;

import poly.vo.Employee;

public interface EmployeeService {
	// 총 여섯 개의 Template Method를 선언했다...
	
	void printInfo(Employee e); // 앞에 public static 생략돼있다.
	void printAllInfo(Employee[ ] ea);
	Employee findByEmpId(Employee[ ] ea, String empId);
	Employee[ ] findByAddress(Employee[ ] ea, String addr);
	int getAnnualSalary(Employee e);
	int getTotalCost(Employee[ ] ea);
	
}
