package com.sumgo.test;

import com.sumgo.child.Child;
import com.sumgo.parent.Parent;

public class PolymorphismTest4 {

	public static void main(String[] args) {
		// instanceof Å°¿öµå
		Parent pa = new Parent();
		System.out.println(pa instanceof Parent); // true
		System.out.println(pa instanceof Child); // false
		
		Parent pc = new Child();
		System.out.println(pc instanceof Parent); // true
		System.out.println(pc instanceof Child); // true
	}

}