package com.number222;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registicsObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Current Conditions:" + temp + "F degrees and" + humidity + "% humidity");
	}
}
