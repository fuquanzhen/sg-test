package com.number66party;

public class Hottub {
	boolean on;
	int temperature;

	public Hottub() {
	}

	public void on() {
		on = true;
	}

	public void off() {
		on = false;
	}

	public void bubblesOn() {
		if (on) {
			System.out.println("Hottub is bubbling");
		}
	}

	public void bubblesOff() {
		if (on) {
			System.out.println("Hottub is not bubbling");
		}
	}

	public void jesOn() {
		if (on) {
			System.out.println("Hottub jes are on");
		}
	}

	public void jesOff() {
		if (on) {
			System.out.println("Hottub jes are off");
		}
	}

	public void setTemperature(int temp) {
		this.temperature = temp;
	}

	public void heatcool(int temp) {
		if (temp > this.temperature) {
			System.out.println("Hottub is heating to a steaming " + temp + " degrees");
		} else {
			System.out.println("Hottub is cooling to " + temp + " degrees");
		}
	}
}
