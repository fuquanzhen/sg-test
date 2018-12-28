package com.sixe;
import java.io.IOException;
public class QuestionTester {
   public static void main(String args[]) throws IOException {
	   String path="C:\\task_interview\\task\\data.txt";
	   Question q1=new Question(path);
	   System.out.println(q1.getSize());
   }
}
