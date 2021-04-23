package com.sumgo.array.test;

import com.sumgo.array.Account;

public class AccountArrayTest1 {

	public static void main(String[] args) {
		// 1. Account Ÿ�� �迭 ����...������� 3
		Account[] arr = new Account[3];
		
		// 2. ������ ĭ�� ����, ����, �츮���� ������ ����
		arr[0] = new Account(100, "����");
		arr[1] = new Account(200, "����");
		arr[2] = new Account(300, "�츮");
		
		// arr[0].bankName = "���"; // �̰� �� �Ǵϱ� setter�� �ʿ��ϴ�.
		
		// 3. for������ ���
		for (Account a : arr) {
			System.out.println(a.getDetail());
		}
	}

}
