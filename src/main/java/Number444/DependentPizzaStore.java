package Number444;

public class DependentPizzaStore {
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				return new NYStyleCheesePizza();
			} else if (type.equals("clam")) {
				return new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				return new NYStylePepperoniPizza();
			} else if (type.equals("veggie")) {
				return new NYStyleVeggiePizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				return new ChicagoStyleCheesePizza();
			} else if (type.equals("clam")) {
				return new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				return new ChicagoStylePepperoniPizza();
			} else if (type.equals("veggie")) {
				return new ChicagoStyleVeggiePizza();
			}
		} else {
			System.out.println("Error:invalid type of pizza");
			return null;
		}
		return pizza;
	}
	public Pizza orderPizza(String style, String type) {
		Pizza pizza = createPizza(style, type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
