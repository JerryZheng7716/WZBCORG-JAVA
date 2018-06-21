package other.wzbcOrg; 
import java.util.*;

public class LoginCaretaker {

	public static AdminMemento adminMemento;

   public static AdminMemento getAdminMemento() {
      return adminMemento;
   }

   public static void setAdminMemento(AdminMemento adminMemento) {
      LoginCaretaker.adminMemento = adminMemento;
   }

}