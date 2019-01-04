package com.fqa;

public class Userone {
	private String uid;
	private int count;

	public Userone(String uid, int count) {
		this.uid = uid;
		this.count = count;
	}

	public String getUid() {
		return uid;
	}

	public int getCount() {
		return count;
	}

	public void add() {
		count++;
	}
}
