package com.solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

public class Problem {
	private String path;
	private Map<String, List<String>> map;

	public Problem(String path) throws IOException {
		this.map = new HashMap<String, List<String>>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			Object name = json.get("tagName");
			Object content = json.get("content");
			String str = name.toString();
			String stri = content.toString();
			List<String> list = new ArrayList<String>();
			if (!map.containsKey(str)) {
				map.put(str, new ArrayList<String>());
			}
			map.get(str).add(stri);
		}
	}

	public Map<String, List<String>> solve() {
		Map<String, List<String>> newmap = new HashMap<String, List<String>>();
		for (Map.Entry<String, List<String>> c : map.entrySet()) {
			if (c.getValue().size() > 20) {
				Collections.shuffle(c.getValue());
				List<String> subList = new ArrayList<String>(c.getValue().subList(0, 20));
				newmap.put(c.getKey(), subList);
			} else {
				newmap.put(c.getKey(), c.getValue());
			}
		}
		return newmap;
	}

	public static void write(String path, Map<String, List<String>> map) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		Set<String> set = new HashSet<String>();
		for (Map.Entry<String, List<String>> c : map.entrySet()) {
			for (String s : c.getValue()) {
				str.append(c.getKey() + "\t" + s + "\n");
			}
		}
		fw.write("Tag Name" + "\t" + "Content" + "\n" + str.toString());
		fw.close();
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\compare\\tmall.txt";
		String paths = "D:\\compare\\newfile.tsv";
		Problem t = new Problem(path);
		Map<String, List<String>> newmap = t.solve();
		Problem.write(paths, newmap);
	}
}
