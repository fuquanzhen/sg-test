package com.light;

public class RemoteControlTest {
	public static void main(String args[]) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		LightOffCommand lightOff = new LightOffCommand(light);
		remote.setCommand(lightOff);
		remote.buttonWasPressed();
	}
}
