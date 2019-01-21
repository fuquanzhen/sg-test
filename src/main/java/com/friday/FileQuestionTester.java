package com.friday;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileQuestionTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\xiaohongshu0107-user.txt";
		String path1 = "D:\\xiaohongshu\\file\\number1.csv";
		FileQuestion f = new FileQuestion(path);
		List<User> list = f.question();
		FileQuestionTester.solve(path1, list);
	}

	public static void solve(String path, List<User> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (User user : list) {
			str.append(user.getJson().toJSONString()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}
}
