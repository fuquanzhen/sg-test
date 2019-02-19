package com.fquzhen;

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
		String pathQ4 = "D:\\user\\file\\newfile1\\question4.csv";
		String pathQ5 = "D:\\user\\file\\newfile1\\question5.csv";
		String pathQ6 = "D:\\user\\file\\newfile1\\question6.csv";
		String pathQ7 = "D:\\user\\file\\newfile1\\question7.csv";
		Question q = new Question(path);
		System.out.println("总数量:" + q.questionone());
		System.out.println("总数量:" + q.newquestionone());
		System.out.println("uid的唯一数量:" + q.questiontwo());
		System.out.println("uid的唯一数量:" + q.newquestiontwo());
		System.out.println("uid的唯一数量:" + q.newquestiontwonext());
		ResultTester rel = q.questionthree();
		System.out.println("最大值:" + rel.getMax());
		System.out.println("最小值:" + rel.getMin());
		System.out.println("总和:" + rel.getSum());
		System.out.println("平均数:" + rel.getAvg());
		System.out.println("中位数:" + rel.getZ());
		ResultTester relt = q.questionthree();
		System.out.println("最大值:" + relt.getMax());
		System.out.println("最小值:" + relt.getMin());
		System.out.println("总和:" + relt.getSum());
		System.out.println("平均数:" + relt.getAvg());
		System.out.println("中位数:" + relt.getZ());
		List<Entry<String, Integer>> list1 = q.questionfour();
		QuestionTester.solve(pathQ4, list1);
		List<Entry<String, Integer>> list2 = q.questionfive();
		QuestionTester.solve(pathQ5, list2);
		Map<Date, Integer> map = q.questionsix();
		QuestionTester.solveone(pathQ6, map);
		List<Entry<String, User>> list3 = q.questionseven();
		QuestionTester.solvetwo(pathQ7, list3);
		UserFactory uf = q.questioneight();
		System.out.println(uf.getUser("2294629187").getPostcount());
		System.out.println(uf.dlUser("5292375863").getUid());
		User user1 = new User("2090372290", 10);
		System.out.println(uf.updateUser(user1).getPostcount());
		List<String> list4 = new ArrayList<String>();
		list4.add("5967496511");
		list4.add("3520264123");
		list4.add("5267942045");
		for (User user : uf.getMutilUser(list4)) {
			System.out.println(user.getPostcount());
			System.out.println(user.getUid());
		}
		User user11 = new User("2965685634", 10);
		User user12 = new User("5279462067", 7);
		User user13 = new User("5310839379", 3);
		List<User> list5 = new ArrayList<User>();
		list5.add(user11);
		list5.add(user12);
		list5.add(user13);
		for (User user : list5) {
			System.out.println(user.getPostcount());
			System.out.println(user.getUid());
		}
	}

	public static void solve(String path, List<Entry<String, Integer>> listss) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> set : listss) {
			Map<String, Integer> newmap = new HashMap<String, Integer>();
			newmap.put(set.getKey(), set.getValue());
			Set<Entry<String, Integer>> entrySet = newmap.entrySet();
			Iterator<Entry<String, Integer>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
				str.append(entry.getKey() + "\t" + entry.getValue()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solveone(String path, Map<Date, Integer> map) throws IOException {
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

	public static void solvetwo(String path, List<Entry<String, User>> lists) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, User> set : lists) {
			Map<String, User> newmap = new HashMap<String, User>();
			newmap.put(set.getKey(), set.getValue());
			Set<Entry<String, User>> entrySet = newmap.entrySet();
			Iterator<Entry<String, User>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, User> entry = (Map.Entry<String, User>) it.next();
				str.append(entry.getKey() + "\t" + entry.getValue().getPostcount()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}
}