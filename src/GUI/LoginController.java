package GUI;

import java.io.IOException;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import DataBase.DBConnection;
import data.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    Stage window2;
    Scene scene2;
    
    public TextField txt_username,txt_pass;
    public Label errorlabel_1;
    DBConnection db = new DBConnection();
    User user = new User();

    public void LogIN(Event event) {

        String uname = txt_username.getText();
        String pass = txt_pass.getText();
        try {
            String query = "SELECT * FROM \"User\" where username = '"+uname+"'";
            Connection con = db.DatabaseConnect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            user.setUserid(rs.getInt("userid"));
            user.setName(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPass(rs.getString("password"));
            user.setPhone(rs.getString("phoneNo"));

            if(pass.equals(user.getPass())){
                DashboardController dashboardControler = new DashboardController();
                try {
                    dashboardControler.start((Stage) ((Button) event.getSource()).getScene().getWindow());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                errorlabel_1.setText("Wrong Password!");
            }
        } catch (SQLException e) {
            errorlabel_1.setText("!User Not Found!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }   
    }
    public void start(Stage window2) throws IOException{
        this.window2 = window2;
        Parent root1 = FXMLLoader.load(getClass().getResource("/GUI/LogIN.fxml"));
        scene2 = new Scene(root1);
        window2.setScene(scene2);
        window2.show(); 
    }

    public void RegisterAction(ActionEvent event){
        RegisterController RG = new RegisterController();
        
        try{
            RG.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
