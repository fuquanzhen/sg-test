package com.sixe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import com.alibaba.fastjson.JSONObject;

public class Question {
	private String path;
	private List<JSONObject> list;

	public Question(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fileInputStream = new FileInputStream(path);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public void getPath(String path) {
		this.path = path;
	}

	public int question1() {
		return list.size();
	}

	public int question2() {
		HashSet<String> set = new HashSet<String>();
		for (JSONObject st : list) {
			Object uid = st.get("uid");
			set.add(uid.toString());
		}
		return set.size();
	}

	public void question3() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (JSONObject st : list) {
			Object cmtct = st.get("cmtct");
			list1.add(Integer.parseInt(cmtct.toString()));
		}
		float sum = 0;
		float avg = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum = list1.get(i) + sum;
			avg = sum / list1.size();
		}
		float s = 0;
		if (list1.size() % 2 != 0) {
			s = list1.get((list1.size() - 1) / 2);
		} else {
			s = (list1.get((list1.size() / 2) - 1) + list1.get(list.size() / 2)) / 2;
		}
		System.out.println("最大值:" + Collections.max(list1));
		System.out.println("最小值:" + Collections.min(list1));
		System.out.println("总和:" + sum);
		System.out.println("平均数" + avg);
		System.out.println("中位数:" + s);
	}

	public void question4() {
		ArrayList<String> list2 = new ArrayList<String>();
		for (JSONObject st : list) {
			Object uid = st.get("uid");
			list2.add(uid.toString());
		}
	}
}