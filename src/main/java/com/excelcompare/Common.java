package com.excelcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Common {
	public Common(String path) {
	}

	public ArrayList<String> read(String path) throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] split = line.split("\t");
			if (split[0] != null && split[0].length() != 0) {
				list.add(line);
			}
		}
		return list;
	}

	public static void main(String args[]) throws IOException {
		String path1 = "D:\\compare\\en_split_1 - Sheet1.tsv";
		String path2 = "D:\\compare\\set 1 - jingling - Sheet1.tsv";
		Common q1 = new Common(path1);
		Common q2 = new Common(path2);
		ArrayList<String> list1 = q1.read(path1);
		ArrayList<String> list2 = q2.read(path2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		ArrayList<String> list5 = new ArrayList<String>();
		ArrayList<String> list6 = new ArrayList<String>();
		for (String s : list1) {
			String[] split1 = s.split("\t");
			int parseInt1 = Integer.parseInt(split1[0]);
			String str1 = split1[6].toString();
			list3.add(parseInt1);
			list5.add(str1);
		}
		for (String c : list2) {
			String[] split2 = c.split("\t");
			int parseInt2 = Integer.parseInt(split2[0]);
			String str2 = split2[6].toString();
			list4.add(parseInt2);
			list6.add(str2);
		}
		for (int i = 0; i < list1.size(); i++) {
			if (list3.get(i) != list4.get(i) || !list5.get(i).equals(list6.get(i))) {
				System.out.println(list1.get(i));
				System.out.println(list2.get(i));
			}
		}
	}
}