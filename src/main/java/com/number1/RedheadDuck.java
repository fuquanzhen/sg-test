package com.number1;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		flyBehavior = new FlyWithWing();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Redhead duck!");
	}
}
