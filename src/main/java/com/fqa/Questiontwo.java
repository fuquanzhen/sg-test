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

public class Questiontwo {
	private String path;
	private List<JSONObject> list;

	public Questiontwo(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader its = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(its);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public Userfactorytwo question() {
		Map<String, Userthree> map = new HashMap<String, Userthree>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String st = uid.toString();
			int count = 1;
			if (map.containsKey(st)) {
				Userthree user = map.get(st);
				user.add();
				map.put(st, user);
			} else {
				Userthree user = new Userthree(st, count);
				map.put(st, user);
			}
		}
		Userfactorytwo ll = new Userfactorytwo(map);
		return ll;
	}
}
