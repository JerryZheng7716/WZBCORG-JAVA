package com.yhs.Observer;

import com.yhs.model.Activity;

public class Client {
	public static void main(String[] args) {
		Activity activity = new Activity();
		activity.setActivityName("huo dong 111");
		activity.setActivityPlace("di dian 111");
		activity.setActivityTime("20180618");
		activity.setOrgName("zu zhi 111");
		
		Controller activityController = new ActivityController(activity);
		
		Observer activityObserver = new ActivityObserver(((ActivityController) activityController).getActivity());
		
		activityController.addObserver(activityObserver);
		
		activityController.notifyUpdate();
	}
}
