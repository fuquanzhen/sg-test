package com.number66party;

public class HottubOnwithheatCommand implements Command {
	Hottub hottub;

	public HottubOnwithheatCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.setTemperature(100);
		hottub.heatcool(104);
	}

	public void undo() {
		hottub.setTemperature(104);
		hottub.heatcool(100);
	}
}
