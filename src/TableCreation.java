import GUI.Organization_Controller;
import GUI.Person_Controller;
import GUI.Problem_Controller;
import GUI.RegisterController;

public class TableCreation {
    public static void main(String[] args) throws ClassNotFoundException {
    RegisterController rg = new RegisterController();
    Person_Controller pc = new Person_Controller();
    Organization_Controller oc = new Organization_Controller();
    Problem_Controller prc = new Problem_Controller();
        try {
            rg.CreateUserTable();
            pc.CreatePersonTable();
            oc.CreateOrgTable();
            prc.CreateProblemtable();
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
