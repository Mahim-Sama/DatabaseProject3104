import GUI.Organization_Controller;
import GUI.Person_Controller;
import GUI.RegisterController;

public class TableCreation {
    public static void main(String[] args) throws ClassNotFoundException {
    RegisterController rg = new RegisterController();
    Person_Controller pc = new Person_Controller();
    Organization_Controller oc = new Organization_Controller();
        try {
            rg.CreateUserTable();
            pc.CreatePersonTable();
            oc.CreateOrgTable();
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
