package com.fuquanzhne;

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
		String pathQ4 = "D:\\Question\\java\\问题4.csv";
		String pathQ5 = "D:\\Question\\java\\问题5.csv";
		String pathQ6 = "D:\\Question\\java\\问题6.csv";
		String pathQ7 = "D:\\Question\\java\\问题7.csv";
		Question q = new Question(path);
		System.out.println("总数:" + q.question1());
		System.out.println("总数:" + q.newquestion1());
		System.out.println("uid的唯一数量:" + q.question2());
		System.out.println("uid的唯一数量:" + q.newquestion2());
		Successful rel = q.question3();
		System.out.println("最大值:" + rel.getMax());
		System.out.println("最小值:" + rel.getMin());
		System.out.println("总和:" + rel.getSum());
		System.out.println("平均数:" + rel.getAvg());
		System.out.println("中位数:" + rel.getZ());
		Successful rest = q.newquestion3();
		System.out.println("最大者:" + rest.getMax());
		System.out.println("最小值:" + rest.getMin());
		System.out.println("总和:" + rest.getSum());
		System.out.println("平均数:" + rest.getAvg());
		System.out.println("中位数:" + rest.getZ());
		List<Entry<String, Integer>> list = q.question4();
		QuestionTester.solve(pathQ4, list);
		List<Entry<String, Integer>> list1 = q.question5();
		QuestionTester.solve(pathQ5, list1);
		Map<Date, Integer> map = q.question6();
		QuestionTester.solve1(pathQ6, map);
		List<Entry<String, User>> list2 = q.question7();
		QuestionTester.solve2(pathQ7, list2);
		UserFactory sqr = q.question8();
		System.out.println(sqr.getUser("2965685634").getPostcount());
		System.out.println(sqr.dlUser("2090372290").getUid());
		User user1 = new User("1006828755", 2);
		System.out.println(sqr.updateUser(user1).getPostcount());
		List<String> list3 = new ArrayList<String>();
		list3.add("5279462067");
		list3.add("5292375863");
		list3.add("5310839379");
		for (User user : sqr.getMutilUser(list3)) {
			System.out.println(user.getUid());
			System.out.println(user.getPostcount());
		}
		List<User> list4 = new ArrayList<User>();
		User user2 = new User("5251171234", 222);
		User user3 = new User("1234567899", 123);
		User user4 = new User("9876543211", 321);
		list4.add(user2);
		list4.add(user3);
		list4.add(user4);
		for (User user : list4) {
			System.out.println(user.getUid());
			System.out.println(user.getPostcount());
		}
	}

	public static void solve(String path, List<Entry<String, Integer>> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> set : list) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(set.getKey(), set.getValue());
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			Iterator<Entry<String, Integer>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
				str.append(entry.getKey() + "\t" + entry.getValue()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solve1(String path, Map<Date, Integer> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		Set<Entry<Date, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Date, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<Date, Integer> entry = (Map.Entry<Date, Integer>) it.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			str.append(format.format(entry.getKey()) + "\t" + entry.getValue()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solve2(String path, List<Entry<String, User>> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, User> set : list) {
			Map<String, User> map = new HashMap<String, User>();
			map.put(set.getKey(), set.getValue());
			Set<Entry<String, User>> entrySet = map.entrySet();
			Iterator<Entry<String, User>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, User> entry = (Map.Entry<String, User>) it.next();
				str.append(entry.getKey() + "\t" + set.getValue().getUid()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}
}
