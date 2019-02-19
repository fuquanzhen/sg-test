package com.set2Compare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Set2Compare {
	private String path;

	public Set2Compare(String path) {
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
		String paths = "D:\\compare\\settwo\\en_split_2 - Sheet1.tsv";
		String pathss = "D:\\compare\\settwo\\set 2 - Elaine - Sheet1.tsv";
		Set2Compare p = new Set2Compare(paths);
		Set2Compare q = new Set2Compare(pathss);
		List<Integer> listone = p.read(paths);
		List<Integer> listtwo = q.read(pathss);
		int sumone = 0;
		int sumtwo = 0;
		int sumthree = 0;
		for (int i = 0; i < listone.size(); i++) {
			if (listone.get(i) == listtwo.get(i)) {
				if (listone.get(i) == 0 && listtwo.get(i) == 0) {
					sumtwo = sumtwo + 1;
				} else {
					sumone = sumone + 1;
				}
			} else {
				sumthree = sumthree + 1;
			}
		}
		System.out.println("两者标注一致且不都标注为0：" + sumone);
		System.out.println("两者标注一致且都标注为0:" + sumtwo);
		System.out.println("两者标注不一致:" + sumthree);
	}
}
