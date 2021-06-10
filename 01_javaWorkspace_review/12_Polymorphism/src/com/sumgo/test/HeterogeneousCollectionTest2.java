package com.sumgo.test;

import com.sumgo.child.Engineer;
import com.sumgo.child.Manager;
import com.sumgo.child.Secretary;
import com.sumgo.parent.Employee;
import com.sumgo.util.MyDate;

// Heterogeneous : 이기종(서로 다른 종류)
// Heterogeneous Collection : 이기종간의 집합체
public class HeterogeneousCollectionTest2 {

	public static void main(String[] args) {
		
		Employee[] emps = {
				new Employee("James", new MyDate(1982, 3, 2), 3000), 
				new Manager("Robert", new MyDate(1981, 4, 2), 3500, "Accounting"), 
				new Engineer("Gosling", new MyDate(1978, 1, 2), 3300, "JAVA", 200), 
				new Secretary("Peter", new MyDate(1988, 1, 2), 3400, "Robert")
		};
		
		// Virtual Method Invocation
		for (Employee e : emps) {
			System.out.println(e.getDetails());
		}
		
		// Object Casting, instanceof 키워드
		System.out.println("=====연봉 출력=====");
		for (Employee e : emps) {
			if (e instanceof Engineer) System.out.println(e.getSalary() * 12 + ((Engineer) e).getBonus());
			else System.out.println(e.getSalary() * 12);
		}
		
	}

}
