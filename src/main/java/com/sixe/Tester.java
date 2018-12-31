package com.sixe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tester {
	public static void main(String args[]) {
		String[] s= new String[10];
		System.out.println(s.length);
//		String 
		s[0] = "a";
		s[1] = "b";
//		{"a","b","c","d","e"};
		System.out.println(s.length);
		System.out.println(s[0]);
		s[5]="f";
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		set.add("h");
		set.add("a");
		set.add("b");
		set.add("d");
		set.add("c");
		set.add("e");
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		list.remove(2);
		set.remove("c");
		map.remove("d");
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.size());
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
		System.out.println(set);
		ArrayList <String> list1 = new ArrayList<String>(set);
		System.out.println(list1.get(0));
		System.out.println(set.size());
		Iterator<String> itr1 = set.iterator();
		while (itr1.hasNext()) {
			String str = itr1.next();
			System.out.println(str);
		}
		System.out.println(map);
		System.out.println(map.get("c"));
		System.out.println(map.size());
		Iterator<Map.Entry<String, Integer>> itr2 = map.entrySet().iterator();
		while (itr2.hasNext()) {
			Map.Entry<String, Integer> entry = itr2.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}
