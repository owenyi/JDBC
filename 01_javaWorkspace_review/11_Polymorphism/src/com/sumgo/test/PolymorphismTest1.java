package com.sumgo.test;

import com.sumgo.child.Child;
import com.sumgo.parent.Parent;

public class PolymorphismTest1 {

	public static void main(String[] args) {
		Parent pa = new Parent();
		Child ch = new Child();
		Parent pc = new Child();
//		Child cp = new Parent(); // ¾ê´Â ¾È µÊ
	}

}
