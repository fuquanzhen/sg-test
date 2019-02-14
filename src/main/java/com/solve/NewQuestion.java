package com.solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class NewQuestion {
	private String path;
	private static Map<String, List<String>> map;

	public NewQuestion(String path) throws IOException {
		this.map = new HashMap<String, List<String>>();
		List<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\compare\\tmall.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			Object name = json.get("tagName");
			Object content = json.get("content");
			String str = name.toString();
			String stri = content.toString();
			if (map.containsKey(str)) {
				list = map.get(str);
				list.add(stri);
				map.put(str, list);
			} else {
				list.add(stri);
				map.put(str, list);
			}
		}
	}

	public static void main(String args[]) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter("D:\\compare\\newfile.tsv", false);
		for (Map.Entry<String, List<String>> c : map.entrySet()) {
			str.append(c.getKey() + "\t" + c.getValue() + "\n");
		}
		fw.write("Tag Name" + "\t" + "Content" + "\n" + str.toString());
		fw.close();
	}
}
