package PizzaNewQuestion;

public class ChicagoPizzaStore extends PizzaStore {
	public Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else {
			return null;
		}
	}

	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
