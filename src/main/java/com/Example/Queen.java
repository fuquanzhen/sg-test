package com.Example;

public class Queen extends Character {
	public Queen() {
		weaponBehavior = new AxeBehavior();
	}

	public void fight() {
		System.out.println("I'm a Queen,I can fighting!");
	}
}
