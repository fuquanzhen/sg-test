package com.fqzhen;

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

public class SolveQuestionTester {
	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		String pathQ4 = "D:\\user\\file\\newfile\\question4.csv";
		String pathQ5 = "D:\\user\\file\\newfile\\question5.csv";
		String pathQ6 = "D:\\user\\file\\newfile\\question6.csv";
		String pathQ7 = "D:\\user\\file\\newfile\\question7.csv";
		SolveQuestion sq = new SolveQuestion(path);
		System.out.println("总数量:" + sq.numberone());
		System.out.println("总数量:" + sq.newnumberone());
		System.out.println("uid数量:" + sq.numbertwo());
		System.out.println("uid数量:" + sq.newnumbertwo());
		System.out.println("uid数量:" + sq.newtwonumber());
		Result res = sq.numberthree();
		System.out.println("最大值:" + res.getMax());
		System.out.println("最小值:" + res.getMin());
		System.out.println("总和:" + res.getSum());
		System.out.println("平均数:" + res.getAvg());
		System.out.println("中位数:" + res.getH());
		Result rels = sq.newnumberthree();
		System.out.println("最大值:" + rels.getMax());
		System.out.println("最小值:" + rels.getMin());
		System.out.println("总和:" + rels.getSum());
		System.out.println("平均数:" + rels.getAvg());
		System.out.println("中位数:" + rels.getH());
		List<Entry<String, Integer>> listQ4 = sq.numberfour();
		SolveQuestionTester.solve(pathQ4, listQ4);
		List<Entry<String, Integer>> listQ5 = sq.numberfive();
		SolveQuestionTester.solve(pathQ5, listQ5);
		Map<Date, Integer> mapQ6 = sq.numbersix();
		SolveQuestionTester.solvetwo(pathQ6, mapQ6);
		List<Entry<String, User>> listQ7 = sq.numberseven();
		SolveQuestionTester.solvethree(pathQ7, listQ7);
		UserFactory ufy = sq.numbereight();
		System.out.println(ufy.getUser("2910535662").getPostcount());
		System.out.println(ufy.dlUser("1228004512").getPostcount());
		User user = new User("5796185388", 3);
		System.out.println(ufy.updataUser(user).getPostcount());
		List<String> list2 = new ArrayList<String>();
		list2.add("5620436584");
		list2.add("2245380925");
		list2.add("2840962635");
		List<User> list1 = new ArrayList<User>();
		User user1 = new User("2090372290", 22);
		User user2 = new User("2134290734", 2);
		User user3 = new User("3212405392", 2);
		list1.add(user1);
		list1.add(user2);
		list1.add(user3);
		for (User user11 : ufy.getMutilUser(list2)) {
			System.out.println(user11.getUid());
			System.out.println(user11.getPostcount());
		}
		for (User user12 : list1) {
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

	public static void solvetwo(String path, Map<Date, Integer> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
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

	public static void solvethree(String path, List<Entry<String, User>> listss) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		for (Entry<String, User> set : listss) {
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
