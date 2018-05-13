package com.yhs.helper;

import java.sql.*;
import com.yhs.helper.*;
public class SqlHelper {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt =null;
	
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=WZBCORG";
	String user = "sa";
	String password = "123456";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			return conn;
		}
	}
	
	public void clossConnection(){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args){
//		SqlHelper sqlHelper = new SqlHelper();
//		try {
//			sqlHelper.getConnection();
//			System.out.println("数据库连接成功");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
}
