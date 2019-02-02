package LightQuestion;

public class GarageDoorlightOffCommand implements Command {
	GarageDoor garagedoor;

	public GarageDoorlightOffCommand(GarageDoor garagedoor) {
		this.garagedoor = garagedoor;
	}

	public void execute() {
		garagedoor.lightOff();
	}
}
