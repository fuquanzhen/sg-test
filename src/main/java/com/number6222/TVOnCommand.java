package com.number6222;

public class TVOnCommand implements Command {
	TV tv;

	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	public void execute() {
		tv.on();
		tv.setInputChannel();
		tv.setVolume(11);
	}
}
