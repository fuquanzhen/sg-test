package com.sixe;

import java.util.HashMap;

public class Lesson4 {
	public static void main(String args[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("li", 1);
		map.put("wang", 2);
		map.put("sun", 3);
		map.put("zhao", 4);
		map.put("xie", 5);
		map.remove("sun");
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		for (Integer value : map.values()) {
			System.out.println(value);
		}
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("zhao"));
	}
} 
