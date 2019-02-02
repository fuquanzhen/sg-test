package com.DuckQuestion1;

import com.DuckQuestion1.Duck;
import com.DuckQuestion1.FlyWithWings;
import com.DuckQuestion1.Quack;

public class RedHeadDuck extends Duck {
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real RedHead duck!");
	}
}
