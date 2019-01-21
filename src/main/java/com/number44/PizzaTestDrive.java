package com.number44;

public class PizzaTestDrive {
	public static void main(String args[]) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		Pizza pizza = store.orderPizza("cheese");
		System.out.println("we ordered a" + pizza.getName() + "\n");
		System.out.println(pizza);
		pizza = store.orderPizza("veggie");
		System.out.println("we ordered a" + pizza.getName() + "\n");
		System.out.println(pizza);
	}
}
