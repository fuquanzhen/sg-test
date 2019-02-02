package com.weather;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.2f;
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		display();
	}

	public void display() {
		System.out.println("Forecast:");
		if (currentPressure > lastPressure) {
			System.out.println("improving the weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("more of the same!");
		} else if (currentPressure < lastPressure) {
			System.out.println("watch out for cooler and rainy weather!");
		}
	}
}
