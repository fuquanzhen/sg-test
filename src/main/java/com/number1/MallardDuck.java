package com.number1;

public class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior = new FlyWithWing();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Mallard duck!");
	}
}
