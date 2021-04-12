package com.sumgo.javadoc;

/**
 * 
 * @author owen
 * @since JDK 1.8.0_281
 * @version [소스코드 버전 정보]...Source Code Version Level1
 */
public class JavaComment {

	/**
	 * 숨고 수강생의 이름
	 */
	public String name;
	/**
	 * 숨고 수강생의 아이디
	 */
	public int stuId;
	/**
	 * @param java test score
	 * @param python test score
	 * @return 자바와 파이썬 성적의 합산으로 수강생의 최종 성적
	 */
	public int scoreSum(int java, int python) {
		return java + python;
	}
	
}
