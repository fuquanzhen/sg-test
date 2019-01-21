package com.fqzh;

import com.alibaba.fastjson.JSONObject;

public class User {

	private Integer folct;
	private JSONObject json;

	public User(Integer folct, JSONObject json) {
		this.folct = folct;
		this.json = json;
	}

	public JSONObject getJson() {
		return json;
	}

	public Integer getFolct() {
		return folct;
	}
}
