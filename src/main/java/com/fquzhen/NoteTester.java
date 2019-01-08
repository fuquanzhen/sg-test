package com.fquzhen;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class NoteTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\data.txt";
		Question q = new Question(path);
		UserFactory rel = q.questionnine();
		for (Note note : rel.getUser("5967496511").getNotes()) {
			System.out.println(note.getUid());
			System.out.println(note.getContent());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(format.format(note.getPub_time()));
			System.out.println(note.getPname());
		}
	}
}
