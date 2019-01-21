package com.thursday;

import com.alibaba.fastjson.JSONObject;

public class Userxsh {
	private Integer stact;
	private JSONObject json;

	public Userxsh(Integer stact, JSONObject json) {
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
