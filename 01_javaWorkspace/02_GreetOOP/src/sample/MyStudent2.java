package sample;

/*
 * �ʵ忡 ���� �Է��ϴ� ����� �߰�...
 */

public class MyStudent2 {
	// �ʵ� ����
	public String name;
	public int age;
	public String address;
	
	public void setField(String n, int a, String add) {
		name = n;
		age = a;
		address = add;
	}
	
	public void printInfo() {
		System.out.println(name + ", " + age + ", " + address);
	}
}
