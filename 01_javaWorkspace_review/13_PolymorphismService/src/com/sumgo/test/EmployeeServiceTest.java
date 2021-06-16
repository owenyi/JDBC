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
		
		EmployeeService service = new EmployeeService();
		
		service.printAllInfo(arr);
		
		// printAddInfo...추가 정보 출력해주는 메소드
		// Employee -> 추가정보 없음
		// Manager -> 부서 : 개발
		// Engineer -> 기술 : JAVA, 보너스 : 500
		service.printAddInfo(arr, "e123");
		service.printAddInfo(arr, "m456");
		service.printAddInfo(arr, "eg789");
	}

}
