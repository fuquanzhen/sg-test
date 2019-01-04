package com.fqz;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class QuestionNewTester {

	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String pathQ4 = "C:\\Users\\Public\\java\\log.csv";
		String pathQ5 = "C:\\Users\\Public\\java\\test.csv";
		String pathQ6 = "C:\\Users\\Public\\java\\date.csv";
		String pathQ7 = "C:\\Users\\Public\\java\\us.csv";
		QuestionNew q = new QuestionNew(path);
		System.out.println("总数量:" + q.question1());
		System.out.println("uid数量:" + q.question2());
		Newclass rel = q.question3();
		System.out.println("最大值:" + rel.getMax());
		System.out.println("最小值:" + rel.getMin());
		System.out.println("总和:" + rel.getSum());
		System.out.println("平均数:" + rel.getAvg());
		System.out.println("中位数:" + rel.getH());
		List<Entry<String, Integer>> listQ4 = q.question4();
		QuestionNewTester.solve(pathQ4, listQ4);
		List<Entry<String, Integer>> listQ5 = q.question5();
		QuestionNewTester.solve(pathQ5, listQ5);
		Map<Date, Integer> map = q.question6();
		QuestionNewTester.solve1(pathQ6, map);
		List<Entry<String, User>> listQ7 = q.question7();
		QuestionNewTester.solve2(pathQ7, listQ7);
		Userfactory uf = q.question8();
		System.out.println(uf.getUser("5584922654"));
		System.out.println(uf.delUser("5753546854"));
		User user = new User("3974492648", 12);
		System.out.println(uf.updataUser(user));
	}

	public static void solve(String path, List<Entry<String, Integer>> lists) throws IOException {
		for (Entry<String, Integer> set : lists) {
			Map<String, Integer> newmap = new HashMap<String, Integer>();
			newmap.put(set.getKey(), set.getValue());
			String line = System.getProperty("line.separator");
			StringBuffer str = new StringBuffer();
			FileWriter fw = new FileWriter(path, true);
			Set<Entry<String, Integer>> entrySet = newmap.entrySet();
			Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
				str.append(entry.getKey() + "\t" + entry.getValue()).append(line);
			}
			fw.write(str.toString());
			fw.close();
		}
	}

	public static void solve1(String path, Map<Date, Integer> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		Set<Entry<Date, Integer>> entry = map.entrySet();
		Iterator<Entry<Date, Integer>> iterator = entry.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Date, Integer> entry1 = (Map.Entry<Date, Integer>) iterator.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			str.append(format.format(entry1.getKey()) + "\t" + entry1.getValue()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solve2(String path, List<Entry<String, User>> lists) throws IOException {
		for (Entry<String, User> set : lists) {
			HashMap<String, User> newmap = new HashMap<String, User>();
			newmap.put(set.getKey(), set.getValue());
			String line = System.getProperty("line.separator");
			StringBuffer str = new StringBuffer();
			FileWriter fw = new FileWriter(path, true);
			Set<Entry<String, User>> entry = newmap.entrySet();
			Iterator<Entry<String, User>> iterator = entry.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, User> entry2 = (Map.Entry<String, User>) iterator.next();
				str.append(entry2.getKey() + "\t" + entry2.getValue().getPostcount()).append(line);
			}
			fw.write(str.toString());
			fw.close();
		}
	}
}
