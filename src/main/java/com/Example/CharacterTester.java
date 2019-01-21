package com.Example;

public class CharacterTester {
	public static void main(String args[]) {
		Character king = new King();
		king.performWeapon();
		Character king2 = new King();
		king2.setWeapon(new SwordBehavior());
		king2.performWeapon();
		Character queen = new Queen();
		queen.performWeapon();
		Character troll = new Troll();
		troll.performWeapon();
		Character knight = new Knight();
		knight.performWeapon();
		Character troll2 = new Troll();
		troll2.setWeapon(new AxeBehavior());
		troll2.performWeapon();
	}
}
