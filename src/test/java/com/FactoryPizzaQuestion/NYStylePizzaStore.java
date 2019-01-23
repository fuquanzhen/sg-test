package com.FactoryPizzaQuestion;

public class NYStylePizzaStore extends PizzaStore {
	protected Pizza createPizza(String item) {
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		Pizza pizza = null;
		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		if (item.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
		}
		if (item.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		}
		if (item.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		}
		return pizza;
	}
}
