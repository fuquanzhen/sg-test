package com.newnumber22;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Avg/Max/Min temp=" + temp);
	}
}
