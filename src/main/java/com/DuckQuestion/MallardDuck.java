package com.DuckQuestion;

import com.DuckQuestion.Duck;
import com.DuckQuestion.FlyWithWings;
import com.DuckQuestion.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Mallard Duck!");
	}
}
