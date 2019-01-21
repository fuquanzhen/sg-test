package com.number2222;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurement(88, 77, 30.8f);
		weatherData.setMeasurement(91, 87, 29.9f);
		weatherData.setMeasurement(97, 89, 33.7f);
		weatherData.setMeasurement(81, 95, 28.7f);
	}
}
