package GUI;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.lang.model.util.ElementScanner6;

import DataBase.DBConnection;
import data.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {
 
    Stage window3;
    Scene scene3;
    Parent root3;

    public TextField txt_username,txt_mail,txt_phone,txt_pass,txt_conpass;
    public Label errorlabel;

    DBConnection db = new DBConnection();

    public void RegisterButtonAction(Event event){
        String uname = txt_username.getText();
        String email = txt_mail.getText();
        String phone = txt_phone.getText();
        String pass = txt_pass.getText();
        String conpass = txt_conpass.getText();
        
        //User user = new User(uname,email,phone,pass);

        if(pass.equals(conpass)){
            try {
                Connection con = db.DatabaseConnect();
                String query = "INSERT INTO \"User\"(username,email,phoneNo,password) VALUES('"+uname+"','"+email+"','"+phone+"','"+pass+"')";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                LoginController loginController = new LoginController();
                try {
                    loginController.start((Stage) ((Button) event.getSource()).getScene().getWindow());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (SQLException e) {
                errorlabel.setText("Couldn't Register Your Account!");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            errorlabel.setText("Password Didn't Match!");
        }
    }

    public void BackButtonAction(ActionEvent event){
        LoginController loginController = new LoginController();
        try {
            loginController.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void start(Stage window3) throws IOException{
        this.window3 = window3;
            root3 = FXMLLoader.load(getClass().getResource("/GUI/Register.fxml"));
            scene3 = new Scene(root3);
            window3.setScene(scene3);
            window3.show();
    }

    public void CreateUserTable() throws ClassNotFoundException{
        
        Connection conn = db.DatabaseConnect();
        String sql = "CREATE TABLE \"User\" " +
                "(Userid int identity(1000,1) NOT NULL PRIMARY KEY," +
                "UserName varchar(50) unique NOT NULL," +
                "Email varchar(50) unique NOT NULL check (email like '_%@_%.%_')," +
                "PhoneNo varchar(50) NOT NULL check(PhoneNo like '01%_' and len(phoneNo) = 11)," +
                "Password varchar(50) NOT NULL check (len(Password) >= 4)," +
                ")";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public void SelectQuery() throws ClassNotFoundException{
        DBConnection db = new DBConnection();
        Connection conn = db.DatabaseConnect();
        
        String sql = "SELECT * FROM \"User\"";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("UserName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertQuery() throws ClassNotFoundException{
        DBConnection db = new DBConnection();
        Connection conn = db.DatabaseConnect();
        
        String sql = "INSERT INTO \"User\" VALUES ('A','A','A','A','A')";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
