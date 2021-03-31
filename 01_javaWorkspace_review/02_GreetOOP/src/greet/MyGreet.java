package greet;

/*
 * MyGreet 클래스는
 * 인삿말을 콘솔창으로 출력하는 기능을 갖고 있는 클래스...
 */
public class MyGreet {
	
	public String message = "Hello"; // Field
	
	public void sayHello(String name) { // Method
		System.out.println(message + ", " + name);
	}
	
}
