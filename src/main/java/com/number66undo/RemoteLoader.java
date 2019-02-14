package com.number66undo;

public class RemoteLoader {
	public static void main(String args[]) {
		RemoteControlWithUndo remote = new RemoteControlWithUndo();
		CeilingFan ceilingfan = new CeilingFan("Living Room");
		CeilingFanHighCommand ceilingfanhigh = new CeilingFanHighCommand(ceilingfan);
		CeilingFanMediumCommand ceilingfanmedium = new CeilingFanMediumCommand(ceilingfan);
		CeilingFanLowCommand ceilingfanlow = new CeilingFanLowCommand(ceilingfan);
		CeilingFanOffCommand ceilingfanoff = new CeilingFanOffCommand(ceilingfan);
		remote.setCommand(0, ceilingfanhigh, ceilingfanoff);
		remote.setCommand(1, ceilingfanmedium, ceilingfanoff);
		remote.setCommand(2, ceilingfanlow, ceilingfanoff);
		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(0);
		System.out.println(remote);
		remote.unButtonWasPushed();
		remote.onButtonWasPushed(1);
		remote.offButtonWasPushed(1);
		System.out.println(remote);
		remote.unButtonWasPushed();
		remote.onButtonWasPushed(2);
		remote.offButtonWasPushed(2);
		System.out.println(remote);
		remote.unButtonWasPushed();
	}
}
