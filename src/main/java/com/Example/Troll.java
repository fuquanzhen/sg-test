package com.Example;

public class Troll extends Character {
	public Troll() {
		weaponBehavior = new BowAndArrowBehavior();
	}

	public void fight() {
		System.out.println("I'm a Troll,I can fighting!");
	}
}
