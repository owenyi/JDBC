package spring.service.hello;

public class Greet {
	// field
	private String message;
	
	public Greet() {
		System.out.println(getClass().getName() + "...Instance Create...");
	}
	public Greet(String message) {
		this.message = message;
	}
	// setter&getter
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	// message 출력 기능
	public void printMessage() {
		System.out.println(getClass().getName() + "==>" + message);
	}
}
