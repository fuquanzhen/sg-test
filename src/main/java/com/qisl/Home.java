package com.qisl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Home {
	private String path;
	private Map<String, List<String>> map;

	public Home(String path) throws IOException {
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
			if (!map.containsKey(str)) {
				map.put(str, new ArrayList<String>());
			}
			if (!map.get(str).contains(stri)) {
				map.get(str).add(stri);
			}
		}
	}

	public static void write(String path, Map<String, List<String>> map) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Map.Entry<String, List<String>> c : map.entrySet()) {
			List<String> list;
			if (c.getValue().size() > 20) {
				Collections.shuffle(c.getValue());
				list = new ArrayList<String>(c.getValue().subList(0, 20));
			} else {
				list = c.getValue();
			}
			for (String s : list) {
				str.append(c.getKey() + "\t" + s + "\n");
			}
		}
		fw.write("Tag Name" + "\t" + "Content" + "\n" + str.toString());
		fw.close();
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\compare\\tmall.txt";
		String paths = "D:\\compare\\sqr.tsv";
		Home h = new Home(path);
		Map<String, List<String>> newmap = h.map;
		Home.write(paths, newmap);
	}
}
