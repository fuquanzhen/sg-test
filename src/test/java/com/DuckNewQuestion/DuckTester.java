package com.DuckNewQuestion;

public class DuckTester {
	public static void main(String args[]) {
		Duck mallard = new MallardDuck();
		mallard.proformFly();
		mallard.proformQuack();
		Duck redhead = new RedHeadDuck();
		redhead.proformFly();
		redhead.proformQuack();
		Duck rubber = new RubberDuck();
		rubber.proformFly();
		rubber.proformQuack();
		Duck decoy = new DecoyDuck();
		decoy.proformFly();
		decoy.proformQuack();
		Duck rubber2 = new RubberDuck();
		rubber2.setFlyBehavior(new FlyRocket());
		rubber2.proformFly();
		rubber2.proformQuack();
	}
}
