package collection.test;

import java.util.Enumeration;
import java.util.Properties;

/*
 * System 위에 탑제된 VM관련 환경변수들 값을 콘솔로 출력하는 로직을 작성
 * Map에 있는 데이터를 다룰 때 key를 set에 담아 handling함
 */
public class PropertiesTest1 {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperties()); // 부모가 map이기 때문에 key-value 관계가 있을 것이다.
		
		Properties p = System.getProperties();
		
		Enumeration e = p.propertyNames();
		
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = p.getProperty(name);
			System.out.println(name + "===========" + value);
		}
		
	}

}
