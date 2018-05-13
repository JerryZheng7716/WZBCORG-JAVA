package com.yhs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import other.wzbcOrg.AdminLogin;

import com.yhs.helper.*;
import com.yhs.model.*;

public class ActivityDao {
	Connection con;
	SqlHelper sqlHelper;
	SqlFunction sqlFunction = new SqlFunction();
	private String AdminOrgName = AdminLogin.getOrgName();

	public int AddActivity(Activity activity) {
		int a = 0;

		String sql = "INSERT INTO tb_activity VALUES (?, ?, ?, ?, ?)";
		String[] stringList = { activity.getActivityName(),
				activity.getActivityPlace(), activity.getActivityTime(),
				activity.getOrgName(), activity.getActivityPs() };
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (a > 0) {
			System.out.println("活动添加成功");
		} else {
			System.out.println("活动添加失败");
		}
		return a;
	}

	public int UpdateActivity(Activity activity) {
		int a = 0;
		String sql = "Update tb_activity set ActivityName = ?, ActivityPlace = ?, ActivityTime = ?, OrgName = ?, ActivityPs = ? where ActivityID = ? ";
		String[] stringList = { activity.getActivityName(),
				activity.getActivityPlace(), activity.getActivityTime(),
				activity.getOrgName(), activity.getActivityPs(),
				activity.getActivityID() + "" };
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (a > 0) {
			System.out.println("活动修改成功");
		} else {
			System.out.println("活动修改失败");
		}
		return a;
	}

	public int DeleteActivity(Activity activity) {
		int a = 0;
		String sql = "Delete tb_activity where ActivityID = ? ";
		String[] stringList = { activity.getActivityID() + "" };
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
			return a;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (a > 0) {
			System.out.println("活动删除成功");
		} else {
			System.out.println("活动删除失败");
		}
		return a;
	}

	public List<Activity> list(String[] psString) {

		String sql = null;
		ResultSet rs = null;

		if (psString.length > 0) {
			// System.out.println(psString.length);
			if (psString.length == 2) {
				sql = "select * from tb_activity where ActivityID like ? and ActivityName like ?";
				if (!AdminOrgName.equals("温州商学院")) {
					sql += " and OrgName = '" + AdminOrgName + "'";
				}
				rs = sqlFunction.doSqlSelect(sql, psString, true);
			} else if (psString.length == 3) {
				sql = "select * from tb_activity where ActivityName like ? and ActivityPlace like ? and OrgName like ?";
				if (!AdminOrgName.equals("温州商学院")) {
					sql += " and OrgName = '" + AdminOrgName + "'";
				}
				rs = sqlFunction.doSqlSelect(sql, psString, true);
			} else {
				String[] newPsString = { psString[0], psString[1], psString[3] };
				sql = "select * from tb_activity where ActivityName like ? and ActivityPlace like ? and ActivityTime = '"
						+ psString[2] + "' and OrgName like ?";
				if (!AdminOrgName.equals("温州商学院")) {
					sql += " and OrgName = '" + AdminOrgName + "'";
				}
				rs = sqlFunction.doSqlSelect(sql, newPsString, true);
			}
		} else {
			sql = "select * from tb_activity";
			if (!AdminOrgName.equals("温州商学院")) {
				sql += " Where OrgName = '" + AdminOrgName + "'";
			}
			String[] psString1 = {};
			rs = sqlFunction.doSqlSelect(sql, psString1, false);
		}
		System.out.println(sql);
		List<Activity> listActivity = new ArrayList<Activity>();
		// TODO
		Activity tempActivity = null;
		try {
			while (rs.next()) {
				tempActivity = new Activity();
				tempActivity.setActivityID(rs.getInt("ActivityID"));
				// System.out.println(rs.getInt("ActivityID"));
				tempActivity.setActivityName(rs.getString("ActivityName"));
				tempActivity.setActivityPlace(rs.getString("ActivityPlace"));
				tempActivity.setActivityTime(rs.getString("ActivityTime"));
				tempActivity.setOrgName(rs.getString("OrgName"));
				tempActivity.setActivityPs(rs.getString("ActivityPs"));
				if (rs.getString("ActivityPs") == null) {
					tempActivity.setActivityPs("");
				} else {
					// System.out.println(rs.getString("ActivityPs"));
				}
				// System.out.println(tempActivity.getActivityPs());
				listActivity.add(tempActivity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return listActivity;
	}

}
