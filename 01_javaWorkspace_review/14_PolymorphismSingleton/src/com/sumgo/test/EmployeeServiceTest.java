package com.sumgo.test;

import com.sumgo.service.EmployeeService;
import com.sumgo.vo.Employee;
import com.sumgo.vo.Engineer;
import com.sumgo.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		Employee[] arr = { 
				new Employee("e123", "aaa", "논현동", 5000), 
				new Manager("m456", "bbb", "구월동", 3500, "개발"), 
				new Engineer("eg789", "ccc", "옥련동", 4000, "JAVA", 500) 
				};
		
		EmployeeService service = EmployeeService.getInstance();
		
		service.printAllInfo(arr);
		
		service.printAddInfo(arr, "e123");
		service.printAddInfo(arr, "m456");
		service.printAddInfo(arr, "eg789");
	}

}
