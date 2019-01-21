package com.number33;

public class Mocha extends Condiment {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

	public double cost() {
		return 0.2 + beverage.cost();
	}
}
