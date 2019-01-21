package com.DuckNewQuestion;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public void proformFly() {
		flyBehavior.fly();
	}

	public void proformQuack() {
		quackBehavior.quack();
	}

	public abstract void display();

	public void swim() {
		System.out.println("All ducks float,even decoys!");
	}

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}
