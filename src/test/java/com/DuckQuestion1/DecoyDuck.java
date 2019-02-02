package com.DuckQuestion1;

import com.DuckQuestion1.Duck;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackNoWay();
	}

	public void display() {
		System.out.println("I'm a Decoy duck!");
	}
}
