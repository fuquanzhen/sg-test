package com.number1;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I just a Rubber duck!");
	}
}
