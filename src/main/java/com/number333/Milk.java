package com.number333;

public class Milk extends Condiment {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",Milk";
	}

	public double cost() {
		return beverage.cost() + 0.10;
	}
}
