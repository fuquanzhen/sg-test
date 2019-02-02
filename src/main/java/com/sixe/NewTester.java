package com.sixe;

import java.util.HashSet;
import java.util.Set;

public class NewTester {
	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		System.out.println(set);
		set.remove(2);
		System.out.println(set);
		set.remove("b");
		System.out.println(set);
	}
}
