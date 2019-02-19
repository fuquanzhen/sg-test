package com.number66party;

public class TV {
	String location;
	int channel;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + "TV is on");
	}

	public void off() {
		System.out.println(location + "TV is off");
	}

	public void setInputChannel() {
		int channel = 3;
		System.out.println("Channel is set for VCR");
	}
}
