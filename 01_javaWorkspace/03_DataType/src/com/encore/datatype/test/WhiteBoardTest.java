package com.encore.datatype.test;

import com.encore.datatype.WhiteBoard;

/*
 * WhiteBoardTest1...테스트 혹은 실행 클래스라 부른다.
 * 
 * 테스트 클래스가 하는 일
 * 1) 객체를 생성한다 == 객체의 구성요소(식구)를 메모리에 올린다.
 * 2) 식구에 접근
 *    필드 ----   값 할당 ---- 실제 값이 하드코딩되면 그것은 프로그램이 아니다...하면 안 됨
 *    메소드 ---   Calling
 */
public class WhiteBoardTest {

	public static void main(String[] args) {
		WhiteBoard wb = new WhiteBoard();
		
		wb.setField(36, '흰', 115.6f, "삼성", "알루미늄", false);

		wb.printInfo();
	}

}
