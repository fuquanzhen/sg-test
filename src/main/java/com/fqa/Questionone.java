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

public class Questionone {
	private String path;
	private List<JSONObject> list;

	public Questionone(String path) throws IOException {
		this.list = new ArrayList<JSONObject>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader is = new InputStreamReader(fis, "UTF_8");
		BufferedReader br = new BufferedReader(is);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public Userfactoryone question() {
		Map<String, Userone> map = new HashMap<String, Userone>();
		for (JSONObject c : list) {
			Object uid = c.get("uid");
			String str = uid.toString();
			int count = 1;
			if (map.containsKey(str)) {
				Userone user = map.get(str);
				user.add();
				map.put(str, user);
			} else {
				Userone user = new Userone(str, count);
				map.put(str, user);
			}
		}
		Userfactoryone l = new Userfactoryone(map);
		return l;
	}
}
