package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import DataBase.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Person_Controller{
    Stage stage5;
    Scene scene5;

    public ChoiceBox<String> cb;
    private String[] BloodGroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    
    public RadioButton malebtn,femalebtn,transbtn;
    public Label savelabel;
    public TextField txt_pname, txt_pFatherName, txt_pMotherName, txt_pAddress, txt_pAge, txt_pFamMembers;

    DBConnection db = new DBConnection();
    
    public void start(Stage arg0) throws IOException {
        stage5 = arg0;
        FXMLLoader fl = new FXMLLoader();
        Parent root = fl.load(getClass().getResource("/GUI/Person.fxml").openStream());
        Person_Controller controller = fl.getController();
        controller.cb.getItems().addAll(BloodGroup);
        scene5 = new Scene(root);
        stage5.setScene(scene5);
        stage5.show();
    }    
    
    public void PersonSave(Event event){ 
        String pname = txt_pname.getText();
        String pFatherName = txt_pFatherName.getText();
        String pMotherName = txt_pMotherName.getText();
        String pAddress = txt_pAddress.getText();
        String pAge = txt_pAge.getText();
        String pFamMembers = txt_pFamMembers.getText();
        String pGender;
        String pBloodGroup = cb.getValue();

        if(malebtn.isSelected()){
            pGender = "Male";
        }else if(femalebtn.isSelected()){
            pGender = "Female";
        }else {
            pGender = "Transgender";
        }

        if(pname != null && pGender!=null && pAge != null){
            try {
                Connection con = db.DatabaseConnect();
                String query = "INSERT INTO \"Person\"(pName,FatherName,MotherName,Address,Age,FamilyMembers,Gender,BloodGroup) VALUES('"+pname+"','"+pFatherName+"','"+pMotherName+"','"+pAddress+"',"+pAge+","+pFamMembers+",'"+pGender+"','"+pBloodGroup+"')";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                savelabel.setText("Saved Successfully!");
            }catch (SQLException e) {
                e.printStackTrace();
                savelabel.setText("Couldn't Save!");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
           savelabel.setText("Please Fill required Fields!");
        }
    }

    public void CreatePersonTable() throws ClassNotFoundException{
        Connection conn = db.DatabaseConnect();
        String sql = "CREATE TABLE \"Person\" " +
                "(Pid int identity(20000000,1) NOT NULL PRIMARY KEY," +
                "pName varchar(50)," +
                "FatherName varchar(50)," +
                "MotherName varchar(50)," +
                "Address varchar(50)," +
                "Age int," +
                "FamilyMembers int,"+
                "Gender varchar(50)," +
                "BloodGroup varchar(50)," +
                ")";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Person Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public void PersonBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void personShow(ActionEvent event){
        Persondataboard_controller dc = new Persondataboard_controller();
        try {
            dc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
