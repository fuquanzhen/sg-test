package com.solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSONObject;

public class Solve {
	private String path;
	private List<JSONObject> list;

	public Solve(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public List<Entry<String, Integer>> solve() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object name = c.get("tagName");
			String str = name.toString();
			if (map.containsKey(str)) {
				map.put(str, map.get(str).intValue() + 1);
			} else {
				map.put(str, new Integer(1));
			}
		}
		List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> a1, Map.Entry<String, Integer> a2) {
				int q1 = a1.getValue();
				int q2 = a2.getValue();
				int p = q2 - q1;
				if (p > 0) {
					return 1;
				} else if (p == 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		return lists;
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\compare\\tmall.txt";
		String newPath = "D:\\compare\\tag.tsv";
		Solve q = new Solve(path);
		List<Entry<String, Integer>> list = q.solve();
		Solve.export(newPath, list);
	}

	public static void export(String path, List<Entry<String, Integer>> lists) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> s : lists) {
			str.append(s.getKey() + "\t" + s.getValue() + "\n");
		}
		fw.write("Tag Name" + "\t" + "Records Count" + "\n" + str.toString());
		fw.close();
	}
}
