package com.fqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Userfactorythree {
	private Map<String, Userthree> map;

	public Userfactorythree(Map<String, Userthree> map) {
		this.map = map;
	}

	public Map<String, Userthree> getMap() {
		return map;
	}

	public Userthree getUser(String uid) {
		return map.get(uid);
	}

	public Userthree delUser(String uid) {
		return map.remove(uid);
	}

	public Userthree updataUser(Userthree user) {
		return map.put(user.getUid(), user);
	}

	public List<Userthree> getUser(List<String> list) {
		List<Userthree> list1 = new ArrayList<Userthree>();
		for (String uid : list) {
			if (map.containsKey(uid)) {
				Userthree user = map.get(uid);
				list1.add(user);
			}
		}
		return list1;
	}

	public void putUser(List<Userthree> list) {
		for (Userthree user : list) {
			map.put(user.getUid(), user);
		}
	}
}
