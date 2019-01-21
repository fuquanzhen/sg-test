package com.xiaohongshu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FileTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\xiaohongshu0107-user.txt";
		String pathQ3 = "D:\\newfile\\file\\question3.csv";
		Xiaohongshu xhs = new Xiaohongshu(path);
		System.out.println("总数量:" + xhs.question1());
		System.out.println("stact的数量:" + xhs.question2());
		List<Entry<String, Integer>> list = xhs.question3();
		FileTester.solve(pathQ3, list);
	}

	public static void solve(String path, List<Entry<String, Integer>> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Entry<String, Integer> set : list) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(set.getKey(), set.getValue());
			Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
			Iterator<Entry<String, Integer>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
				str.append(entry.getKey() + "\t" + entry.getValue()).append(line);
			}
		}
		fw.write(str.toString());
		fw.close();
	}
}
