package com.Example;

public class King extends Character {
	public King() {
		weaponBehavior = new BowAndArrowBehavior();
	}

	public void fight() {
		System.out.println("I'm a King,I can fighting!");
	}
}
