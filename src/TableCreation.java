import GUI.Person_Controller;
import GUI.RegisterController;

public class TableCreation {
    public static void main(String[] args) throws ClassNotFoundException {
    RegisterController rg = new RegisterController();
    Person_Controller pc = new Person_Controller();
        try {
            rg.CreateUserTable();
            pc.CreatePersonTable();
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
