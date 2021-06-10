package com.sumgo.child;

import com.sumgo.parent.Parent;

public class Child extends Parent {
	@Override
	public void methodA() {
		System.out.println("자식 A");
	}
	public void methodB() {
		System.out.println("자식 B");
	}
}