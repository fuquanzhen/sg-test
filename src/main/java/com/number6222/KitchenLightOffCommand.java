package com.number6222;

public class KitchenLightOffCommand implements Command {
	Light light;

	public KitchenLightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
}
