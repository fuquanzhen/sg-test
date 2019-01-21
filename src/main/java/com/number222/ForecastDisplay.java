package com.number222;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 31.8f;
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registicsObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		display();
	}

	public void display() {
		if (currentPressure > lastPressure) {
			System.out.println("improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("more of the same!");
		} else if (currentPressure < lastPressure) {
			System.out.println("watch out coolerang rainy weather!");
		}
	}
}
