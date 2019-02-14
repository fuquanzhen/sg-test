package com.number6222;

public class RemoteLoader {
	public static void main(String args[]) {
		RemoteControl remote = new RemoteControl();
		Light livingroomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		Stereo stereo = new Stereo("Living Room");
		TV tv = new TV("Living Room");
		LightOnCommand livingroomlightOn = new LightOnCommand(livingroomLight);
		LightOffCommand livingroomlightOff = new LightOffCommand(livingroomLight);
		LightOnCommand kitchenlightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenlightOff = new LightOffCommand(kitchenLight);
		StereoOnWithCDCommand stereoCD = new StereoOnWithCDCommand(stereo);
		StereoOnWithDVDCommand stereoDVD = new StereoOnWithDVDCommand(stereo);
		StereoOnWithRadioCommand stereoRadio = new StereoOnWithRadioCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);
		remote.setCommand(0, livingroomlightOn, livingroomlightOff);
		remote.setCommand(1, kitchenlightOn, kitchenlightOff);
		remote.setCommand(2, stereoCD, stereoOff);
		remote.setCommand(3, tvOn, tvOff);
		System.out.println(remote);
		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(0);
		remote.onButtonWasPushed(1);
		remote.offButtonWasPushed(1);
		remote.onButtonWasPushed(2);
		remote.offButtonWasPushed(2);
		remote.onButtonWasPushed(3);
		remote.offButtonWasPushed(3);
	}
}
