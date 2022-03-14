package GUI;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Volunteer_Cotroller {
    Stage window8;
    Scene scene8;

    public ChoiceBox<String> cb;
    private String[] BloodGroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    
    public RadioButton malebtn,femalebtn,transbtn;
    public Label saveLabel;
    public TextField txt_vName, txt_vOrgName, txt_vDesignation, txt_vEmail, txt_vContact;

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
