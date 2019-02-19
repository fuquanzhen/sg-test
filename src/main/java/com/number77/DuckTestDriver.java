package com.number77;

public class DuckTestDriver {
	public static void main(String args[]) {
		Duck duck = new MallardDuck();
		Turkey turkey = new WildTurkey();
		DuckAdapter duckAdapter = new DuckAdapter(duck);
		System.out.println("The Duck says...");
		duck.quack();
		duck.fly();
		System.out.println("\nThe Turkey says...");
		testDuck(turkey);
		System.out.println("\nThe DuckAdapter says...");
		testDuck(duckAdapter);
	}

	public static void testDuck(Turkey turkey) {
		turkey.gobble();
		turkey.fly();
	}
}
