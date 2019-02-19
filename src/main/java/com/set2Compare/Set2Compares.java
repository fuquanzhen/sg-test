package com.set2Compare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Set2Compares {
	private String path;

	public Set2Compares(String path) {
	}

	public List<String> read(String path) throws IOException {
		List<String> list = new ArrayList<String>();
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
		String paths = "D:\\compare\\settwo\\en_split_2 - Sheet1.tsv";
		String pathss = "D:\\compare\\settwo\\set 2 - Elaine - Sheet1.tsv";
		Set2Compares q1 = new Set2Compares(paths);
		Set2Compares q2 = new Set2Compares(pathss);
		List<String> lists = q1.read(paths);
		List<String> listss = q2.read(pathss);
		Set2File solveone = q1.solve(lists);
		Set2File solvetwo = q2.solve(listss);
		List<Integer> listone = solveone.getLists();
		List<String> listones = solveone.getListss();
		List<Integer> listtwo = solvetwo.getLists();
		List<String> listtwos = solvetwo.getListss();
		for (int i = 0; i < lists.size(); i++) {
			if (listone.get(i) != listtwo.get(i) || !listones.get(i).equals(listtwos.get(i))) {
				System.out.println(lists.get(i));
				System.out.println(listss.get(i));
			}
		}
	}

	public Set2File solve(List<String> list) {
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
		Set2File sf = new Set2File(lists, listss);
		return sf;
	}
}
