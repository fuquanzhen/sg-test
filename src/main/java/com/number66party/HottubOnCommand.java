package com.number66party;

public class HottubOnCommand implements Command {
	Hottub hottub;

	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.bubblesOn();
	}

	public void undo() {
		hottub.bubblesOff();
	}
}
