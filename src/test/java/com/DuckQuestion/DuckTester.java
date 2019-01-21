package com.DuckQuestion;

public class DuckTester {
	public static void main(String args[]) {
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		Duck redhead = new RedHeadDuck();
		redhead.performFly();
		redhead.performQuack();
		Duck rubber = new RubberDuck();
		rubber.performFly();
		rubber.performQuack();
		Duck decoy = new DecoyDuck();
		decoy.performFly();
		decoy.performQuack();
		Duck rubber2 = new RubberDuck();
		rubber2.setFlyBehavior(new FlyRocket());
		rubber2.performFly();
		rubber2.performQuack();
	}
}
