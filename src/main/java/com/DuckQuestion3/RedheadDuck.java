package com.DuckQuestion3;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Reahead duck!");
	}
}
