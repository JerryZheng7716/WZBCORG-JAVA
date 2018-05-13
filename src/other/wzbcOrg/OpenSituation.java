package other.wzbcOrg;

public class OpenSituation {
	static boolean OpenAdminChange=false,OpenAdminManage=false,OpenDepartManage=false,
	openSpecialty=false,openPersonManage=false,openMessgeSearch=false;

	public static boolean isOpenMessgeSearch() {
		return openMessgeSearch;
	}

	public static void setOpenMessgeSearch(boolean openMessgeSearch) {
		OpenSituation.openMessgeSearch = openMessgeSearch;
	}

	public static boolean isOpenPersonManage() {
		return openPersonManage;
	}

	public static void setOpenPersonManage(boolean openPersonManage) {
		OpenSituation.openPersonManage = openPersonManage;
	}

	public static boolean isOpenSpecialty() {
		return openSpecialty;
	}

	public static void setOpenSpecialty(boolean openSpecialty) {
		OpenSituation.openSpecialty = openSpecialty;
	}

	public static boolean isOpenAdminManage() {
		return OpenAdminManage;
	}

	public static boolean isOpenDepartManage() {
		return OpenDepartManage;
	}

	public static void setOpenDepartManage(boolean openDepartManage) {
		OpenDepartManage = openDepartManage;
	}

	public static boolean DepartManage () {
		return OpenAdminManage;
	}

	public static void setOpenAdminManage(boolean openAdminManage) {
		OpenAdminManage = openAdminManage;
	}

	public static  boolean isOpenAdminChange() {
		return OpenAdminChange;
	}

	public static  void setOpenAdminChange(boolean openAdminChange) {
		OpenAdminChange = openAdminChange;
	}
}
