package com.excelcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Set4Compares {
	private String path;
	private List<String> list;

	public Set4Compares(String path) {
	}

	public List<String> read(String path) throws IOException {
		this.list = new ArrayList<String>();
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
		String paths = "D:\\jingling\\en_split_4 - Sheet1.tsv";
		String pathss = "D:\\jingling\\set 4 - jingling - Sheet1.tsv";
		Set4Compares q1 = new Set4Compares(paths);
		Set4Compares q2 = new Set4Compares(pathss);
		List<String> lists = q1.read(paths);
		List<String> listss = q2.read(pathss);
		Set4File solve = q1.solve(lists);
		Set4File solves = q2.solve(listss);
		List<Integer> listone = solve.getLists();
		List<String> listones = solve.getListss();
		List<Integer> listtwo = solves.getLists();
		List<String> listtwos = solves.getListss();
		for (int i = 0; i < lists.size(); i++) {
			if (listone.get(i) != listtwo.get(i) || !listones.get(i).equals(listtwos.get(i))) {
				System.out.println(lists.get(i));
				System.out.println(listss.get(i));
			}
		}
	}

	public Set4File solve(List<String> list) {
		List<Integer> lists = new ArrayList<Integer>();
		List<String> listss = new ArrayList<String>();
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
		Set4File sf = new Set4File(lists, listss);
		return sf;
	}
}
