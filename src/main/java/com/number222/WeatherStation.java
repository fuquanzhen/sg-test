package com.number222;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		StatisticsDisplay statistDisplay = new StatisticsDisplay(weatherData);
		HeatindexDisplay heatDisplay = new HeatindexDisplay(weatherData);
		weatherData.setMeasureMents(85, 75, 30.5f);
		weatherData.setMeasureMents(88, 82, 29.9f);
		weatherData.setMeasureMents(89, 91, 32.5f);
		weatherData.setMeasureMents(92, 93, 31.8f);
	}
}
