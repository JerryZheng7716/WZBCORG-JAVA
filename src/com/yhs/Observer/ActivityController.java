package com.yhs.Observer;

import java.util.ArrayList;

import com.yhs.model.Activity;

public class ActivityController extends Controller {

	private Activity activity;
	
	ArrayList<Observer> observers = new ArrayList<Observer>();

	public ActivityController(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {

	}

	@Override
	public void notifyUpdate() {
		for (Observer observer : observers){
			observer.update();
		}
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
