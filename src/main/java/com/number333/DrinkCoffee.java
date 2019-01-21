package com.number333;

public class DrinkCoffee {
	public static void main(String args[]) {
		Beverage beverage = new HouseBlend();
		beverage = new Soy(beverage);
		beverage = new Mocha(beverage);
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		Beverage beverage2 = new Espresso();
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
	}
}
