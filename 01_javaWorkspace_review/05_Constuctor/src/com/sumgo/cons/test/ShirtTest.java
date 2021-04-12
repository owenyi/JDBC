package com.sumgo.cons.test;

import com.sumgo.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		
		Shirt longT = new Shirt("나이키", 59000, true);
		Shirt halfT = new Shirt("아디다스", 39000, false);
		
		System.out.println(longT.getDetails());
		System.out.println(halfT.getDetails());
		
	}

}
