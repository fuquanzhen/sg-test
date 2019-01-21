package com.Example;

public class Knight extends Character {
	public Knight() {
		weaponBehavior = new KnifeBehavior();
	}

	public void fight() {
		System.out.println("I'm a Knight,I can fighting!");
	}
}
