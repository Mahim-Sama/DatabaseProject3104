package GUI;
    
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.Action;

import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import data.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class LoginController {

  /*  public TextField txtusername,txtemail;
    public PasswordField txtpasswordfield;
    public Label errortxt;

    User user = new User();

    public void LoginButtonAction(Event event)throws IOException{
        String username =txtusername.getText();
        String email = txtemail.getText();
        String password =txtpasswordfield.getText();

        try {
            user.get_id(email);
            if(user.get_pass().equals(password)){
                System.out.println("");
                user.useremail = email;
                user.userObj = user;
                user.uid = user.get_id();
                Parent window;
                window = FXMLLoader.load(getClass().getResource(""));

                Stage mainStage;
                mainStage = App.parentWindow;
                mainStage.getScene().setRoot(window);

            }
            else{
                errortxt.setText("Wrong username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errortxt.setText(e.getMessage());
        }
    }
       
        
  
        public void RegisterButtonAction(Event event) throws IOException{
            Parent window;
            window = FXMLLoader.load(getClass().getResource("Register.fxml"));
    
            Stage mainStage;
            mainStage = App.parentWindow;
            mainStage.getScene().setRoot(window);
        }*/

        Stage window2;
        Scene scene2;
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
