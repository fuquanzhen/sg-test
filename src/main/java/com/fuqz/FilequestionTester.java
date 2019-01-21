package com.fuqz;

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

public class FilequestionTester {
	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String pathQ4 = "D:\\java\\fuquanz\\log.csv";
		String pathQ44 = "D:\\java\\fuquanz\\fr.csv";
		String pathQ5 = "D:\\java\\fuquanz\\five.csv";
		String pathQ6 = "D:\\java\\fuquanz\\six.csv";
		String pathQ66 = "D:\\java\\fuquanz\\newsix.csv";
		String pathQ7 = "D:\\java\\fuquanz\\seven.csv";
		Filequestion f = new Filequestion(path);
		System.out.println(f.question1());
		System.out.println(f.question11());
		System.out.println(f.question2());
		System.out.println(f.question22());
		Test1 tes = f.question3();
		System.out.println("最大值:" + tes.getMax());
		System.out.println("最小值:" + tes.getMin());
		System.out.println("总和:" + tes.getSum());
		System.out.println("平均数:" + tes.getAvg());
		System.out.println("中位数:" + tes.getH());
		Test1 test = f.question33();
		System.out.println("最大值:" + test.getMax());
		System.out.println("最小值:" + test.getMin());
		System.out.println("总和:" + test.getSum());
		System.out.println("平均数:" + test.getAvg());
		System.out.println("中位数:" + test.getH());
		List<Entry<String, Integer>> listQ4 = f.question4();
		FilequestionTester.solve(pathQ4, listQ4);
		List<Entry<String, Integer>> listQ44 = f.question44();
		FilequestionTester.solve(pathQ44, listQ44);
		List<Entry<String, Integer>> listQ5 = f.question5();
		FilequestionTester.solve(pathQ5, listQ5);
		Map<Date, Integer> mapQ6 = f.question6();
		FilequestionTester.solve1(pathQ6, mapQ6);
		Map<Date, Integer> mapQ66 = f.question66();
		FilequestionTester.solve1(pathQ66, mapQ66);
		List<Entry<String, User>> listQ7 = f.question7();
		FilequestionTester.solve2(pathQ7, listQ7);
		UserFactory rel = f.question8();
		System.out.println(rel.getUser("5584922654").getUid());
		System.out.println(rel.delUser("2566469601").getUid());
		User user = new User("5797346121", 3);
		System.out.println(rel.updataUser(user).getUid());
		List<User> list11 = new ArrayList<User>();
		User user1 = new User("3885321891", 3);
		User user2 = new User("5797346121", 4);
		list11.add(user1);
		list11.add(user2);
		for (User user11 : list11) {
			System.out.println(user11.getUid());
			System.out.println(user11.getPostcount());
		}
		List<String> list7 = new ArrayList<String>();
		list7.add("6121866144");
		list7.add("6020875579");
		list7.add("2526964597");
		for (User user12 : rel.getMulUser(list7)) {
			System.out.println(user12.getUid());
			System.out.println(user12.getPostcount());
		}
	}

	public static void solve(String path, List<Entry<String, Integer>> lists) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		for (Entry<String, Integer> set : lists) {
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

	public static void solve1(String path, Map<Date, Integer> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		Set<Entry<Date, Integer>> set = map.entrySet();
		Iterator<Entry<Date, Integer>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Date, Integer> entry = (Map.Entry<Date, Integer>) it.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			str.append(format.format(entry.getKey()) + "\t" + entry.getValue()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}

	public static void solve2(String path, List<Entry<String, User>> lists) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
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
