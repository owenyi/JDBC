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
		
		// Robert가 부서를 바꾼다...IT --> Marketing
		m.changeDept("Marketing");
		
		System.out.println(emp.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		System.out.println(ss.getDetails());
		
		/////////////// Polymorphism ///////////////////////////////////////////////////
		///// 부모 타입으로 자식을 생성한다. ////////////////////////////////////////////////////
		System.out.println("================Polymorphism======================================");
		
		Employee e1 = new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT");
		Employee e2 = new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java", 200);
		Employee e3 = new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert");
		
		/*
		 * 1. Virtual Method(생성된 자식의 메서드) Invocation 원리
		 * 딱 한 경우 : 상속 관계의 두 개의 클래스에서 메서드 오버라이딩을 했을 때 발생
		 * 
		 * Compile Time Type 메서드 - 부모의 메서드가 호출
		 * Runtime Type 메서드 - 자식의 메서드 호출
		 * 
		 * e1에서 어떻게 알고 런타임 시점에 자식의 getDetails를 부르는지???
		 * 
		 * 2. Object Casting 기법 필요...부모로 찾으면 안되고 자식 변수로 찾아야 한다...자식만의 기능이기 때문에
		 * 캐스팅은 메모리에서 어떻게???
		 */
		
//		e1.changeDept("Marketing"); // 여기서는 안된다...
		
 		((Manager) e1).changeDept("Marketing");
//		Manager m1 = (Manager)e1;
//		m1.changeDept("Marketing");
		
		System.out.println(e1.getDetails());
		System.out.println(e2.getDetails());
		System.out.println(e3.getDetails());
	}
}
