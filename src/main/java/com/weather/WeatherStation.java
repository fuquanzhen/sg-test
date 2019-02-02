package com.weather;

public class WeatherStation {
	public static void main(String args[]) {
		WeatherData weatherData = new WeatherData();
		StatisticsDisplay statistics = new StatisticsDisplay(weatherData);
		ForecastDisplay forecast = new ForecastDisplay(weatherData);
		CurrentConditionsDisplay current = new CurrentConditionsDisplay(weatherData);
		HeatindexDisplay heatindex = new HeatindexDisplay(weatherData);
		weatherData.measurements(80, 65, 30.4f);
		weatherData.measurements(82, 70, 29.2f);
		weatherData.measurements(78, 90, 29.2f);
	}
}
