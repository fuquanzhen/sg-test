package com.DuckQuestion3;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackNoWay();
	}

	public void display() {
		System.out.println("I just a Decoy duck!");
	}
}
