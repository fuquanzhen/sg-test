package com.newset2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Settwo {
	private String path;

	public Settwo() {
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
				int parseInt = Integer.parseInt(split[0].toString());
				list.add(parseInt);
			}
		}
		return list;
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\compare\\new\\en_split_2 - Sheet1.tsv";
		String pathtwo = "D:\\compare\\new\\set 2 - Elaine-2 - Sheet1.tsv";
		Settwo t = new Settwo();
		List<Integer> lists = t.read(path);
		List<Integer> listss = t.read(pathtwo);
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
		System.out.println("两者一致且不都等于0的为：" + sumone);
		System.out.println("两者一致且都等于0的为：" + sumtwo);
		System.out.println("两者不一致的为：" + sumthree);
	}
}
