package com.sumgo.cons.test;

import com.sumgo.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		
		Shirt longT = new Shirt("����Ű", 59000, true);
		Shirt halfT = new Shirt("�Ƶ�ٽ�", 39000, false);
		
		System.out.println(longT.getDetails());
		System.out.println(halfT.getDetails());
		
	}

}
