package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;

public class GreetTestApp04UseSpring {

	public static void main(String[] args) {
		// 1. 공장을 생성..이 때 주문서를 읽어들이도록 한다.
		// --> 알아서 공장 안에서 주문서에 적힌 객체를 생성하고 저장하고 있는다.
		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource("./src/main/resources/config/greet.xml")); // 파일 시스템이기 때문에 src 패키지 인식이 안 된다...src부터 다 넣어야 한다.
		
		// 2. 공장에서 저장하고 있는 빈을 받아온다...getBean() 사용
		Greet greet1 = (Greet) factory.getBean("greet1"); // Object로 받아오니 캐스팅
		// 3. 받아온 빈의 메소드를 호출...
		greet1.printMessage();
		System.out.println("==========================");
		
		Greet greet2 = (Greet) factory.getBean("greet2");
		greet2.printMessage();
		System.out.println("==========================");
		
		Greet greet3 = (Greet) factory.getBean("greet3");
		greet3.printMessage();
		System.out.println("==========================");
		
		Greet greet4 = (Greet) factory.getBean("greet4");
		greet4.printMessage();
		System.out.println("==========================");
		
		String str1 = (String) factory.getBean("str1");
		System.out.println(str1);
		System.out.println("==========================");
		
		Greet greet5 = (Greet) factory.getBean("greet5");
		greet5.printMessage();
		System.out.println("==========================");
		
		Greet greet6 = (Greet) factory.getBean("greet6");
		greet6.printMessage();
		System.out.println("==========================");
	}

}
