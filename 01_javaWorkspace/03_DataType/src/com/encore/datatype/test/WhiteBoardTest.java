package com.encore.datatype.test;

import com.encore.datatype.WhiteBoard;

/*
 * WhiteBoardTest1...�׽�Ʈ Ȥ�� ���� Ŭ������ �θ���.
 * 
 * �׽�Ʈ Ŭ������ �ϴ� ��
 * 1) ��ü�� �����Ѵ� == ��ü�� �������(�ı�)�� �޸𸮿� �ø���.
 * 2) �ı��� ����
 *    �ʵ� ----   �� �Ҵ� ---- ���� ���� �ϵ��ڵ��Ǹ� �װ��� ���α׷��� �ƴϴ�...�ϸ� �� ��
 *    �޼ҵ� ---   Calling
 */
public class WhiteBoardTest {

	public static void main(String[] args) {
		WhiteBoard wb = new WhiteBoard();
		
		wb.setField(36, '��', 115.6f, "�Ｚ", "�˷�̴�", false);

		wb.printInfo();
	}

}
