package datatype.test;

import datatype.WhiteBoard;
/*
 * �׽�Ʈ Ŭ������ �ϴ� ��
 * 1) ��ü ����...��ü�� �������(�ı�)�� �޸𸮿� �ø���.
 * 2) �ı��� ����
 *    �ʵ� --- �� �Ҵ�
 *    �޼ҵ� --- Calling
 */
public class WhiteBoardTest {

	public static void main(String[] args) {
		
		WhiteBoard wb = new WhiteBoard();
		
		wb.setFeild(36, 'W', 115.5f, "�Ｚ", true);

		System.out.println(wb.toString());
		
	}

}
