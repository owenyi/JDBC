package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.service.EmployeeService;
import com.encore.util.MyDate;

public class PolymorphismTest_sample {

	public static void main(String[] args) {
		// 1. �θ� Ÿ������ �ڽ� ����...
		Employee e1 = new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT");
		Employee e2 = new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java", 200);
		Employee e3 = new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert");
		Employee e4 = new Manager("��ȣ��", new MyDate(1981, 4, 2), 33000.0, "������");

		// 2. �θ� Ÿ���� �迭�� �ʱ�ȭ
		Employee[] emps = {e1, e2, e3, e4};
		
		// 3. ���� Ŭ���� ����
		EmployeeService service = new EmployeeService();
		
		service.manageEmployee(e4);
		service.manageEmployee(e2);
		
		service.printAllEmployee(emps);
	}

}
