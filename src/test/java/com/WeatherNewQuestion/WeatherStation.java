package com.WeatherNewQuestion;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDispaly = new ForecastDisplay(weatherData);
		HeatindexDisplay heatDisplay = new HeatindexDisplay(weatherData);
		weatherData.setMeasurements(80, 82, 29.1f);
		weatherData.setMeasurements(78, 87, 30.5f);
		weatherData.setMeasurements(85, 77, 30.5f);
	}
}
