package com.yhs.Observer;

import java.util.ArrayList;

public abstract class Controller {
	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	public abstract void addObserver(Observer observer);
	public abstract void deleteObserver(Observer observer);
	public abstract void notifyUpdate();
}
