package pizza.test;

import pizza.child.BulgogiPizza;
import pizza.child.PineApplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;
import pizza.service.impl.PizzaServiceImpl;

public class PizzaTest {

	public static void main(String[] args) {

		PizzaService service = PizzaServiceImpl.getInstance();
		
		Pizza p1 = new PotatoPizza(20000, "Mr.Pizza");
		Pizza p2 = new BulgogiPizza(32000, "오구피자");
		Pizza p3 = new PineApplePizza(28000, "Pizza Hut");
		
		Pizza[] pizzas = { p1, p2, p3 };
		
		service.allMakePizza(pizzas);
		
	}

}
