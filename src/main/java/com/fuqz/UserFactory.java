package com.fuqz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserFactory {
	private Map<String, User> map;

	public UserFactory(Map<String, User> map) {
		this.map = map;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public User getUser(String uid) {
		return map.get(uid);
	}

	public User delUser(String uid) {
		return map.remove(uid);
	}

	public User updataUser(User user) {
		return map.put(user.getUid(), user);
	}

	public List<User> getMulUser(List<String> list) {
		List<User> list1 = new ArrayList<User>();
		for (String uid : list) {
			if (map.containsKey(uid)) {
				User user = map.get(uid);
				list1.add(user);
			}
		}
		return list1;
	}

	public void putMulUser(List<User> list) {
		for (User user : list) {
			map.put(user.getUid(), user);
		}
	}
}
