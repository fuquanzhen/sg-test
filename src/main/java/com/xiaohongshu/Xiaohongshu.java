package com.xiaohongshu;

import java.io.BufferedReader;
import java.io.FileInputStream;
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

public class Xiaohongshu {
	private String path;
	private List<JSONObject> list;

	public Xiaohongshu(String path) throws IOException {
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

	public int question1() {
		return list.size();
	}

	public int question2() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object stact = c.get("stact");
			if (stact != null) {
				Float fol = Float.parseFloat(stact.toString());
				Integer it = fol.intValue();
				list1.add(it);
			}
		}
		return list1.size();
	}

	public List<Entry<String, Integer>> question3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object name = c.get("name");
			Object folct = c.get("folct");
			String str = name.toString();
			Float fol = Float.parseFloat(folct.toString());
			Integer pl = fol.intValue();
			map.put(str, pl);
		}
		List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>();
		Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int q1 = o1.getValue();
				int q2 = o2.getValue();
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
		if (lists.size() > 10000) {
			return lists.subList(0, 10000);
		} else {
			return lists;
		}
	}
}
