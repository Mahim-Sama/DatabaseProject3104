package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Organization_Controller {
    Stage window7;
    Scene scene7;
    
    public void start(Stage arg0) throws IOException {
        window7 = arg0;
        Parent root7 = FXMLLoader.load(getClass().getResource("/GUI/Organization.fxml"));
        scene7 = new Scene(root7);
        window7.setScene(scene7);
        window7.show();
    }

    public void OrgBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
