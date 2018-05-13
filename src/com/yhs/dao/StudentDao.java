package com.yhs.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import other.wzbcOrg.AdminLogin;

import com.yhs.helper.SqlFunction;
import com.yhs.model.Student;

public class StudentDao {
	SqlFunction sqlFunction;
	private String AdminOrgName = AdminLogin.getOrgName();

	public String StudentName(String studentNumber) {
		String s = "";
		ResultSet rs = null;
		sqlFunction = new SqlFunction();
		String sql = "Select * from StuBasicInfo_view where PersonNumber = "
				+ studentNumber;
		if (!AdminOrgName.equals("温州商学院")) {
			sql += " and OrgName = '" + AdminOrgName + "'";
		}
		String[] newPsString = {};
		rs = sqlFunction.doSqlSelect(sql, newPsString, false);

		try {
			if (rs.next()) {
				s = rs.getString("PersonName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return s;
	}

	public String StudentOrgName(String studentNumber) {
		String s = "";
		ResultSet rs = null;
		sqlFunction = new SqlFunction();
		String sql = "EXEC P_StuBasicInfo '" + studentNumber + "'";

		String[] newPsString = {};
		rs = sqlFunction.doSqlSelect(sql, newPsString, false);

		try {
			if (rs.next()) {
				s = rs.getString("OrgName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return s;
	}

	public List<Student> list(Student student, String[] psString) {
		List<Student> listStudents = new ArrayList<Student>();
		ResultSet rs = null;
		sqlFunction = new SqlFunction();

		if (psString.length == 0) {
			String sql = "Select * FROM StuBasicInfo_view";
//			if (AdminOrgName != "温州商学院") {
//				sql += " WHERE OrgName = '" + AdminOrgName + "'";
//			}
			String[] newPsString = {};
			rs = sqlFunction.doSqlSelect(sql, newPsString, false);
		} else if (psString.length == 3) {
			String sql = "Select * from StuBasicInfo_view where "
					+ "PersonNumber like '%" + psString[0]
					+ "%' and PersonName like '%" + psString[1]
					+ "%' and OrgName like '%" + psString[2] + "%'";
//			if (AdminOrgName != "温州商学院") {
//				sql += " and OrgName = '" + AdminOrgName + "'";
//			}
			String[] newPsString = {};
			rs = sqlFunction.doSqlSelect(sql, newPsString, false);
		}

		Student studentTemp;
		try {
			while (rs.next()) {
				studentTemp = new Student();
				studentTemp.setPersonNumber(rs.getString("PersonNumber"));
				studentTemp.setPersonName(rs.getString("PersonName"));
				studentTemp.setOrgName(rs.getString("OrgName"));
				listStudents.add(studentTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return listStudents;
	}

}
