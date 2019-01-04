package com.fuqz;

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

public class Filequestion {
	private String path;
	private List<JSONObject> list;

	public Filequestion(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader irs = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(irs);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public int question1() {
		return list.size();
	}

	public int question11() {
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

	public int question22() {
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

	public Test1 question3() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			int pl = Integer.parseInt(cmtct.toString());
			list1.add(pl);
		}
		float sum = 0;
		float avg = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum = list1.get(i) + sum;
		}
		avg = sum / list1.size();
		float h = 0;
		if ((list1.size() % 2.0) != 0) {
			h = list1.get((list1.size() - 1) / 2);
		} else {
			h = (list1.get(list1.size() / 2) + list1.get((list1.size() / 2) - 1)) / 2;
		}
		Test1 test = new Test1(Collections.max(list1), Collections.min(list1), sum, avg, h);
		return test;
	}

	public Test1 question33() {
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
		float h = 0;
		if (list1.size() % 2 != 0) {
			h = list1.get((list1.size() - 1) / 2);
		} else {
			h = ((list1.get(list1.size() / 2) + list1.get((list1.size() / 2) - 1)) / 2);
		}
		Test1 test = new Test1(Collections.max(list1), Collections.min(list1), sum, avg, h);
		return test;
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

	public List<Entry<String, Integer>> question44() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int count = 1;
			if (map.containsKey(str)) {
				Integer val = map.get(str);
				val++;
				map.put(str, val);
			} else {
				map.put(str, count);
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

	public List<Entry<String, Integer>> question5() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object rowkey_str = c.get("rowkey_str");
			Object likct = c.get("likct");
			String str = rowkey_str.toString();
			int pa = Integer.parseInt(likct.toString());
			map.put(str, pa);
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

	public Map<Date, Integer> question6() throws ParseException {
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

	public Map<Date, Integer> question66() throws ParseException {
		Map<Date, Integer> map = new TreeMap<Date, Integer>();
		for (JSONObject c : list) {
			Object pub_time = c.get("pub_time");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(pub_time.toString());
			int count = 1;
			if (map.containsKey(date)) {
				Integer val = map.get(date);
				val++;
				map.put(date, val);
			} else {
				map.put(date, count);
			}
		}
		return map;
	}

	public List<Entry<String, User>> question7() {
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
					return 1;
				}
			}
		});
		return lists;
	}

	public UserFactory question8() {
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
		UserFactory result = new UserFactory(map);
		return result;
	}
}
