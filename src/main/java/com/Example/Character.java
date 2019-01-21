package com.Example;

public abstract class Character {
	WeaponBehavior weaponBehavior;

	public Character() {
	}

	public void performWeapon() {
		weaponBehavior.useWeapon();
	}

	public abstract void fight();

	public void setWeapon(WeaponBehavior w) {
		weaponBehavior = w;
	}
}
