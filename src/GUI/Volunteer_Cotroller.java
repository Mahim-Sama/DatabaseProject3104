package GUI;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Volunteer_Cotroller {
    Stage window8;
    Scene scene8;

    public void start(Stage arg0) throws IOException {
        window8 = arg0;
        Parent root8 = FXMLLoader.load(getClass().getResource("/GUI/Volunteer.fxml"));
        scene8 = new Scene(root8);
        window8.setScene(scene8);
        window8.show();
    }

    public void VolunteerBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
