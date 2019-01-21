package com.fuquanzhne;

import java.io.IOException;

public class NoteTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\data.txt";
		Question q = new Question(path);
		UserFactory rel = q.question9();
		for (Note note : rel.getUser("1892940977").getNotes()) {
			System.out.println(note.getSentiment());
			System.out.println(note.getContent());
			System.out.println(note.getPub_time());
			System.out.println(note.getUid());
			System.out.println(note.getWord_pos());
		}
	}
}
