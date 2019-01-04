package com.fqa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Questionthree {
	private String path;
	private List<JSONObject> list;

	public Questionthree(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public Userfactorythree question() {
		Map<String, Userthree> map = new HashMap<String, Userthree>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int count = 1;
			if (map.containsKey(str)) {
				Userthree user = map.get(str);
				user.add();
				map.put(str, user);
			} else {
				Userthree user = new Userthree(str, count);
				map.put(str, user);
			}
		}
		Userfactorythree lll = new Userfactorythree(map);
		return lll;
	}
}
