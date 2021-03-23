package collection.test;

import java.util.Enumeration;
import java.util.Properties;

/*
 * System ���� ž���� VM���� ȯ�溯���� ���� �ַܼ� ����ϴ� ������ �ۼ�
 * Map�� �ִ� �����͸� �ٷ� �� key�� set�� ��� handling��
 */
public class PropertiesTest1 {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperties()); // �θ� map�̱� ������ key-value ���谡 ���� ���̴�.
		
		Properties p = System.getProperties();
		
		Enumeration e = p.propertyNames();
		
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = p.getProperty(name);
			System.out.println(name + "===========" + value);
		}
		
	}

}
