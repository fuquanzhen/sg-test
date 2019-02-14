package com.excelcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Different {
	private ArrayList<String> list;

	public Different(String path) {
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
		Different q1 = new Different(path1);
		Different q2 = new Different(path2);
		ArrayList<String> list1 = q1.read(path1);
		ArrayList<String> list2 = q2.read(path2);
		NewFile solvequestion = q1.solvequestion(list1);
		NewFile solvequestion2 = q2.solvequestion(list2);
		ArrayList<Integer> listso = solvequestion.getLists();
		ArrayList<Integer> listst = solvequestion2.getLists();
		ArrayList<String> listsso = solvequestion.getListss();
		ArrayList<String> listsst = solvequestion2.getListss();
		for (int i = 0; i < list1.size(); i++) {
			if (listso.get(i) != listst.get(i) || !listsso.get(i).equals(listsst.get(i))) {
				System.out.println(list1.get(i));
				System.out.println(list2.get(i));
			}
		}
	}

	public NewFile solvequestion(ArrayList<String> list) {
		ArrayList<Integer> lists = new ArrayList<Integer>();
		ArrayList<String> listss = new ArrayList<String>();
		for (String c : list) {
			String[] split = c.split("\t");
			if (split[0] != null && split[0].length() != 0) {
				int parseInt = Integer.parseInt(split[0]);
				lists.add(parseInt);
			}
			if (split[6] != null && split[6].length() != 0) {
				String str = split[6].toString();
				listss.add(str);
			}
		}
		NewFile nf = new NewFile(lists, listss);
		return nf;
	}
}