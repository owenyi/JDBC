package io.test;

import java.util.Scanner;

/*
 * Scanner Ŭ������
 * �����(�����Ͻð� �ƴ�) �ܼ�â���κ��� Ű����� �Էµ� ���� �Է¹޵��� ���ִ� ����� ������ �ִ� Ŭ����
 */
public class IOTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ű����� ���� 2���� �̸��� �Է��ϼ���>>>");
		
		int i = sc.nextInt(); // ������ �������� �����͸� ��ȯ�Ѵ�.
		int j = sc.nextInt();
		sc.nextLine(); // �� ������ ������ �����͸� ��ȯ
		String name = sc.nextLine();
		
		System.out.println("���ڰ� i : " + i + ", j : " + j);
		System.out.println(name);
	}

}
