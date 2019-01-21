package com.fuquanzhne;

import java.util.List;

public class User {
	private String uid;
	private int postcount;
	private List<Note> notes;

	public User(String uid, int postcount) {
		this.uid = uid;
		this.postcount = postcount;
	}

	public User(String uid, int postcount, List<Note> notes) {
		this.notes = notes;
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

	public List<Note> getNotes() {
		return notes;
	}

	public void add(Note note) {
		notes.add(note);
		this.postcount = notes.size();
	}
}
