package com.fqzh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Question {
	private String path;
	private List<User> list;

	public Question(String path) throws IOException {
		this.list = new ArrayList<User>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			Object folct = json.get("folct");
			Float fol = Float.parseFloat(folct.toString());
			Integer pl = fol.intValue();
			User user = new User(pl, json);
			list.add(user);
		}
	}

	public List<User> questionone() {
		Collections.sort(list, new Comparator<User>() {
			public int compare(User o1, User o2) {
				int q1 = o1.getFolct();
				int q2 = o2.getFolct();
				int p = q2 - q1;
				if (p > 0) {
					return 1;
				} else if (p == 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		if (list.size() > 10000) {
			return list.subList(0, 10000);
		} else {
			return list;
		}
	}
}
