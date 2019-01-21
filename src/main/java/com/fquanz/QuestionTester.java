package com.fquanz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuestionTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\data.txt";
		Question q = new Question(path);
		System.out.println(q.question1());
		System.out.println(q.newquestion1());
		System.out.println(q.question2());
		System.out.println(q.newquestion2());
		Resultq3 rel = q.question3();
		System.out.println("最大值:" + rel.getMax());
		System.out.println("最小值:" + rel.getMin());
		System.out.println("总数:" + rel.getSum());
		System.out.println("平均数:" + rel.getAvg());
		System.out.println("中位数:" + rel.getZ());
		Resultq3 relt = q.newquestion3();
		System.out.println("最大值:" + relt.getMax());
		System.out.println("最小值:" + relt.getMin());
		System.out.println("总数:" + relt.getSum());
		System.out.println("平均数:" + relt.getAvg());
		System.out.println("中位数:" + relt.getZ());
	}

	public static void solve(String path, List<Entry<String, Integer>> listss) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, true);
		for (Entry<String, Integer> set : listss) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(set.getKey(), set.getValue());
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			entrySet.iterator();
		}
	}
}