package com.DuckQuestion;

import com.DuckQuestion.Duck;
import com.DuckQuestion.Squeak;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoway();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I'm a Rubber Duck!");
	}
}
