package com.DuckQuestion;

import com.DuckQuestion.Duck;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		flyBehavior = new FlyNoway();
		quackBehavior = new QuackNoway();
	}

	public void display() {
		System.out.println("I'm a Decoy Duck!");
	}
}
