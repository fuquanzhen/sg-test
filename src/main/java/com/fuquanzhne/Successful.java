package com.fuquanzhne;

public class Successful {
	private int max;
	private int min;
	private float sum;
	private float avg;
	private float z;

	public Successful(int max, int min, float sum, float avg, float z) {
		this.max = max;
		this.min = min;
		this.sum = sum;
		this.avg = avg;
		this.z = z;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public float getSum() {
		return sum;
	}

	public float getAvg() {
		return avg;
	}

	public float getZ() {
		return z;
	}
}
