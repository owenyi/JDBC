package poly.test;

import poly.service.EmployeeService;
import poly.service.impl.EmployeeServiceImpl;
import poly.vo.Employee;
import poly.vo.Engineer;
import poly.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		
		EmployeeService service = EmployeeServiceImpl.getInstance();
		
		Employee e = new Employee("e123", "aaa", "구월동", 450);
		Employee m = new Manager("m456", "bbb", "논현동", 320, "개발부");
		Employee eg = new Engineer("eg123", "ccc", "논현동", 300, "JAVA", 100);
		Employee eg1 = new Engineer("eg456", "ddd", "송도동", 500, "JQuery", 50);
		
		System.out.println("===== 0. printInfo calling =====");
		service.printInfo(e);
		service.printInfo(m);
		
		Employee[] ea = { e, m, eg, eg1 };
		
		System.out.println("===== 1. printAllInfo calling =====");
		service.printAllInfo(ea);
		
		System.out.println("===== 2. findByEmpId calling =====");
		Employee emp = service.findByEmpId(ea, "e123");
		service.printInfo(emp);
		
		System.out.println("===== 3. findByAddress calling =====");
		Employee[] empArr = service.findByAddress(ea, "논현동");
		for (Employee employee : empArr)
			service.printInfo(employee);
		
		System.out.println("===== 4. getAnnualSalary calling =====");
		System.out.println(service.getAnnualSalary(e)); // 450 * 12
		System.out.println(service.getAnnualSalary(eg)); // 300 * 12 + bonus
		
		System.out.println("===== 5. getTotalCost calling =====");
		System.out.println(service.getTotalCost(ea));
		
	}

}
