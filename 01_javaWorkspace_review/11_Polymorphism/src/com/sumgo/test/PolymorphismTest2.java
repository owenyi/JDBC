package com.sumgo.test;

import com.sumgo.child.Child;
import com.sumgo.parent.Parent;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		Parent pc = new Child();
		// Virtual Method Invocation
		// 컴파일 시점 - 부모의 메소드
		// 런타임 시점 - 자식의 메소드
		pc.methodA(); // 결과 예측
//		pc.methodB();
	}

}