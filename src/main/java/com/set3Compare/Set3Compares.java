package com.set3Compare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Set3Compares {
	private String path;

	public Set3Compares(String path) {
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
		String paths = "D:\\jingling\\en_split_3 - Sheet1.tsv";
		String pathss = "D:\\jingling\\set 3 - Razib-13 Feb,2019 - Sheet1.tsv";
		String pathsss = "D:\\jingling\\haha.csv";
		Set3Compares p = new Set3Compares(paths);
		Set3Compares q = new Set3Compares(pathss);
		List<String> lists = p.read(paths);
		List<String> listss = q.read(pathss);
		Set3File solveone = p.solve(lists);
		Set3File solvetwo = q.solve(listss);
		List<Integer> listone = solveone.getLists();
		List<String> listones = solveone.getListss();
		List<Integer> listtwo = solvetwo.getLists();
		List<String> listtwos = solvetwo.getListss();
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(pathsss);
		for (int i = 0; i < lists.size(); i++) {
			if (listone.get(i) != listtwo.get(i) || !listones.get(i).equals(listtwos.get(i))) {
				str.append(listone.get(i) + "\t" + listss.get(i) + "\n");
			}
		}
		fw.write("我们标注" + "\t" + "freelancer标注" + "\t" + "Text" + "\t" + "Target" + "\t" + "1st Layer " + "\t"
				+ "2nd Layer" + "\t" + "Polarity" + "\t" + "Matched Word" + "\n" + str.toString());
		fw.close();
	}

	public Set3File solve(List<String> list) {
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
		Set3File sf = new Set3File(lists, listss);
		return sf;
	}
}