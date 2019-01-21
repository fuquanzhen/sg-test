package com.sixe;

public class Userthree {
	private String uid;
	private int postcount;

	public Userthree(String uid, int postcount) {
		this.uid = uid;
		this.postcount = postcount;
	}

	public String getUid() {
		return uid;
	}

	public int getPostcount() {
		return postcount;
	}

	public void add() {
		postcount++;
	}
}
