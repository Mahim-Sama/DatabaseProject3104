package GUI;

import java.io.IOException;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import data.User;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    public TextField txtusername,txtemail;
    public PasswordField txtpasswordfield;
    public Label errortxt;

    public void LoginButtonAction(Event event)throws IOException{
        String username =txtusername.getText();
        String email = txtemail.getText();
        String password =txtpasswordfield.getText();

        try {
            User user = User.get_info(email);
            if(user.get_pass().equals(password)){
                System.out.println("");
                useremail = email;
                userObj = user;
                uid = user.get_id();
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
       
        
    }   
        public void RegisterButtonAction(Event event) throws IOException{
            Parent window;
            window = FXMLLoader.load(getClass().getResource("Register.fxml"));
    
            Stage mainStage;
            mainStage = App.parentWindow;
            mainStage.getScene().setRoot(window);
        }
}

        
    }
}
