package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Employee emp = new Employee("James", new MyDate(1982, 3, 2), 23000.0);
		Manager m = new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT");
		Engineer eg = new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java", 200);
		Secretary ss = new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert");
		
		// Robert�� �μ��� �ٲ۴�...IT --> Marketing
		m.changeDept("Marketing");
		
		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(ss.getDetails());
		
		/////////////// Polymorphism ///////////////////////////////////////////////////
		///// �θ� Ÿ������ �ڽ��� �����Ѵ�. ////////////////////////////////////////////////////
		System.out.println("================Polymorphism======================================");
		
		Employee e1 = new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT");
		Employee e2 = new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java", 200);
		Employee e3 = new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert");
		
		/*
		 * 1. Virtual Method(������ �ڽ��� �޼���) Invocation ����
		 * �� �� ��� : ��� ������ �� ���� Ŭ�������� �޼��� �������̵��� ���� �� �߻�
		 * 
		 * Compile Time Type �޼��� - �θ��� �޼��尡 ȣ��
		 * Runtime Type �޼��� - �ڽ��� �޼��� ȣ��
		 * 
		 * e1���� ��� �˰� ��Ÿ�� ������ �ڽ��� getDetails�� �θ�����???
		 * 
		 * 2. Object Casting ��� �ʿ�...�θ�� ã���� �ȵǰ� �ڽ� ������ ã�ƾ� �Ѵ�...�ڽĸ��� ����̱� ������
		 * ĳ������ �޸𸮿��� ���???
		 */
		
//		e1.changeDept("Marketing"); // ���⼭�� �ȵȴ�...
		
 		((Manager) e1).changeDept("Marketing");
//		Manager m1 = (Manager)e1;
//		m1.changeDept("Marketing");
		
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
	}
}
