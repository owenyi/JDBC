package com.sumgo.cons;
/*
 * 1. 생성자
 *   객체를 생성할 때 사용하는 것
 * 2. 기본 생성자
 *   인자 값 없고
 *   아무런 동작도 하지 않는다.
 */
public class Shirt {

	public String brandName;
	public int price;
	public boolean longSleeved;
	
	public Shirt(String brandName, int price, boolean longSleeved) {
		this.brandName = brandName;
		this.price = price;
		this.longSleeved = longSleeved;
	}
	
	public String getDetails() {
		return brandName + ", " + price + ", " + longSleeved;
	}
	
}