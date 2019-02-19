package com.number66party;

public class HottubOnwithcoolCommand implements Command {
	Hottub hottub;

	public HottubOnwithcoolCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.setTemperature(100);
		hottub.heatcool(90);
	}

	public void undo() {
		hottub.setTemperature(90);
		hottub.heatcool(100);
	}
}
