package com.excelcompare;

import java.util.List;

public class Set4File {
	private List<Integer> lists;
	private List<String> listss;

	public Set4File(List<Integer> lists, List<String> listss) {
		this.lists = lists;
		this.listss = listss;
	}

	public List<Integer> getLists() {
		return lists;
	}

	public List<String> getListss() {
		return listss;
	}
}
