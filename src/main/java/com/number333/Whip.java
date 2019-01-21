package com.number333;

public class Whip extends Condiment {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",Whip";
	}

	public double cost() {
		return beverage.cost() + 0.10;
	}
}
