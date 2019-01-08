package com.sixe;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuestionTester {
	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String pathQ4 = "C:\\Users\\quanh\\log.csv";
		String pathQ5 = "C:\\Users\\quanh\\test.csv";
		String pathQ6 = "C:\\Users\\quanh\\successful.csv";
		String pathQ7 = "C:\\Users\\quanh\\succ.csv";
		Question q = new Question(path);
		System.out.println("总数量:" + q.question1());
		System.out.println("uid唯一数量:" + q.question2());
		NewQuestion3 rel = q.question3();
		System.out.println("最大值:" + rel.getMax());
		System.out.println("最小值:" + rel.getMin());
		System.out.println("总和:" + rel.getSum());
		System.out.println("平均数:" + rel.getAvg());
		System.out.println("中位数:" + rel.getZ());
		List<Entry<String, Integer>> listQ4 = q.question4();
		QuestionTester.solve(pathQ4, listQ4);
		List<Entry<String, Integer>> listQ5 = q.question5();
		QuestionTester.solve(pathQ5, listQ5);
		Map<Date, Integer> map = q.question6();
		QuestionTester.solve1(pathQ6, map);
		List<Entry<String, User>> listQ7 = q.question7();
		QuestionTester.solve2(pathQ7, listQ7);
		UserFactory factory = q.question8();
		System.out.println(factory.getUser("5584922654").getPostcount());
		System.out.println(factory.delUser("2724828481").getPostcount());
		User user = new User("3974492648", 12);
		System.out.println(factory.updataUser(user).getPostcount());
		List<String> list1 = new ArrayList<String>();
		list1.add("6121866144");
		list1.add("6020875579");
		list1.add("2526964597");
		for (User user1 : factory.getMultiUser(list1)) {
			System.out.println(user1.getUid());
		}
		List<User> list2 = new ArrayList<User>();
		User user1 = new User("5554847863", 2);
		User user2 = new User("1802938917", 3);
		User user3 = new User("6008362110", 1);
		list2.add(user1);
		list2.add(user2);
		list2.add(user3);
		for (User user11 : list2) {
			System.out.println(user11.getUid());
			System.out.println(user11.getPostcount());
		}
	}

	public static void solve(String path, List<Entry<String, Integer>> listss) throws IOException {
		for (Entry<String, Integer> set : listss) {
			HashMap<String, Integer> newmap = new HashMap<String, Integer>();
			newmap.put(set.getKey(), set.getValue());
			String line = System.getProperty("line.separator");
			StringBuffer str = new StringBuffer();
			FileWriter fw = new FileWriter(path, true);
			Set<Entry<String, Integer>> entrySet = newmap.entrySet();
			Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
				str.append(entry.getKey() + " \t " + entry.getValue()).append(line);
			}
			fw.write(str.toString());
			fw.close();
		}
	}

	public static void solve1(String path, Map<Date, Integer> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		Set<Entry<Date, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Date, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Date, Integer> entry = (Map.Entry<Date, Integer>) iterator.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			str.append(format.format(entry.getKey()) + "\t" + entry.getValue()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solve2(String path, List<Entry<String, User>> listss) throws IOException {
		for (Entry<String, User> set : listss) {
			HashMap<String, User> newmap = new HashMap<String, User>();
			newmap.put(set.getKey(), set.getValue());
			String line = System.getProperty("line.separator");
			StringBuffer str = new StringBuffer();
			FileWriter fw = new FileWriter(path, true);
			Set<Entry<String, User>> entrySet = newmap.entrySet();
			Iterator<Entry<String, User>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, User> entry = (Map.Entry<String, User>) iterator.next();
				str.append(entry.getKey() + "\t" + entry.getValue().getPostcount()).append(line);
			}
			fw.write(str.toString());
			fw.close();
		}
	}
}
