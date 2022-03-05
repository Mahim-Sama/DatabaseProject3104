package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Person_Controller {
    Stage stage5;
    Scene scene5;

    public void start(Stage arg0) throws IOException {
        stage5 = arg0;
        Parent root5 = FXMLLoader.load(getClass().getResource("/GUI/Person.fxml"));
        scene5 = new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
    }

    public void PersonBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
