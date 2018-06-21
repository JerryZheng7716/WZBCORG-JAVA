package other.wzbcOrg; 
/***********************************************************************
 * Module:  AdminMemento.java
 * Author:  jerryzheng
 * Purpose: Defines the Class AdminMemento
 ***********************************************************************/

import java.util.*;
class AdminMemento {
	public AdminLogin adminLogin;

   public AdminMemento(AdminOriginator adminOriginator) {
      this.adminLogin=adminOriginator.getAdminLogin();
   }
   
   public void setAdminLogin(AdminLogin adminLogin) {
      this.adminLogin=adminLogin;
   }

   public AdminLogin getAdminLogin() {
      return adminLogin;
   }

}