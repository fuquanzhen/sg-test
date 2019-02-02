package com.DuckQuestion1;

import com.DuckQuestion1.Duck;
import com.DuckQuestion1.Squeak;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I'm a Rubber duck!");
	}
}
