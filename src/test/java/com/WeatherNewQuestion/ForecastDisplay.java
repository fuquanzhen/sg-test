package com.WeatherNewQuestion;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 30.5f;
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = temp;
		display();
	}

	public void display() {
		System.out.println("Forecast:");
		if (currentPressure > lastPressure) {
			System.out.println("improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("more of the same!");
		} else if (currentPressure < lastPressure) {
			System.out.println("watch out coller and rainy weather!");
		}
	}
}
