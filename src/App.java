
import DataBase.DBConnection;
import GUI.GUI_controller;
import GUI.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
//import javafx.fxml.FXML;
import javafx.stage.*;

import java.util.*;

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

