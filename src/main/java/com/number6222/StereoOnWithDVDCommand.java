package com.number6222;

public class StereoOnWithDVDCommand implements Command {
	Stereo stereo;

	public StereoOnWithDVDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
		stereo.setDvd();
		stereo.setVolume(11);
	}
}
