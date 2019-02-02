package LightQuestion;

public class GarageDoorStopCommand implements Command {
	GarageDoor garagedoor;

	public GarageDoorStopCommand(GarageDoor garagedoor) {
		this.garagedoor = garagedoor;
	}

	public void execute() {
		garagedoor.stop();
	}
}
