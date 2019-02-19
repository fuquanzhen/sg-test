package com.reviewone;

import java.util.Map;

public class UserFactory {
	private Map<String,User> map;
	public UserFactory(Map<String,User> map) {
		this.map=map;
	}
	public Map<String, User> getMap() {
		return map;
	}
	public User getUser(String uid) {
		return map.get(uid);
	}
}
