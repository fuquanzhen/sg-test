package com.sixe;

import java.io.IOException;
import java.text.ParseException;

public class NoteTester {
	public static void main(String args[]) throws IOException, ParseException {
		String path = "C:\\task_interview\\task\\data.txt";
		Question hh = new Question(path);
		UserFactory uf = hh.question10();
		System.out.println(uf.getUser("2294629187").getNotes());
	}
}