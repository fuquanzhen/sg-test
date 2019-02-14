package com.number6undo;

public class LivingRoomLightOffCommand implements Command {
	Light light;

	public LivingRoomLightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}

	public void undo() {
		light.on();
	}
}
