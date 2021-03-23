package pizza.parent;
/*
 * 추상 클래스의 용도
 * 1. 여러 종류의 피자를 만들어내기 위한 공통적인 작업(필드, 메서드)은 그대로 자식들에게 물려주고
 * 2. 반면에 여러 종류의 피자가 만들어질 수 있는 결정적인 부분은 추상 메서드로 선언해둔다public abstract void topping();
 *                                                                  interface 아니기 때문에 이 경우에는 public abstract 생략 불가
 *    완벽한 추상성 --> 인터페이스 --> 사용자와 작성자 간의 Contract
 *    부분적인 추상성 --> 추상 클래스 --> 결정적으로 다른 부분을 미완으로 물려준다 --> 자식이 미완을 완성하도록 리딩...
 * 
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public Pizza() {
		this(15000, "PizzaHut");
	}
	
	// 기능을 하나 더 추가
	public void makePizza() {
		dough();
		
		topping();
		
		bake();
		cutting();
		boxing();
	}
	
	public void dough() {
		System.out.println("피자 반죽과 함께 도우를 잘 만들어 줍니다...");
	}
	
	public void bake() {
		System.out.println("180도 온도에서 10분간 구워냅니다.");
	}
	
	public void cutting() {
		System.out.println("8조각으로 잘라줍니다.");
	}
	
	public void boxing() {
		System.out.println("잘려진 피자를 상자에 포장합니다.");
	}

	
	// 정보 리턴하는 기능 추가
	public abstract void topping();

	@Override
	public String toString() {
		return storeName + "피자집" + price + "원";
	}
	
}
