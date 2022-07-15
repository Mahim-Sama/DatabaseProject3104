package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class DashboardController {

    Stage window4;
    Scene scene4;

    public void PersonButtonAction(ActionEvent event){
        Person_Controller PS = new Person_Controller();
        try {
            PS.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void OrganizationButtonAction(ActionEvent event)
    {
        Organization_Controller OS = new Organization_Controller();
        try {
            OS.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void VolunterButtonAction(ActionEvent event)
    {
        Volunteer_Cotroller VS = new Volunteer_Cotroller();
        try {
            VS.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  ProblemButtonAction(ActionEvent event)
    {
        Problem_Controller PS = new Problem_Controller();
        try {
            PS.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void DashBackAction(ActionEvent event)
    {
        LoginController LG = new LoginController();
        try {
            LG.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage arg0) throws IOException{
        window4 = arg0;
        Parent root4 = FXMLLoader.load(getClass().getResource("/GUI/dashboard.fxml"));
        scene4 = new Scene(root4);
        window4.setScene(scene4);
        window4.show();
    }
}
