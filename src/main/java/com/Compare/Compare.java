package com.Compare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Compare {
	private List<Integer> list;

	public Compare(String path) {
	}

	public ArrayList<Integer> read(String path) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			int parseInt = Integer.parseInt(line);
			list.add(parseInt);
		}
		return list;
	}

	public static void main(String args[]) throws IOException {
		String path = "C:\\Users\\quanh\\qingmiao.txt";
		String path2 = "C:\\Users\\quanh\\jing.txt";
		Compare q = new Compare(path);
		Compare q2 = new Compare(path2);
		ArrayList<Integer> list1 = q.read(path);
		ArrayList<Integer> list2 = q2.read(path2);
		int i = 0;
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		while (i < list1.size() && i < list2.size()) {
			if (list1.get(i) == list2.get(i) && list1.get(i) != 0 && list2.get(i) != 0) {
				sum = sum + 1;
			} else if (list1.get(i) == list2.get(i) && list1.get(i) == 0 && list2.get(i) == 0) {
				sum2 = sum2 + 1;
			} else {
				sum3 = sum3 + 1;
			}
			i++;
		}
		System.out.println(sum);
		System.out.println(sum2);
		System.out.println(sum3);
	}
}
