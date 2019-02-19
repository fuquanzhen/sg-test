package com.kxbhj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
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

	public int questionone() {
		return list.size();
	}

	public int questiontwo() {
		Set<String> set = new HashSet<String>();
		for (JSONObject s : list) {
			Object uid = s.get("uid");
			String str = uid.toString();
			set.add(str);
		}
		return set.size();
	}

	public Help questionthree() {
		List<Integer> lists = new ArrayList<Integer>();
		for (JSONObject s : list) {
			Object cmtct = s.get("cmtct");
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
		if ((lists.size() % 2) != 0) {
			zws = lists.get((lists.size() - 1) / 2);
		}
		if (lists.size() % 2 == 0) {
			zws = (lists.get(lists.size() / 2 - 1) + lists.get(lists.size() / 2)) / 2;
		}
		Help h = new Help(Collections.max(lists), Collections.min(lists), sum, avg, zws);
		return h;
	}

	public List<Entry<String, Integer>> questionfour() {
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

	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\data.txt";
		String paths = "D:\\sqr\\sqr\\haha.csv";
		Question q = new Question(path);
		System.out.println(q.questionone());
		System.out.println(q.questiontwo());
		Help h = q.questionthree();
		System.out.println("cmtct字段的最大值为：" + h.getMax());
		System.out.println("cmtct字段的最小值为：" + h.getMin());
		System.out.println("cmtct字段的总和为：" + h.getSum());
		System.out.println("cmtct字段的平均数为：" + h.getAvg());
		System.out.println("cmtct字段的中位数为：" + h.getZws());
		List<Entry<String, Integer>> lists = q.questionfour();
		Question.write(paths, lists);
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
}
