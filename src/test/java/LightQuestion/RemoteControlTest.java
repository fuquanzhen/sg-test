package LightQuestion;

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
		GarageDoor garagedoor = new GarageDoor();
		GarageDoorOpenCommand garagedoorOpen = new GarageDoorOpenCommand(garagedoor);
		remote.setCommand(garagedoorOpen);
		remote.buttonWasPressed();
		GarageDoorCloseCommand garagedoorClose = new GarageDoorCloseCommand(garagedoor);
		remote.setCommand(garagedoorClose);
		remote.buttonWasPressed();
		GarageDoorStopCommand garagedoorStop = new GarageDoorStopCommand(garagedoor);
		remote.setCommand(garagedoorStop);
		remote.buttonWasPressed();
		GarageDoorlightOnCommand garagedoorlightOn = new GarageDoorlightOnCommand(garagedoor);
		remote.setCommand(garagedoorlightOn);
		remote.buttonWasPressed();
		GarageDoorlightOffCommand garagedoorlightOff = new GarageDoorlightOffCommand(garagedoor);
		remote.setCommand(garagedoorlightOff);
		remote.buttonWasPressed();
	}
}
