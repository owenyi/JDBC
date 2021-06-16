package com.sumgo.test;

import com.sumgo.service.EmployeeService;
import com.sumgo.vo.Employee;
import com.sumgo.vo.Engineer;
import com.sumgo.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		Employee[] arr = { 
				new Employee("e123", "aaa", "������", 5000), 
				new Manager("m456", "bbb", "������", 3500, "����"), 
				new Engineer("eg789", "ccc", "���õ�", 4000, "JAVA", 500) 
				};
		
		EmployeeService service = new EmployeeService();
		
		service.printAllInfo(arr);
		
		// printAddInfo...�߰� ���� ������ִ� �޼ҵ�
		// Employee -> �߰����� ����
		// Manager -> �μ� : ����
		// Engineer -> ��� : JAVA, ���ʽ� : 500
		service.printAddInfo(arr, "e123");
		service.printAddInfo(arr, "m456");
		service.printAddInfo(arr, "eg789");
	}

}
