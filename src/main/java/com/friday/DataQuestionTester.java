package com.friday;

import java.io.IOException;

public class DataQuestionTester {
	public static void main(String args[]) throws IOException {
		String path = "C:\\task_interview\\task\\data.txt";
		DataQuestion d = new DataQuestion(path);
		System.out.println(d.question1());
		System.out.println(d.question2());
	}
}
