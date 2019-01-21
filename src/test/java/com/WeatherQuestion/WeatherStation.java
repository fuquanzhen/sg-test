package com.WeatherQuestion;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(88, 78, 30.0f);
		weatherData.setMeasurements(82, 87, 30.5f);
		weatherData.setMeasurements(89, 81, 29.5f);
		weatherData.setMeasurements(92, 90, 28.7f);
	}
}
