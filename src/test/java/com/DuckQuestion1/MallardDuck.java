package com.DuckQuestion1;

import com.DuckQuestion1.Duck;
import com.DuckQuestion1.FlyWithWings;
import com.DuckQuestion1.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Mallard duck!");
	}
}
