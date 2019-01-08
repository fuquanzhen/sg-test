package com.sixe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Lesson3 {
	public static void main(String args[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("li", 1);
		map.put("wang", 2);
		map.put("sun", 3);
		map.put("zhao", 4);
		map.put("xie", 5);
		map.remove("xie");
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Integer> entry = entries.next();
			System.out.println(entry.getKey() + "\n" + entry.getValue());
		}
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("zhao"));
	}
}
 