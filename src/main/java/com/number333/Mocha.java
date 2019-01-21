package com.number333;

public class Mocha extends Condiment {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

	public double cost() {
		return beverage.cost() + 0.20;
	}
}
