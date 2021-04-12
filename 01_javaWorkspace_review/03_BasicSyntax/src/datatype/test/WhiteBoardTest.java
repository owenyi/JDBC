package datatype.test;

import datatype.WhiteBoard;
/*
 * 테스트 클래스가 하는 일
 * 1) 객체 생성...객체의 구성요소(식구)를 메모리에 올린다.
 * 2) 식구에 접근
 *    필드 --- 값 할당
 *    메소드 --- Calling
 */
public class WhiteBoardTest {

	public static void main(String[] args) {
		
		WhiteBoard wb = new WhiteBoard();
		
		wb.setFeild(36, 'W', 115.5f, "삼성", true);

		System.out.println(wb.toString());
		
	}

}
