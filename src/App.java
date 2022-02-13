
import DataBase.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
//import javafx.fxml.FXML;
import javafx.stage.StageStyle;
import java.util.*;

public class App extends Application {
    double x = 0,y = 0;

    public static void main(String[] args) throws ClassNotFoundException {
        DBConnection dbc = new DBConnection();
        dbc.DatabaseConnect();
        launch(args);
        dbc.DisconnectDB();
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/GUI.fxml"));
        Scene scene = new Scene(root);
        arg0.initStyle(StageStyle.DECORATED);
        scene.getStylesheets().add(getClass().getResource("/CSS/CSS.css").toExternalForm());
        
        root.setOnMousePressed(MouseEvent -> {
            x = MouseEvent.getSceneX();
            y = MouseEvent.getSceneY();
        });
        root.setOnMouseDragged(MouseEvent -> {
            arg0.setX(MouseEvent.getScreenX() - x);
            arg0.setY(MouseEvent.getScreenY() - y);
        });
 
        arg0.setScene(scene);
        arg0.show();
    }
    
}

