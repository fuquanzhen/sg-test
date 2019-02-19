package com.set2Compare;

import java.util.List;

public class Set2File {
	private List<Integer> lists;
	private List<String> listss;

	public Set2File(List<Integer> lists, List<String> listss) {
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
