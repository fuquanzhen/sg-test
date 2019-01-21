package com.newfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;

public class NewFile {
	private String path;
	private List<JSONObject> list;

	public NewFile(String path) throws IOException {
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

	public int fileQ1() {
		return list.size();
	}

	public int fileQ11() {
		int count = 0;
		for (JSONObject c : list) {
			count++;
		}
		return count;
	}

	public int fileQ2() {
		Set<String> set = new HashSet<String>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			set.add(str);
		}
		return set.size();
	}

	public int fileQ22() {
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

	public FileResult fileQ3() {
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
			z = (list1.get(list1.size() / 2) + list1.get((list1.size() / 2) - 1)) / 2;
		}
		FileResult rel = new FileResult(Collections.max(list1), Collections.min(list1), sum, avg, z);
		return rel;
	}

	public FileResult fileQ33() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			int pl = Integer.parseInt(cmtct.toString());
			list1.add(pl);
		}
		float sum = 0;
		float avg = 0;
		int i = 0;
		while (i < list1.size()) {
			sum = sum + list1.get(i);
			i++;
		}
		avg = sum / list1.size();
		float z = 0;
		if ((list1.size() % 2) != 0) {
			z = list1.get((list1.size() - 1) / 2);
		} else {
			z = (list1.get(list1.size() / 2) + list1.get((list1.size() / 2) - 1));
		}
		FileResult rel = new FileResult(Collections.max(list1), Collections.min(list1), sum, avg, z);
		return rel;
	}

	public List<Entry<String, Integer>> fileQ4() {
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
		List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
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
		return lists;
	}

	public List<Entry<String, Integer>> fileQ5() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object rowkey_str = c.get("rowkey_str");
			String str = rowkey_str.toString();
			Object likct = c.get("likct");
			Integer pl = Integer.parseInt(likct.toString());
			map.put(str, pl);
		}
		List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
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
		if (lists.size() > 10) {
			return lists.subList(0, 10);
		} else {
			return lists;
		}
	}

	public Map<Date, Integer> fileQ6() throws ParseException {
		Map<Date, Integer> map = new TreeMap<Date, Integer>();
		for (JSONObject c : list) {
			Object pub_time = c.get("pub_time");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(pub_time.toString());
			if (map.containsKey(date)) {
				map.put(date, map.get(date).intValue() + 1);
			} else {
				map.put(date, new Integer(1));
			}
		}
		return map;
	}

	public List<Entry<String, User>> fileQ7() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int postcount = 1;
			if (map.containsKey(str)) {
				User user = map.get(str);
				user.add();
				map.put(str, user);
			} else {
				User user = new User(str, postcount);
				map.put(str, user);
			}
		}
		List<Entry<String, User>> lists = new ArrayList<Entry<String, User>>(map.entrySet());
		Collections.sort(lists, new Comparator<Map.Entry<String, User>>() {
			public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
				int q1 = o1.getValue().getPostcount();
				int q2 = o2.getValue().getPostcount();
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

	public UserFactory fileQ8() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int postcount = 1;
			if (map.containsKey(str)) {
				User user = map.get(str);
				user.add();
				map.put(str, user);
			} else {
				User user = new User(str, postcount);
				map.put(str, user);
			}
		}
		UserFactory uf = new UserFactory(map);
		return uf;
	}
}
