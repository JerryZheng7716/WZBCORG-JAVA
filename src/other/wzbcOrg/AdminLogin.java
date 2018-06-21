
package other.wzbcOrg;

public class AdminLogin {
	static String adminName="",adminPassword="",adminLevel="高级管理员",orgName="温州商学院",adminOrgCount="";
	 public AdminLogin(String adminName,String adminPassword,String adminLevel,String orgName,String adminOrgCount){
	       this.adminName=adminName;
	       this.adminLevel=adminLevel;
	       this.adminOrgCount=adminOrgCount;
	       this.adminPassword=adminPassword;
	       this.orgName=orgName;
	   }
	public static String getAdminOrgCount() {
		return adminOrgCount;
	}

	public static void setAdminOrgCount(String adminOrgCount) {
		AdminLogin.adminOrgCount = adminOrgCount;
	}

	public static String getAdminName() {
		return adminName;
	}

	public static void setAdminName(String adminName) {
		AdminLogin.adminName = adminName;
	}

	public static String getAdminPassword() {
		return adminPassword;
	}

	public static void setAdminPassword(String adminPassword) {
		AdminLogin.adminPassword = adminPassword;
	}

	public static String getOrgName() {
		return orgName;
	}

	public static void setOrgName(String orgName) {
		AdminLogin.orgName = orgName;
	}

	public static String getAdminLevel() {
		return adminLevel;
	}

	public static void setAdminLevel(String adminLevel) {
		AdminLogin.adminLevel = adminLevel;
	}
}
