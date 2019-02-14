package com.excelcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Compare {

	public Compare(String path) {
	}

	public ArrayList<Integer> read(String path) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
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
		String path1 = "D:\\compare\\en_split_1 - Sheet1.tsv";
		String path2 = "D:\\compare\\set 1 - jingling - Sheet1.tsv";
		Compare q1 = new Compare(path1);
		Compare q2 = new Compare(path2);
		ArrayList<Integer> list1 = q1.read(path1);
		ArrayList<Integer> list2 = q2.read(path2);
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) == list2.get(i)) {
				if (list1.get(i) == 0 && list2.get(i) == 0) {
					sum2 = sum2 + 1;
				} else {
					sum1 = sum1 + 1;
				}
			} else {
				sum3 = sum3 + 1;
			}
		}
		System.out.println("两者标注一致的为:" + sum1);
		System.out.println("两者标注一致且为0的为:" + sum2);
		System.out.println("两者标注不一致的为:" + sum3);
	}
}
