package com.DuckQuestion;

import com.DuckQuestion.Duck;
import com.DuckQuestion.FlyWithWings;
import com.DuckQuestion.Quack;

public class RedHeadDuck extends Duck {
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a real Red Head Duck!");
	}
}
