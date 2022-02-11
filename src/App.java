
import DataBase.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.fxml.FXML;
import javafx.stage.StageStyle;

public class App extends Application {
    
    public static void main(String[] args) throws ClassNotFoundException {
        DBConnection dbc = new DBConnection();
        dbc.DatabaseConnect();
        dbc.DisconnectDB();
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/GUI.fxml"));
        Scene scene = new Scene(root);
        arg0.initStyle(StageStyle.DECORATED);
        scene.getStylesheets().add(getClass().getResource("/CSS/CSS.css").toExternalForm());
        arg0.setScene(scene);
        arg0.show();
    }
    
}

