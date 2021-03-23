package com.encore.cons;
/*
 * 1. 생성자
 * 객체가 생성될 때미디 구동(호출)되는 것.
 * 
 * 
 * 2. 기본 생성자
 * ::
 * 인자 값 없고
 * {} 안에서 아무런 동작도 하지 않는 생성자.
 */
public class Shirt {
	// 1. 필드 선언
	public String brandName;
	public double price;
	public boolean longSleeved;
	
	// 생성자 생략하면 public Shirt() {} 따로 쓰지 않아도 호출됨 : 기본 생성자...필드 초기화를 안한다.
	public Shirt(String brandName, double price, boolean longSleeved) {
		this.brandName = brandName;
		this.price = price;
		this.longSleeved = longSleeved;
	}
	
	public String getDetails() {
		return brandName + ", " + price + ", " + longSleeved;
	}
}
