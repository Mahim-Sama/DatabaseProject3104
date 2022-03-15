package GUI;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DataBase.DBConnection;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    public TextField txt_vName, txt_vOrg, txt_vDesignation, txt_vMail, txt_vContact;

    DBConnection db = new DBConnection();    
    public void start(Stage arg0) throws IOException {
        window8 = arg0;
        FXMLLoader fl = new FXMLLoader();
        Parent root8 = fl.load(getClass().getResource("/GUI/Volunteer.fxml").openStream());
        Volunteer_Cotroller controller = fl.getController();
        controller.cb.getItems().addAll(BloodGroup);
        scene8 = new Scene(root8);
        window8.setScene(scene8);
        window8.show();
    }

    public void VolunteerSave(Event event){
        String vName = txt_vName.getText();
        String vOrg = txt_vOrg.getText();
        String vDesignation = txt_vDesignation.getText();
        String vMail = txt_vMail.getText();
        String vContact = txt_vContact.getText();
        String vGender;
        String vBloodGroup = cb.getValue();
        
        if(malebtn.isSelected()){
            vGender = "Male";
        }else if(femalebtn.isSelected()){
            vGender="Female";
        }else{
            vGender = "Transgender";
        }

        ToggleGroup grp = new ToggleGroup();

        malebtn.setToggleGroup(grp);
        femalebtn.setToggleGroup(grp);
        transbtn.setToggleGroup(grp);

        if(vName.isEmpty()==false && grp.getSelectedToggle() != null && vContact.isEmpty()==false){
            try {
                Connection con = db.DatabaseConnect();
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO Volunteer(vName,vOrganization,vDesignation,vMail,vContact,vGender,vBloodGroup) VALUES('"+vName+"','"+vOrg+"','"+vDesignation+"','"+vMail+"','"+vContact+"','"+vGender+"','"+vBloodGroup+"')";
                stmt.executeUpdate(sql);
                saveLabel.setText("Saved");
            } catch (SQLException ex) {
                ex.printStackTrace();
                saveLabel.setText("Not Saved");
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }else{
            saveLabel.setText("Please fill all the fields");
        }
    }

    public void CreateVolunteerTable() throws ClassNotFoundException{
        Connection conn = db.DatabaseConnect();
        String sql = "CREATE TABLE \"Volunteer\" " +
                "(Vid int identity(50000000,1) NOT NULL PRIMARY KEY," +
                "vName varchar(255)," +
                "vOrganization varchar(255)," +
                "vDesignation varchar(255)," +
                "vMail VARCHAR(255) unique NOT NULL check (vMail like '_%@_%.%_'),"+
                "vContact varchar(255) NOT NULL check(vContact like '01%_' and len(vContact) = 11)," +
                "vGender varchar(255)," +
                "vBloodGroup varchar(255)," +
                ")";
            try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("Volunteer Table created successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }   
    }
    
    public void VolunteerShow(ActionEvent event) throws IOException {
        VolunteerTableController vt = new VolunteerTableController();
        try {
            vt.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void VolunteerBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClearVolunteerScreen(ActionEvent event){
        txt_vName.setText("");
        txt_vOrg.setText("");
        txt_vDesignation.setText("");
        txt_vMail.setText("");
        txt_vContact.setText("");
        malebtn.setSelected(false);
        femalebtn.setSelected(false);
        transbtn.setSelected(false);
        cb.setValue(null);
        saveLabel.setText("");
    }
}
