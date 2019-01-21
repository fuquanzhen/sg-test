package com.Coffee;

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
		Beverage beverage3 = new DarkRast();
		beverage3 = new Mocha(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
	}
}
