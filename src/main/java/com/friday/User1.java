package com.friday;

import com.alibaba.fastjson.JSONObject;

public class User1 {
	private Integer stact;
	private JSONObject json;

	public User1(Integer stact, JSONObject json) {
		this.json = json;
		this.stact = stact;
	}

	public Integer getStact() {
		return stact;
	}

	public JSONObject getJson() {
		return json;
	}
}
