package com.newset2;

import java.util.List;

public class NewFile {
	private List<Integer> listone;
	private List<String> listtwo;

	public NewFile(List<Integer> listone, List<String> listtwo) {
		this.listone = listone;
		this.listtwo = listtwo;
	}

	public List<Integer> getListone() {
		return listone;
	}

	public List<String> getListtwo() {
		return listtwo;
	}
}
