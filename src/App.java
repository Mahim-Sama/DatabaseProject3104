
import DataBase.DBConnection;
import GUI.GUI_controller;
import javafx.application.Application;
import javafx.stage.*;

public class App extends Application {
    public static void main(String[] args) throws ClassNotFoundException {
        DBConnection dbc = new DBConnection();
        dbc.DatabaseConnect();
        
        launch(args);
        
        dbc.DisconnectDB(); 
    }

    @Override
    public void start(Stage arg0) throws Exception {
        GUI_controller gui = new GUI_controller();
        gui.start(arg0);
    }
 
}

