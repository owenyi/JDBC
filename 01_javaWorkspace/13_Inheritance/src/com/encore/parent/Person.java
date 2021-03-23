package com.encore.parent;

public class Person {
	
	private String name;
	private int age;
	private String address;
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString(); // 주소값 같은 건 알 필요가 없음
		return name + ", " + age + ", " + address;
	}

}
