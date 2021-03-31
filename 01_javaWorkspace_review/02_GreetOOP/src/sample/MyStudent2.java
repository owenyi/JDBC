package sample;

public class MyStudent2 {
	
	public String name;
	public int age;
	public String address;
	
	// 필드에 값을 입력하는 기능(메소드)을 추가
	public void setField(String n, int a, String add) {
		name = n;
		age = a;
		address = add;
	}
	
	public void printInfo() {
		System.out.println(name + ", " + age + ", " + address);
	}
	
}
