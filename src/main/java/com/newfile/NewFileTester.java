package com.newfile;

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

public class NewFileTester {
	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String pathQ4 = "D:\\user\\file\\newfile2\\question4.csv";
		String pathQ5 = "D:\\user\\file\\newfile2\\question5.csv";
		String pathQ6 = "D:\\user\\file\\newfile2\\question6.csv";
		String pathQ7 = "D:\\user\\file\\newfile2\\question7.csv";
		NewFile nf = new NewFile(path);
		System.out.println("总数:" + nf.fileQ1());
		System.out.println("总数:" + nf.fileQ11());
		System.out.println("uid唯一数量:" + nf.fileQ2());
		System.out.println("uid唯一数量:" + nf.fileQ22());
		FileResult fr = nf.fileQ3();
		System.out.println("最大值:" + fr.getMax());
		System.out.println("最小值:" + fr.getMin());
		System.out.println("总数:" + fr.getSum());
		System.out.println("平均数:" + fr.getAvg());
		System.out.println("中位数:" + fr.getZ());
		FileResult frt = nf.fileQ33();
		System.out.println("最大值:" + frt.getMax());
		System.out.println("最小值:" + frt.getMin());
		System.out.println("总数:" + frt.getSum());
		System.out.println("平均数:" + frt.getAvg());
		System.out.println("中位数:" + frt.getZ());
		List<Entry<String, Integer>> list = nf.fileQ4();
		NewFileTester.solve(pathQ4, list);
		List<Entry<String, Integer>> list1 = nf.fileQ5();
		NewFileTester.solve(pathQ5, list1);
		Map<Date, Integer> map = nf.fileQ6();
		NewFileTester.solve1(pathQ6, map);
		List<Entry<String, User>> list2 = nf.fileQ7();
		NewFileTester.solve2(pathQ7, list2);
		UserFactory result = nf.fileQ8();
		System.out.println(result.getUser("2965685634").getUid());
		System.out.println(result.getUser("2965685634").getPostcount());
		System.out.println(result.dlUser("2090372290").getPostcount());
		User user = new User("5292709035", 52);
		System.out.println(result.updateUser(user).getPostcount());
		List<String> list3 = new ArrayList<String>();
		list3.add("2385112855");
		list3.add("5268453187");
		list3.add("2294629187");
		for (User user1 : result.getMutilUser(list3)) {
			System.out.println(user1.getUid());
			System.out.println(user1.getPostcount());
		}
		List<User> list4 = new ArrayList<User>();
		User user11 = new User("2385112851", 97);
		User user12 = new User("5268453183", 123);
		list4.add(user11);
		list4.add(user12);
		for (User user2 : list4) {
			System.out.println(user2.getUid());
			System.out.println(user2.getPostcount());
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
				str.append(entry.getKey() + "\t" + entry.getValue().getPostcount()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}
}
