package com.yhs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import other.wzbcOrg.AdminLogin;

import com.yhs.helper.SqlFunction;
import com.yhs.helper.SqlHelper;
import com.yhs.model.Activity;
import com.yhs.model.Attendance;

public class AttendanceDao {
	Connection con;
	SqlHelper sqlHelper;
	SqlFunction sqlFunction = new SqlFunction();
	private String AdminOrgName = AdminLogin.getOrgName();

	public int AddAttendance(Attendance attendance) {
		String sql = "INSERT INTO tb_attendance VALUES (?, ?, ?, ?, ?)";
		String[] stringList = { attendance.getPersonNumber(),
				attendance.getActivityID().toString(), attendance.getAttTime(),
				attendance.getAttLate() == true ? "1" : "0",
				attendance.getAttPs() };
		int a = 0;
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (a > 0) {
			System.out.println("¿¼ÇÚÌí¼Ó³É¹¦");
		} else {
			System.out.println("¿¼ÇÚÌí¼ÓÊ§°Ü");
		}
		return a;
	}

	public int UpdateAttendance(Attendance attendance) {
		int a = 0;
		String sql = "Update tb_attendance set PersonNumber = ?, ActivityID = ?, AttTime = ?, AttLate = ?, AttPs = ? where AttID = ? ";
		String[] stringList = { attendance.getPersonNumber(),
				attendance.getActivityID().toString(), attendance.getAttTime(),
				attendance.getAttLate() == true ? "1" : "0",
				attendance.getAttPs(), attendance.getAttID() + "" };
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
			if (a > 0) {
				System.out.println("¿¼ÇÚÐÞ¸Ä³É¹¦");
			} else {
				System.out.println("¿¼ÇÚÐÞ¸ÄÊ§°Ü");
			}
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public int DeleteAttendance(Attendance attendance) {
		int a = 0;
		String sql = "Delete tb_attendance where AttID = '"
				+ attendance.getAttID() + "' ";
		String[] stringList = {};
		System.out.println(sql);
		try {
			a = sqlFunction.doSqlUpdate(sql, stringList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (a > 0) {
			System.out.println("¿¼ÇÚÉ¾³ý³É¹¦");
		} else {
			System.out.println("¿¼ÇÚÉ¾³ýÊ§°Ü");
		}
		return a;
	}

	public List<Attendance> list(String[] psString) {
		String sql = null;
		ResultSet rs = null;

		if (psString.length > 0) {
			// System.out.println(psString.length);
			if (psString.length == 4) {
				sql = "select * from tb_attendance where AttID like ? and PersonNumber like ? and ActivityID like ?";
				rs = sqlFunction.doSqlSelect(sql, psString, true);
			}
		} else {
			sql = "select * from tb_attendance";
			String[] psString1 = {};
			rs = sqlFunction.doSqlSelect(sql, psString1, false);
		}
		List<Attendance> listAttendance = new ArrayList<Attendance>();
		Attendance attendanceTemp = null;
		try {
			while (rs.next()) {
				attendanceTemp = new Attendance();
				attendanceTemp.setAttID(rs.getInt("AttID"));
				attendanceTemp.setPersonNumber(rs.getString("PersonNumber"));
				attendanceTemp.setActivityID(rs.getString("ActivityID"));
				attendanceTemp.setAttTime(rs.getString("AttTime"));
				attendanceTemp.setAttLate(rs.getBoolean("AttLate"));
				if (rs.getString("AttPs") == null) {
					attendanceTemp.setAttPs("");
				} else {
					// System.out.println(rs.getString("AttPs"));
					attendanceTemp.setAttPs(rs.getString("AttPs"));
				}
				// System.out.println(tempActivity.getActivityPs());
				listAttendance.add(attendanceTemp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return listAttendance;
	}

	public String selectPersonName(String personNumber) {
		String sql = null;
		ResultSet rs = null;
		sql = "select * from tb_person where PersonNumber = '" + personNumber
				+ "'";
		String[] psString = {};
		rs = sqlFunction.doSqlSelect(sql, psString, false);
		try {
			if (rs.next()) {
				return rs.getString("PersonName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return " ";
	}

}
