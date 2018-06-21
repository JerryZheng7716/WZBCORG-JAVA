package com.yhs.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.yhs.dao.ActivityDao;
import com.yhs.dao.OrganizationDao;
import com.yhs.model.Activity;

public class ActivityObserver implements Observer {
	private Activity activity;
	private javax.swing.JTable jTable1;
	private ActivityDao activityDao;

	public javax.swing.JTable getjTable1() {
		return jTable1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.jTable1 = jTable1;
	}

	public ActivityObserver(Activity activity){
		this.activity = activity;
	}
	
	public ActivityObserver(Activity activity, JTable jTable1,
			ActivityDao activityDao) {
		super();
		this.activity = activity;
		this.jTable1 = jTable1;
		this.activityDao = activityDao;
	}
	
	public void update() {
		System.out.println("µ÷ÓÃObserver update");
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);
		String[] s = {};
		List<String> ss  = new ArrayList<String>();
		if (activity.getActivityTime().length() == 0) {
			ss.add(activity.getActivityName());
			ss.add(activity.getActivityPlace());
			ss.add(activity.getOrgName());
			//s = {activity.getActivityName(), activity.getActivityPlace(), activity.getOrgName()};
		}
		else{
			ss.add(activity.getActivityName());
			ss.add(activity.getActivityPlace());
			ss.add(activity.getActivityTime());
			ss.add(activity.getOrgName());
		}
		List<Activity> listActivity = activityDao.listWithList(ss);
		Activity activity = null;
		if (listActivity.size() != 0) {
			for (int i = 0; i < listActivity.size(); i++) {
				activity = listActivity.get(i);
				Vector v = new Vector();
				v.add(activity.getActivityID());
				v.add(activity.getActivityName());
				v.add(activity.getActivityPlace());
				v.add(activity.getActivityTime());
				v.add(activity.getOrgName());
				v.add(activity.getActivityPs());
				dtm.addRow(v);
			}
		}
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
}