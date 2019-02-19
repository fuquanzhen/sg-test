package com.reviewone;

public class NewFile {
	private float sum;
	private float avg;
	private float zws;
	private int max;
	private int min;

	public NewFile(int max, int min, float sum, float avg, float zws) {
		this.max = max;
		this.min = min;
		this.sum = sum;
		this.avg = avg;
		this.zws = zws;
	}

	public float getSum() {
		return sum;
	}

	public float getAvg() {
		return avg;
	}

	public float getZws() {
		return zws;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}
}
