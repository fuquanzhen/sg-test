package com.number66party;

public class HottubOffCommand implements Command {
	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.bubblesOff();
	}

	public void undo() {
		hottub.bubblesOn();
	}
}
