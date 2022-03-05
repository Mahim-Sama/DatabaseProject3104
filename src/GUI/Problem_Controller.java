package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Problem_Controller {
    Stage window6;
    Scene scene6;
    
    public void start(Stage arg0) throws IOException {
        window6 = arg0;
        Parent root6 = FXMLLoader.load(getClass().getResource("/GUI/Problem.fxml"));
        scene6 = new Scene(root6);
        window6.setScene(scene6);
        window6.show();
    }
    public void ProblemBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
