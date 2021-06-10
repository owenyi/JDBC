package com.sumgo.test;

import com.sumgo.child.Child;
import com.sumgo.parent.Parent;

public class PolymorphismTest3 {

	public static void main(String[] args) {
		Parent paNull = null;
		Child chNull = null;
		
		Child ch = new Child();
		Parent pc = new Child();
		Parent pa = new Parent();
		
		paNull = ch;
		// Object Casting
		chNull = (Child) pc;
//		chNull = (Child) pa; // ¾ê´Â ¾È µÊ
	}

}