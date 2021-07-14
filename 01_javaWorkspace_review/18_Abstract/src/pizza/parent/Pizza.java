package pizza.parent;
/*
 * 추상(abstract) 클래스의 용도
 * 1. 여러 종류의 피자를 만들어내기 위한 공통적인 작업(필드, 메서드)은 그대로 자식들에게 물려주고
 * 2. 여러 종류의 피자가 만들어질 수 있는 결정적인 부분(토핑)은 추상 메서드로 선언해둔다
 * 
 *     완벽한 추상성 --> 인터페이스 --> 사용자와 작성자 간의 Contract
 *     부분적인 추상성 --> 추상 클래스 --> 결정적으로 다른 부분을 미완으로 물려준다. --> 자식이 미완을 완성하도록 리딩
 */
public abstract class Pizza {
	
	private int price;
	private String storeName;
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	public Pizza() {
		this(15000, "PizzaHut");
	}
	
	public void dough() {
		System.out.println("피자 반죽과 함께 도우를 만들어줍니다.");
	}
	// topping 하고 나서
	public void bake() {
		System.out.println("180도 온도에서 10분간 구워냅니다.");
	}
	public void cutting() {
		System.out.println("8조각으로 잘라줍니다.");
	}
	public void boxing() {
		System.out.println("잘려진 피자를 상자에 포장합니다.");
	}
	
	public abstract void topping();
	
	@Override
	public String toString() {
		return storeName + "피자집, " + price + "원";
	}

}
