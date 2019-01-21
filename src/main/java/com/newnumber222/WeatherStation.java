package com.newnumber222;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(90, 87, 32.5f);
		weatherData.setMeasurements(88, 95, 28.6f);
		weatherData.setMeasurements(99, 82, 29.7f);
	}
}
