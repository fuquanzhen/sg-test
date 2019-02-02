package LightQuestion;

public class GarageDoorlightOnCommand implements Command {
	GarageDoor garagedoor;

	public GarageDoorlightOnCommand(GarageDoor garagedoor) {
		this.garagedoor = garagedoor;
	}

	public void execute() {
		garagedoor.lightOn();
	}
}
