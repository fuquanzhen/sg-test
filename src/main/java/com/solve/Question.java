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

public class Question {
	private String path;
	private Map<String, Integer> map;

	public Question(String path) throws IOException {
		this.map = new HashMap<String, Integer>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			Object name = json.get("tagName");
			String str = name.toString();
			if (map.containsKey(str)) {
				map.put(str, map.get(str).intValue() + 1);
			} else {
				map.put(str, new Integer(1));
			}
		}
	}

	public List<Entry<String, Integer>> sort() {
		List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int q1 = o1.getValue();
				int q2 = o2.getValue();
				int q = q2 - q1;
				if (q > 0) {
					return 1;
				} else if (q == 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		return lists;
	}

	public static void write(String path, List<Entry<String, Integer>> lists) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> s : lists) {
			str.append(s.getKey() + "\t" + s.getValue() + "\n");
		}
		fw.write("Tag Name" + "\t" + "Records Count" + "\n" + str.toString());
		fw.close();
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\compare\\tmall.txt";
		String paths = "D:\\compare\\new.tsv";
		Question q = new Question(path);
		List<Entry<String, Integer>> list = q.sort();
		Question.write(paths, list);
	}
}
