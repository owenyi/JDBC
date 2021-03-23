package poly.vo;

public class Employee {
	private String empId;
	private String name;
	private String addr;
	private int salary;
	
	public Employee(String empId, String name, String addr, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}
	
	public String getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr + ", salary=" + salary + "]";
	}
}
