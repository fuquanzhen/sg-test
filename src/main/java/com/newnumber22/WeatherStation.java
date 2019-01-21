package com.newnumber22;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(80, 70, 30.5f);
		weatherData.setMeasurements(75, 65, 29.9f);
		weatherData.setMeasurements(91, 87, 32.5f);
	}
}
