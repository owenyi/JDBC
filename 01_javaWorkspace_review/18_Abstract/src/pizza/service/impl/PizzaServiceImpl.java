package pizza.service.impl;

import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceImpl implements PizzaService {
	
	static final public PizzaServiceImpl service = new PizzaServiceImpl();
	private PizzaServiceImpl() {};
	public static PizzaServiceImpl getInstance() {
		return service;
	}

	@Override
	public void makePizza(Pizza pizza) {
		// 피자 만드는 순서대로 method를 실행
		
	}

	@Override
	public void allMakePizza(Pizza[] pizzas) {
		// pizza의 배열을 받아와서 각 피자에 makePizza를 실행
//		for (Pizza p : pizzas) {
//			// pizza 정보 출력(toString)
//			// pizza 만드는 과정 출력
//			System.out.println("====================");
//		}
	}

}
