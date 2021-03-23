package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

/*
 * Collection
 * 1. Homogeneous Collection(동종간의 집합체)
 * 2. Heterogeneous Collection(이기종간의 집합체)
 */
public class HeterogeneousCollectionTest3 {

	public static void main(String[] args) {
		
		Employee[] emps = {
				new Employee("James", new MyDate(1982, 3, 2), 23000.0),
				new Manager("Robert", new MyDate(1981, 4, 2), 33000.0, "IT"),
				new Engineer("Gosling", new MyDate(1978, 1, 2), 33000.0, "Java", 200),
				new Secretary("Peter", new MyDate(1988, 1, 2), 34000.0, "Robert")
		};
		
		/*
		 * for문과 instanceof를 사용해서
		 * Robert의 부서를 IT --> Marketing
		 * Gosling tech JAVA --> Python
		 * Peter nameOfBoss Robert --> Gosling
		 */
		
		for (Employee e : emps) {
			if (e instanceof Manager) {
				((Manager) e).changeDept("Marketing");
			} 
			if (e instanceof Engineer) {
				((Engineer) e).changeTech("Python");
			} 
			if (e instanceof Secretary) {
				((Secretary) e).changeNameOfBoss("Gosling");
			}
			
			System.out.println(e.getDetails());
		}
	}

}
