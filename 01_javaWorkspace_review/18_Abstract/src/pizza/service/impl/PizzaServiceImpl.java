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
		// ���� ����� ������� method�� ����
		
	}

	@Override
	public void allMakePizza(Pizza[] pizzas) {
		// pizza�� �迭�� �޾ƿͼ� �� ���ڿ� makePizza�� ����
//		for (Pizza p : pizzas) {
//			// pizza ���� ���(toString)
//			// pizza ����� ���� ���
//			System.out.println("====================");
//		}
	}

}
