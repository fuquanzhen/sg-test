package com.DuckQuestion;

import com.DuckQuestion.DecoyDuck;
import com.DuckQuestion.Duck;
import com.DuckQuestion.FlyRocket;
import com.DuckQuestion.MallardDuck;
import com.DuckQuestion.RedHeadDuck;
import com.DuckQuestion.RubberDuck;

public class DuckTest {
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
		Duck rubber1 = new RubberDuck();
		rubber1.setFlyBehavior(new FlyRocket());
		rubber1.performFly();
		rubber1.performQuack();
	}
}
