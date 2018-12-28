package com.sixe;
import java.util.HashSet;
import java.util.Iterator;
public class Lesson1 {
	public static void main(String args[]) {
		HashSet<Integer> hash = new HashSet<Integer>();
		hash.add(1);
		hash.add(2);
		hash.add(3);
		hash.add(4);
		hash.add(5);
		hash.remove(3);
		Iterator<Integer> itr = hash.iterator();
		while (itr.hasNext()) {
			Integer str = itr.next();
			System.out.println(str);
		}
		System.out.println(hash);
		System.out.println(hash.size());
	}
}
