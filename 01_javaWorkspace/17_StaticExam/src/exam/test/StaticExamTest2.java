package exam.test;

class Car {
	int serialNumber; // field
	static int counter; // static
	
	Car() { // 생성자는 클래스를 따라가기 때문에 public 안 붙이는 게 맞음
		this.serialNumber = counter++;
	}
	
	
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("================= field ===================");
		System.out.println(c1.serialNumber);
		System.out.println(c2.serialNumber);
		System.out.println(c3.serialNumber);
		System.out.println("================= static variable ===================");
		System.out.println(c1.counter);
		System.out.println(c2.counter);
		System.out.println(c3.counter);
	}

}
