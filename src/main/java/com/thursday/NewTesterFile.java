package com.thursday;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewTesterFile {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\xiaohongshu0107-user.txt";
		String pathQ2 = "D:\\xhs\\java\\小红书two.csv";
		XiaohongshuApp xhs = new XiaohongshuApp(path);
		List<Userxsh> list = xhs.question();
		NewTesterFile.solve(pathQ2, list);
	}

	public static void solve(String path, List<Userxsh> list) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		for (Userxsh user : list) {
			str.append(user.getJson().toJSONString()).append(line);
		}
		fw.write(str.toString());
		fw.close();
	}
}
