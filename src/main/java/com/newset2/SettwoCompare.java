package com.newset2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SettwoCompare {
	private String path;

	public SettwoCompare() {
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
		String path = "D:\\compare\\new\\en_split_2 - Sheet1.tsv";
		String pathtwo = "D:\\compare\\new\\set 2 - Elaine-2 - Sheet1.tsv";
		SettwoCompare s = new SettwoCompare();
		List<String> lists = s.read(path);
		List<String> listss = s.read(pathtwo);
		NewFile solveone = s.solve(lists);
		List<Integer> listone = solveone.getListone();
		List<String> listones = solveone.getListtwo();
		NewFile solvetwo = s.solve(listss);
		List<Integer> listtwo = solvetwo.getListone();
		List<String> listtwos = solvetwo.getListtwo();
		for (int i = 0; i < lists.size(); i++) {
			if (listone.get(i) != listtwo.get(i) || !listones.get(i).equals(listtwos.get(i))) {
				System.out.println(lists.get(i));
				System.out.println(listss.get(i));
			}
		}
	}

	public NewFile solve(List<String> list) {
		List<Integer> listone = new ArrayList<Integer>();
		List<String> listtwo = new ArrayList<String>();
		for (String c : list) {
			String[] split = c.split("\t");
			if (split[0] != null && split[0].length() != 0) {
				int parseInt = Integer.parseInt(split[0].toString());
				listone.add(parseInt);
			}
			if (split[5] != null && split[5].length() != 0) {
				String str = split[5].toString();
				listtwo.add(str);
			}
		}
		NewFile nf = new NewFile(listone, listtwo);
		return nf;
	}
}
