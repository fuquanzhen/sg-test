package com.fquanz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

public class Question {
	private String path;
	private List<JSONObject> list;

	public Question(String path) throws IOException {
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

	public int newquestion1() {
		int count = 0;
		for (JSONObject c : list) {
			count++;
		}
		return count;
	}

	public int question2() {
		Set<String> set = new HashSet<String>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			set.add(str);
		}
		return set.size();
	}

	public int newquestion2() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			if (map.containsKey(str)) {
				map.put(str, map.get(str).intValue() + 1);
			} else {
				map.put(str, new Integer(1));
			}
		}
		return map.size();
	}

	public Resultq3 question3() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			Integer pl = Integer.parseInt(cmtct.toString());
			list1.add(pl);
		}
		float sum = 0;
		float avg = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum = list1.get(i) + sum;
		}
		avg = sum / list1.size();
		float z = 0;
		if ((list1.size() % 2) != 0) {
			z = list1.get((list1.size() - 1) / 2);
		} else {
			z = (list1.get(list1.size() / 2) + list1.get((list.size() / 2) - 1)) / 2;
		}
		Resultq3 rel = new Resultq3(Collections.max(list1), Collections.min(list1), sum, avg, z);
		return rel;
	}

	public Resultq3 newquestion3() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			Integer pl = Integer.parseInt(cmtct.toString());
			list1.add(pl);
		}
		float sum = 0;
		float avg = 0;
		int i = 0;
		while (i < list1.size()) {
			sum = list1.get(i) + sum;
			i++;
		}
		avg = sum / list1.size();
		float z = 0;
		if ((list1.size() % 2) != 0) {
			z = list1.get((list1.size() - 1) / 2);
		} else {
			z = (list1.get(list.size() / 2) + list1.get((list1.size() / 2) - 1)) / 2;
		}
		Resultq3 rel = new Resultq3(Collections.max(list1), Collections.min(list1), sum, avg, z);
		return rel;
	}

	public List<Entry<String, Integer>> question4() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			if (map.containsKey(str)) {
				map.put(str, map.get(str).intValue() + 1);
			} else {
				map.put(str, new Integer(1));
			}
		}
		List<Entry<String, Integer>> listss = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(listss, new Comparator<Map.Entry<String, Integer>>() {
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
		return listss;
	}
}
