package com.excelcompare;

import java.util.ArrayList;

public class NewFile {
	private ArrayList<Integer> lists;
	private ArrayList<String> listss;

	public NewFile(ArrayList<Integer> lists, ArrayList<String> listss) {
		this.lists = lists;
		this.listss = listss;
	}

	public ArrayList<Integer> getLists() {
		return lists;
	}

	public ArrayList<String> getListss() {
		return listss;
	}

}
