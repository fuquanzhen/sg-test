package com.friday;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewQuestionTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\xiaohongshu0107-user.txt";
		String path2 = "D:\\xiaohongshu\\file\\number2.csv";
		NewQuestion n = new NewQuestion(path);
		List<User1> list = n.question();
		NewQuestionTester.solve(path2, list);
	}

	public static void solve(String path, List<User1> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (User1 user : list) {
			str.append(user.getJson().toJSONString()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}
}
