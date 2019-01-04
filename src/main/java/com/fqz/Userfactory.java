package com.fqz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Userfactory {
	private Map<String, User> map;

	public Userfactory(Map<String, User> map2) {
		this.map = map2;
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

	public List<User> getUser(List<String> list) {
		List<User> list1 = new ArrayList<User>();
		for (String uid : list) {
			if (map.containsKey(uid)) {
				User user = map.get(uid);
				list1.add(user);
			}
		}
		return list1;
	}

	public void putUser(List<User> list) {
		for (User user : list) {
			map.put(user.getUid(), user);
		}
	}
}
