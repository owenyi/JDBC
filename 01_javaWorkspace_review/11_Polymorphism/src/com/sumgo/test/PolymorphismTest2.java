package com.sumgo.test;

import com.sumgo.child.Child;
import com.sumgo.parent.Parent;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		Parent pc = new Child();
		// Virtual Method Invocation
		// ������ ���� - �θ��� �޼ҵ�
		// ��Ÿ�� ���� - �ڽ��� �޼ҵ�
		pc.methodA(); // ��� ����
//		pc.methodB();
	}

}