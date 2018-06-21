package other.wzbcOrg; 
/***********************************************************************
 * Module:  AdminOriginator.java
 * Author:  jerryzheng
 * Purpose: Defines the Class AdminOriginator
 ***********************************************************************/

import java.util.*;

/** @pdOid 9b64ee2b-c2de-42ad-9958-ec27212493b1 */
public class AdminOriginator {
   /** @pdOid 3a7488f2-57b6-49e9-b4c9-d08e5a6aad16 */
   private AdminLogin adminLogin;
   
   /** @param adminLogin
    * @pdOid 5357ecec-c4fe-45e8-81fc-6371904e5dfb */
   public AdminOriginator(AdminLogin adminLogin) {
      this.adminLogin=adminLogin;
   }
   
   /** @pdOid 683ef34a-63b3-4a6b-9f18-704ab89c4289 */
   public AdminMemento createMemento() {
      return new AdminMemento(this);

   }
   
   /** @param memento
    * @pdOid 4d181660-1471-4607-bf8a-c08169df7f64 */
   public void restoreMemento(AdminMemento memento) {
      adminLogin=memento.getAdminLogin();
   }
   
   /** @param adminLogin
    * @pdOid 8f52a2ff-d956-4d61-874d-a28782d3dd7f */
   public void setAdminLogin(AdminLogin adminLogin) {
      this.adminLogin=adminLogin;
   }
   
   /** @pdOid 5f6a2049-fbd5-4da2-9e51-ec816ff50d53 */
   public AdminLogin getAdminLogin() {
      return this.adminLogin;
   }

}