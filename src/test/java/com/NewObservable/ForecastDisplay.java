package com.NewObservable;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	private float CurrentPressure = 30.5f;
	private float lastPressure;
	private Observable observable;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			lastPressure = CurrentPressure;
			CurrentPressure = weatherData.getTemp();
			display();
		}
	}

	public void display() {
		System.out.println("Forecast:");
		if (CurrentPressure > lastPressure) {
			System.out.println("improving weather on the way!");
		} else if (CurrentPressure == lastPressure) {
			System.out.println("more of the same!");
		} else if (CurrentPressure < lastPressure) {
			System.out.println("watch out coller and rainy weather!");
		}
	}
}
