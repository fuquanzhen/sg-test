package com.newfile;

public class User {
	private String uid;
	private int postcount;

	public User(String uid, int postcount) {
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
