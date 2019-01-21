package com.newfil;

import com.alibaba.fastjson.JSONObject;

public class User {
	private Integer stact;
	private JSONObject json;

	public User(Integer stact, JSONObject json) {
		this.stact = stact;
		this.json = json;
	}

	public Integer getStact() {
		return stact;
	}

	public JSONObject getJson() {
		return json;
	}
}
