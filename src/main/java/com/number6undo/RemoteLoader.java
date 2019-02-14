package com.number6undo;

public class RemoteLoader {
	public static void main(String args[]) {
		RemoteControlWithUndo remote = new RemoteControlWithUndo();
		Light livingroomlight = new Light("Living Room");
		LivingRoomLightOnCommand livingroomlightOn = new LivingRoomLightOnCommand(livingroomlight);
		LivingRoomLightOffCommand livingroomlightOff = new LivingRoomLightOffCommand(livingroomlight);
		remote.setCommand(0, livingroomlightOn, livingroomlightOff);
		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(0);
		System.out.println(remote);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(0);
		remote.onButtonWasPushed(0);
		System.out.println(remote);
		remote.undoButtonWasPushed();
	}
}
