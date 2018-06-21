package com.yhs.model;

public class Activity {
	private int ActivityID;
	private String ActivityName;
	private String ActivityPlace;
	private String ActivityTime;
	private String OrgName;
	private String ActivityPs;

	public int getActivityID() {
		return ActivityID;
	}

	public void setActivityID(int activityID) {
		ActivityID = activityID;
	}

	public String getActivityName() {
		return ActivityName;
	}

	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}

	public String getActivityPlace() {
		return ActivityPlace;
	}

	public void setActivityPlace(String activityPlace) {
		ActivityPlace = activityPlace;
	}

	public String getActivityTime() {
		return ActivityTime;
	}

	public void setActivityTime(String activityTime) {
		ActivityTime = activityTime;
	}

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

	public String getActivityPs() {
		return ActivityPs;
	}

	public void setActivityPs(String activityPs) {
		ActivityPs = activityPs;
	}

	public Activity() {
		super();
	}

	public Activity(String activityName, String activityPlace,
			String activityTime, String orgName, String activityPs) {
		super();
		ActivityName = activityName;
		ActivityPlace = activityPlace;
		ActivityTime = activityTime;
		OrgName = orgName;
		ActivityPs = activityPs;
	}

	public Activity(int activityID, String activityName, String activityPlace,
			String activityTime, String orgName, String activityPs) {
		super();
		ActivityID = activityID;
		ActivityName = activityName;
		ActivityPlace = activityPlace;
		ActivityTime = activityTime;
		OrgName = orgName;
		ActivityPs = activityPs;
	}

	public Activity(int activityID) {
		super();
		ActivityID = activityID;
	}

	public Activity(String activityName, String activityPlace,
			String activityTime, String orgName) {
		super();
		ActivityName = activityName;
		ActivityPlace = activityPlace;
		ActivityTime = activityTime;
		OrgName = orgName;
	}
}
