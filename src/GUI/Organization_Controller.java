package GUI;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DataBase.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Organization_Controller {
    Stage window7;
    Scene scene7;
    
    public Label label;
    public TextField txt_oName, txt_oAddress, txt_mail, txt_contactNo, txt_DonationType;

    DBConnection db = new DBConnection();

    public void start(Stage arg0) throws IOException {
        window7 = arg0;
        Parent root7 = FXMLLoader.load(getClass().getResource("/GUI/Organization.fxml"));
        scene7 = new Scene(root7);
        window7.setScene(scene7);
        window7.show();
    }

    public void OrgSave(Event event){
        String oName = txt_oName.getText();
        String oAddress = txt_oAddress.getText();
        String mail = txt_mail.getText();
        String contactNo = txt_contactNo.getText();
        String DonationType = txt_DonationType.getText();

        if(oName.isEmpty() == false && oAddress.isEmpty() == false && mail.isEmpty() == false && contactNo.isEmpty() == false && DonationType.isEmpty() == false){
            try {
                Connection con = db.DatabaseConnect();
                String query = "INSERT INTO \"Organization\"(OrgName,Address,mail,contactNO,donationType) VALUES('"+oName+"','"+oAddress+"','"+mail+"','"+contactNo+"','"+DonationType+"')";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                label.setText("Saved Successfully!");
            }catch (SQLException e) {
                e.printStackTrace();
                label.setText("Couldn't Save!");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
           label.setText("Please Fill required Fields!");
        }
    }

    
    public void CreateOrgTable() throws ClassNotFoundException {
        Connection con = db.DatabaseConnect();
        String sql = "CREATE TABLE \"Organization\" " +
                "(Oid int identity(30000,1) NOT NULL PRIMARY KEY," +
                "OrgName varchar(50)," +
                "Address varchar(50)," +
                "mail varchar(255) unique NOT NULL check (mail like '_%@_%.%_')," +
                "contactNo varchar(50) NOT NULL check(contactNo like '01%_' and len(contactNo) = 11)," +
                "donationType varchar(100)," +
                ")";

            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("Organization Table created successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }   

    }
    
    public void OrgBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClearOrganizationScreen(ActionEvent event){
        txt_oName.setText("");
        txt_oAddress.setText("");
        txt_mail.setText("");
        txt_contactNo.setText("");
        txt_DonationType.setText("");
        label.setText("");
    }

    public void ShowOrgTable(ActionEvent event){
        
        OrganizationTableBoardController otb = new OrganizationTableBoardController();
        try {
            otb.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
