package com.yhs.model;

public class Attendance {
	private int AttID;
	private String PersonNumber;
	private String ActivityID;
	private String AttTime;
	private Boolean AttLate;
	private String OrgName;
	private String AttPs;

	public int getAttID() {
		return AttID;
	}

	public void setAttID(int attID) {
		AttID = attID;
	}

	public String getPersonNumber() {
		return PersonNumber;
	}

	public void setPersonNumber(String personNumber) {
		PersonNumber = personNumber;
	}

	public String getActivityID() {
		return ActivityID;
	}

	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}

	public String getAttTime() {
		return AttTime;
	}

	public void setAttTime(String attTime) {
		AttTime = attTime;
	}

	public Boolean getAttLate() {
		return AttLate;
	}

	public void setAttLate(Boolean attLate) {
		AttLate = attLate;
	}

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

	public String getAttPs() {
		return AttPs;
	}

	public void setAttPs(String attPs) {
		AttPs = attPs;
	}

}
