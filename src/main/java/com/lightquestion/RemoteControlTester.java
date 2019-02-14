package com.lightquestion;

public class RemoteControlTester {
	public static void main(String args[]) {
		SimpleRemoteControl simple = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		simple.setCommand(lightOn);
		simple.bttonWasPressed();
		LightOffCommand lightOff = new LightOffCommand(light);
		simple.setCommand(lightOff);
		simple.bttonWasPressed();
		GarageDoor garagedoor = new GarageDoor();
		GarageDoorOpenCommand garagedoorOpen = new GarageDoorOpenCommand(garagedoor);
		simple.setCommand(garagedoorOpen);
		simple.bttonWasPressed();
	}
}