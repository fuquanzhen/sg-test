package com.newfil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class NewQuestionTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\xiaohongshu0107-user.txt";
		String pathQ2 = "D:\\xiaohongshu\\java\\question2.csv";
		NewQuestion q = new NewQuestion(path);
		List<User> list = q.question1();
		NewQuestionTester.solve(pathQ2, list);
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
