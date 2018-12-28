package com.sixe;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
public class Question {
	private String path;
	private List list;
     public Question(String path) throws IOException{  	 
    	    this.list=new ArrayList<JSONObject>();
    	    FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line= null;
			while((line = bufferedReader.readLine()) != null){
				JSONObject json = JSONObject.parseObject(line);
				list.add(json);
			}
      }
     public void getPath(String path) {
    	 this.path=path;
     }
     public int question1() {
    	 return list.size();
     }
}