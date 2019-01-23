package Number444;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList();

	public String getName() {
		return name;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings...");
		for (String topping : toppings) {
			System.out.println("   " + topping);
		}
	}

	public void bake() {
		System.out.println("Bake the rizza for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place the pizza in official PizzaStore box");
	}

	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("----" + name + "----" + "\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < toppings.size(); i++) {
			display.append(toppings.get(i) + "\n");
		}
		return display.toString();
	}
}
