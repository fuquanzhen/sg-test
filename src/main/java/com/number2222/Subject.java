package com.number2222;

public interface Subject {
	public void registicsObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();
}
