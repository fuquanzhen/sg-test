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

public class True {
	private String path;
	private static Map<String, List<String>> map;

	// scope 0
	public True(String path) throws IOException {
		this.map = new HashMap<String, List<String>>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		// scope 1
		while ((line = br.readLine()) != null) {
			// scope 2
			JSONObject json = JSONObject.parseObject(line);
			Object name = json.get("tagName");
			Object content = json.get("content");
			String str = name.toString();
			String stri = content.toString();
			if (!map.containsKey(str)) {
				// scope 3
				map.put(str, new ArrayList<String>());
			}
			map.get(str).add(stri);
		}
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
		String paths = "D:\\compare\\newsfile.tsv";
		True q = new True(path);
		Map<String, List<String>> newmap = q.map;
		True.write(paths, newmap);
	}
}
