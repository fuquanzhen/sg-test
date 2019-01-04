package com.sixe;

import java.util.ArrayList;
import java.util.Iterator;

public class Lesson2 {
	
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.remove(2);
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer str = itr.next();
			System.out.println(str);
		}
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list);
		System.out.println(list.size());
	}
}
