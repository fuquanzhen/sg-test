package com.fqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Userfactoryone {
	private Map<String, Userone> map;

	public Userfactoryone(Map<String, Userone> map) {
		this.map = map;
	}

	public Map<String, Userone> getMap() {
		return map;
	}

	public Userone getUser(String uid) {
		return map.get(uid);
	}

	public Userone delUser(String uid) {
		return map.remove(uid);
	}

	public Userone updataUser(Userone user) {
		return map.put(user.getUid(), user);
	}

	public List<Userone> getUser(List<String> list) {
		List<Userone> list1 = new ArrayList<Userone>();
		for (String uid : list) {
			if (map.containsKey(uid)) {
				Userone user = map.get(uid);
				list1.add(user);
			}
		}
		return list1;
	}

	public void putUser(List<Userone> list) {
		for (Userone user : list) {
			map.put(user.getUid(), user);
		}
	}
}
