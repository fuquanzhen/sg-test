package com.number66party;

public class RemoteControlTest {
	public static void main(String args[]) {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light("Living Room");
		TV tv = new TV("Living room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		HottubOnwithheatCommand hottubheat = new HottubOnwithheatCommand(hottub);
		HottubOnwithcoolCommand hottubcool = new HottubOnwithcoolCommand(hottub);
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);
		Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn, hottubheat };
		Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff, hottubcool };
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		System.out.println(remoteControl);
		System.out.println("------Pushing Macro On------");
		remoteControl.onButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		System.out.println("------Pushing Macro Off------");
		remoteControl.offButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
	}
}