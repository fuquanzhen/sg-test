package com.fuqz;

public class Test1 {
	private float sum;
	private float avg;
	private float h;
	private int max;
	private int min;

	public Test1(int max, int min, float sum, float avg, float h) {
		this.max = max;
		this.min = min;
		this.sum = sum;
		this.avg = avg;
		this.h = h;
	}

	public float getSum() {
		return sum;
	}

	public float getAvg() { 
		return avg;
	}

	public float getH() {
		return h;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}
}
