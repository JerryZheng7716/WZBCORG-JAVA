package com.yhs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import other.wzbcOrg.AdminLogin;

import com.yhs.helper.SqlFunction;
import com.yhs.helper.SqlHelper;
import com.yhs.model.Reward;

public class RewardDao {

	SqlFunction sqlFunction;
	private String AdminOrgName = AdminLogin.getOrgName();
	private StudentDao studentDao;
	

	// 增加奖惩信息记录
	public int AddReward(Reward reward) {
		// 下判断输入的学号是否属于该组织
		studentDao = new StudentDao();
		String StudentOrgName = studentDao.StudentOrgName(reward.getPersonNumber());
		System.out.println(AdminOrgName);
		System.out.println(StudentOrgName);
		if(!AdminOrgName.equals("温州商学院") ){
			if(StudentOrgName.equals(AdminOrgName) == false){
				System.out.println("1111");
				return -1;
			}
		}
		
		
		sqlFunction = new SqlFunction();
		String sql = "";
		int a = 0;
		if (reward.getRewardContent() != null
				&& reward.getRewardContent().length() != 0) {
			sql = "INSERT tb_reward VALUES('" + reward.getRewardContent()
					+ "','','" + reward.getPersonNumber() + "','"
					+ reward.getRewardPs() + "')";
		} else if (reward.getPunishContent() != null
				&& reward.getPunishContent().length() != 0) {
			sql = "INSERT tb_reward VALUES('','" + reward.getPunishContent()
					+ "','" + reward.getPersonNumber() + "','"
					+ reward.getRewardPs() + "')";
		}
		System.out.println(sql);
		try {
			String[] psString = {};
			a = sqlFunction.doSqlUpdate(sql, psString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlFunction.closeAllLink();
		}
		if (a > 0) {
			System.out.println("奖惩信息添加成功");
		} else {
			System.out.println("奖惩信息添加失败");
		}
		return a;
	}

	// 删除奖惩信息记录
	public int DeleteReward(Reward reward) {
		sqlFunction = new SqlFunction();
		String sql = "DELETE tb_reward WHERE RewardID = "
				+ reward.getRewardID();
		int a = 0;
		try {
			String[] psString = {};
			a = sqlFunction.doSqlUpdate(sql, psString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlFunction.closeAllLink();
		}
		if (a > 0) {
			System.out.println("奖惩信息删除成功");
		} else {
			System.out.println("奖惩信息删除失败");
		}
		return a;
	}

	// 修改奖惩信息记录
	public int ModifyReward(Reward reward) {
		int a = 0;
		sqlFunction = new SqlFunction();
		String sql = "UPDATE tb_reward SET RewardContent= ?, PunishContent= ?, "
				+ "PersonNumber= ?, RewardPs = ? WHERE RewardID= ?";
		String[] psString = { reward.getRewardContent(),
				reward.getPunishContent(), reward.getPersonNumber(),
				reward.getRewardPs(), reward.getRewardID() + "" };
		try {
			a = sqlFunction.doSqlUpdate(sql, psString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlFunction.closeAllLink();
		}
		if (a > 0) {
			System.out.println("奖惩信息修改成功");
		} else {
			System.out.println("奖惩信息修改失败");
		}
		return a;
	}

	public List<Reward> list(Reward reward, String[] psString) {
		List<Reward> listReward = new ArrayList<Reward>();
		sqlFunction = new SqlFunction();
		ResultSet rs = null;

		if (psString.length == 0) {
			String sql = "SELECT * FROM Reward_view";
			String[] newPsString = {};
			if (!AdminOrgName.equals("温州商学院")) {
				sql += " WHERE OrgName = '" + AdminOrgName + "'";
			}
			rs = sqlFunction.doSqlSelect(sql, newPsString, false);
		} else {

			String sql = "SELECT * FROM Reward_view WHERE RewardContent LIKE ? AND PunishContent like ? AND PersonNumber LIKE ?";
			if (!AdminOrgName.equals("温州商学院")) {
				sql += " AND OrgName = '" + AdminOrgName + "'";
			}
			rs = sqlFunction.doSqlSelect(sql, psString, true);
		}

		Reward rewardTemp;
		try {
			while (rs.next()) {
				rewardTemp = new Reward();
				rewardTemp.setRewardID(rs.getInt("RewardID"));

				if (rs.getString("RewardContent").length() != 0
						&& rs.getString("RewardContent") != null) {
					rewardTemp.setRewardContent(rs.getString("RewardContent"));
				} else {
					rewardTemp.setRewardContent("");
				}
				if (rs.getString("PunishContent").length() != 0
						&& rs.getString("PunishContent") != null) {
					rewardTemp.setPunishContent(rs.getString("PunishContent"));
				} else {
					rewardTemp.setPunishContent("");
				}

				rewardTemp.setPersonNumber(rs.getString("PersonNumber"));
				if (rs.getString("RewardPs").length() != 0
						&& rs.getString("RewardPs") != null) {
					rewardTemp.setRewardPs(rs.getString("RewardPs"));
				} else {
					rewardTemp.setRewardPs("");
				}
				listReward.add(rewardTemp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlFunction.closeAllLink();
		return listReward;
	}
}
