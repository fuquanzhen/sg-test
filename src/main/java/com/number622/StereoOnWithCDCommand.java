package com.number622;

public class StereoOnWithCDCommand {
	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(11);
	}
}
