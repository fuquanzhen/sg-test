package com.light;

public class GarageDoorCloseCommand implements Command {
	GarageDoor garagedoor;

	public GarageDoorCloseCommand(GarageDoor garagedoor) {
		this.garagedoor = garagedoor;
	}

	public void execute() {
		garagedoor.down();
	}
}
