package com.encore.vo;
/*
 * db테이블의 Record를 인스턴스화시킨 클래스
 * DO(Domain Object) ---> VO(Value Object) ---> DTO(Domain Transfer Object)
 * 테이블의 컬럼이 클래스의 필드와 연결된다.
 */
public class Person {

	private int ssn;
	private String name;
	private String address; // addr 이렇게 작성하면 좋지않음...DB와 통일시키는 게 좋다.
	public Person(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	public Person() {
		super();
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", name=" + name + ", address=" + address + "]";
	}
	
}
