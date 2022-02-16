import GUI.RegisterController;

public class TableCreation {
    public static void main(String[] args) throws ClassNotFoundException {
    RegisterController rg = new RegisterController();
        try {
            rg.CreateUserTable();
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
