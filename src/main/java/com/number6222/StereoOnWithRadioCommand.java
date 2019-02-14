package com.number6222;

public class StereoOnWithRadioCommand implements Command {
	Stereo stereo;

	public StereoOnWithRadioCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
		stereo.setRadio();
		stereo.setVolume(11);
	}
}
