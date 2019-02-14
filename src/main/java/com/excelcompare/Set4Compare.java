package com.excelcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Set4Compare {
	private String path;

	public Set4Compare(String path) {
	}

	public List<Integer> read(String path) throws IOException {
		List<Integer> list = new ArrayList<Integer>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] split = line.split("\t");
			if (split[0] != null && split[0].length() != 0) {
				int parseInt = Integer.parseInt(split[0]);
				list.add(parseInt);
			}
		}
		return list;
	}

	public static void main(String args[]) throws IOException {
		String paths = "D:\\jingling\\en_split_4 - Sheet1.tsv";
		String pathss = "D:\\jingling\\set 4 - jingling - Sheet1.tsv";
		Set4Compare q1 = new Set4Compare(paths);
		Set4Compare q2 = new Set4Compare(pathss);
		List<Integer> lists = q1.read(paths);
		List<Integer> listss = q2.read(pathss);
		int sumone = 0;
		int sumtwo = 0;
		int sumthree = 0;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) == listss.get(i)) {
				if (lists.get(i) == 0 && listss.get(i) == 0) {
					sumtwo = sumtwo + 1;
				} else {
					sumone = sumone + 1;
				}
			} else {
				sumthree = sumthree + 1;
			}
		}
		System.out.println("两者标注一致的为：" + sumone);
		System.out.println("两者标注一致且都标注为0的为：" + sumtwo);
		System.out.println("两者标注不一致的为：" + sumthree);
	}
}
