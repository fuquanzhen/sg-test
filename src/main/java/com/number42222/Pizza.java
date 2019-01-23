package com.number42222;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake the pizza for 25minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place the pizza in official PizzaStore box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("----" + name + "----" + "\n");
		if (dough != null) {
			display.append(dough);
			display.append("\n");
		}
		if (sauce != null) {
			display.append(sauce);
			display.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				display.append(veggies[i]);
				if (i < veggies.length - 1) {
					display.append(", ");
				}
			}
			display.append("\n");
		}
		if (cheese != null) {
			display.append(cheese);
			display.append("\n");
		}
		if (pepperoni != null) {
			display.append(pepperoni);
			display.append("\n");
		}
		if (clam != null) {
			display.append(clam);
			display.append("\n");
		}
		return display.toString();
	}
}
