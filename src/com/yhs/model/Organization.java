package com.yhs.model;

public class Organization {
	private String OrgName;

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

	public Organization(String orgName) {
		super();
		OrgName = orgName;
	}

	public Organization() {
		super();
	}

	@Override
	public String toString() {
		return OrgName;
	}
	
}
