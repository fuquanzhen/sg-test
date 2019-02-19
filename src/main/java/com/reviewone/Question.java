package com.reviewone;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
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

	public int questionone() {
		return list.size();
	}

	public int questiontwo() {
		Set<String> set = new HashSet<String>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			set.add(str);
		}
		return set.size();
	}

	public NewFile questionthree() {
		List<Integer> lists = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			int parseInt = Integer.parseInt(cmtct.toString());
			lists.add(parseInt);
		}
		float sum = 0;
		float avg = 0;
		float zws = 0;
		for (int i = 0; i < lists.size(); i++) {
			sum = lists.get(i) + sum;
		}
		avg = sum / lists.size();
		if (lists.size() % 2 == 0) {
			zws = (lists.get(lists.size() / 2) + lists.get(lists.size() / 2 - 1)) / 2;
		} else {
			zws = lists.get((lists.size() - 1) / 2);
		}
		NewFile nf = new NewFile(Collections.max(lists), Collections.min(lists), sum, avg, zws);
		return nf;
	}

	public NewFile questionnewthree() {
		List<Integer> lists = new ArrayList<Integer>();
		for (JSONObject c : list) {
			Object cmtct = c.get("cmtct");
			int parseInt = Integer.parseInt(cmtct.toString());
			lists.add(parseInt);
		}
		float sum = 0;
		float avg = 0;
		float zws = 0;
		int i = 0;
		while (i < lists.size()) {
			sum = lists.get(i) + sum;
			i++;
		}
		avg = sum / lists.size();
		if (lists.size() % 2 == 0) {
			zws = (lists.get(lists.size() / 2) + lists.get(lists.size() / 2 - 1)) / 2;
		} else {
			zws = lists.get((lists.size() - 1) / 2);
		}
		NewFile nf = new NewFile(Collections.max(lists), Collections.min(lists), sum, avg, zws);
		return nf;
	}

	public List<Entry<String, Integer>> questionfour() {
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

	public List<Entry<String, Integer>> questionnewfour() {
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
				int p1 = o1.getValue();
				int p2 = o2.getValue();
				int p = p2 - p1;
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

	public List<Entry<String, Integer>> questionfive() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (JSONObject c : list) {
			Object rowkey_str = c.get("rowkey_str");
			String str = rowkey_str.toString();
			Object likct = c.get("likct");
			int parseInt = Integer.parseInt(likct.toString());
			map.put(str, parseInt);
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
		if (listss.size() > 10) {
			return listss.subList(0, 10);
		} else {
			return listss;
		}
	}

	public Map<Date, Integer> questionsix() throws ParseException {
		Map<Date, Integer> map = new TreeMap<Date, Integer>();
		for (JSONObject c : list) {
			Object pub_time = c.get("pub_time");
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
			Date date = format.parse(pub_time.toString());
			if (map.containsKey(date)) {
				map.put(date, map.get(date).intValue() + 1);
			} else {
				map.put(date, new Integer(1));
			}
		}
		return map;
	}

	public List<Entry<String, User>> questionseven() {
		Map<String, User> map = new HashMap<String, User>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int count = 1;
			if (map.containsKey(str)) {
				User user = map.get(str);
				user.add();
				map.put(str, user);
			} else {
				User user = new User(str, count);
				map.put(str, user);
			}
		}
		List<Entry<String, User>> lists = new ArrayList<Entry<String, User>>(map.entrySet());
		Collections.sort(lists, new Comparator<Map.Entry<String, User>>() {
			public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
				int q1 = o1.getValue().getCount();
				int q2 = o2.getValue().getCount();
				int p = q2 - q1;
				if (p > 0) {
					return -1;
				} else if (p == 0) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		return lists;
	}
	public void questioneight() {
		Map<String,User> map=new HashMap<String,User>();
		for(JSONObject c:list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int count=0;
			if(map.containsKey(str)) {
				User user=map.get(str);
				user.add();
				map.put(str, user);
			}
			else {
				User user=new User(str,count);
				map.put(str, user);
			}
		}
	}

	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String paths = "C:\\task_interview\\task\\awds\\cfs.csv";
		String pathss = "C:\\task_interview\\task\\awds\\rcfex.csv";
		String pathsss = "C:\\task_interview\\task\\awds\\csfj.csv";
		String pathq = "C:\\task_interview\\task\\awds\\time.csv";
		String pathq7 = "C:\\task_interview\\task\\awds\\rsfj.csv";
		Question q = new Question(path);
		System.out.println("文件总数量：" + q.questionone());
		System.out.println("唯一的uid总数量：" + q.questiontwo());
		NewFile h = q.questionthree();
		System.out.println("cmtct字段最大值：" + h.getMax());
		System.out.println("cmtct字段最小值：" + h.getMin());
		System.out.println("cmtct字段总和：" + h.getSum());
		System.out.println("cmtct字段平均数：" + h.getAvg());
		System.out.println("cmtct字段中位数：" + h.getZws());
		NewFile hh = q.questionnewthree();
		System.out.println("cmtct字段的最大值：" + hh.getMax());
		System.out.println("cmtct字段的最小值：" + hh.getMin());
		System.out.println("cmtct字段的总和：" + hh.getSum());
		System.out.println("cmtct字段的平均数：" + hh.getAvg());
		System.out.println("cmtct字段的中位数：" + hh.getZws());
		List<Entry<String, Integer>> lists = q.questionfour();
		Question.write(paths, lists);
		List<Entry<String, Integer>> listss = q.questionnewfour();
		Question.write(pathss, listss);
		List<Entry<String, Integer>> listsss = q.questionfive();
		Question.write(pathsss, listsss);
		Map<Date, Integer> map = q.questionsix();
		Question.writetwo(pathq, map);
		List<Entry<String, User>> listq7 = q.questionseven();
		Question.writethree(pathq7, listq7);
	}

	public static void write(String path, List<Entry<String, Integer>> lists) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> c : lists) {
			str.append(c.getKey() + "\t" + c.getValue() + "\n");
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void writetwo(String path, Map<Date, Integer> map) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path);
		for (Map.Entry<Date, Integer> c : map.entrySet()) {
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
			str.append(format.format(c.getKey()) + "\t" + c.getValue() + "\n");
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void writethree(String path, List<Entry<String, User>> lists) throws IOException {
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path);
		for (Map.Entry<String, User> c : lists) {
			str.append(c.getKey() + "\t" + c.getValue().getCount() + "\n");
		}
		fw.write(str.toString());
		fw.close();
	}
}
