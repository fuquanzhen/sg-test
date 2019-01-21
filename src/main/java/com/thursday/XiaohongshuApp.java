package com.thursday;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class XiaohongshuApp {
	private String path;
	private List<Userxsh> list;

	public XiaohongshuApp(String path) throws IOException {
		this.list = new ArrayList<Userxsh>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			Object stact = json.get("stact");
			if (stact != null) {
				Float fol = Float.parseFloat(stact.toString());
				Integer it = fol.intValue();
				Userxsh user = new Userxsh(it, json);
				list.add(user);
			} else {
				Integer it = 0;
				Userxsh user = new Userxsh(it, json);
				list.add(user);
			}
		}
	}

	public List<Userxsh> question() {
		Collections.sort(list, new Comparator<Userxsh>() {
			public int compare(Userxsh o1, Userxsh o2) {
				int q1 = o1.getStact();
				int q2 = o2.getStact();
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
