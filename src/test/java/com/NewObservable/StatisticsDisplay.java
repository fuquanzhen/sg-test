package com.NewObservable;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum;
	private int numReadings;
	private Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			float temp = weatherData.getTemp();
			tempSum += temp;
			numReadings++;
			if (temp > maxTemp) {
				maxTemp = temp;
			}
			if (temp < minTemp) {
				minTemp = temp;
			}
			display();
		}
	}

	public void display() {
		System.out.println("Avg/Max/Min temparetor=" + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}
}
