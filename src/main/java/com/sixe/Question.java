package com.sixe;

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
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;

public class Question {
	private String path;
	private List<JSONObject> list;

	public Question(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream flieInputStream = new FileInputStream(path);
		InputStreamReader inputStreamReader = new InputStreamReader(flieInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public int question1() {
		return list.size();
	}

	public int question2() {
		HashSet<String> set = new HashSet<String>();
		for (JSONObject s : list) {
			Object uid = s.get("uid");
			set.add(uid.toString());
		}
		return set.size();
	}

	public NewQuestion3 question3() {
		List<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject s : list) {
			Object cmtct = s.get("cmtct");
			list1.add(Integer.parseInt(cmtct.toString()));
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
			z = (list1.get((list1.size()) / 2 - 1) + list1.get((list1.size() / 2))) / 2;
		}
		NewQuestion3 result = new NewQuestion3(sum, avg, z, Collections.max(list1), Collections.min(list1));
		return result;
	}

	public List<Entry<String, Integer>> question4() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject s : list) {
			Object uid = s.get("uid");
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
				} else
					return -1;
			}
		});
		return listss;
	}

	public List<Entry<String, Integer>> question5() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject s : list) {
			Object rowkey_str = s.get("rowkey_str");
			Object likct = s.get("likct");
			String st = rowkey_str.toString();
			int pa = Integer.parseInt(likct.toString());
			map.put(st, pa);
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
				} else
					return -1;
			}
		});
		if (listss.size() >= 10) {
			return listss.subList(0, 10);
		} else {
			return listss;
		}
	}

	public Map<Date, Integer> question6() throws ParseException {
		Map<Date, Integer> map = new TreeMap<Date, Integer>();
		for (JSONObject s : list) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Object pub_time = s.get("pub_time");
			Date parse = format.parse(pub_time.toString());
			if (map.containsKey(parse)) {
				map.put(parse, map.get(parse).intValue() + 1);
			} else {
				map.put(parse, new Integer(1));
			}
		}
		return map;
	}

	public List<Entry<String, User>> question7() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject s : list) {
			Object uid = s.get("uid");
			int postcount = 1;
			String sl = uid.toString();
			if (map.containsKey(sl)) {
				User user = map.get(sl);
				user.add();
				map.put(sl, user);
			} else {
				User user = new User(sl, postcount);
				map.put(sl, user);
			}
		}
		List<Entry<String, User>> listss = new ArrayList<Entry<String, User>>(map.entrySet());
		Collections.sort(listss, new Comparator<Map.Entry<String, User>>() {
			public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
				int q1 = o1.getValue().getPostcount();
				int q2 = o2.getValue().getPostcount();
				int p = q2 - q1;
				if (p > 0) {
					return 1;
				} else if (p == 0) {
					return 0;
				} else
					return -1;
			}
		});
		return listss;
	}

	public UserFactory question8() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject s : list) {
			Object uid = s.get("uid");
			int postcount = 1;
			String sl = uid.toString();
			if (map.containsKey(sl)) {
				User user = map.get(sl);
				user.add();
				map.put(sl, user);
			} else {
				User user = new User(sl, postcount);
				map.put(sl, user);
			}
		}
		UserFactory factory = new UserFactory(map);
		return factory;
	}

	public UserFactory question10() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject s : list) {
			Note note = new Note(s);
			int postcount = 1;
			Object uid = s.get("uid");
			String str = uid.toString();
			if (map.containsKey(str)) {
				User user = map.get(str);
				user.add(note);
			} else {
				List<Note> list1 = new ArrayList<Note>();
				list1.add(note);
				User user = new User(str, postcount, list1);
				map.put(str, user);
			}
		}
		UserFactory result = new UserFactory(map);
		return result;
	}
}