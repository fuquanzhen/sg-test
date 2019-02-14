package com.set3Compare;

import java.util.List;

public class Set3File {
	private List<Integer> lists;
	private List<String> listss;

	public Set3File(List<Integer> lists, List<String> listss) {
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
