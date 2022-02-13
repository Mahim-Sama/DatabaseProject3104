package GUI;

<<<<<<< HEAD
public class RegisterController {
=======
import java.io.IOException;
import java.sql.SQLException;

import javax.lang.model.util.ElementScanner6;

import data.User;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;




import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    public TextField username,aemail,phoneno;
    public PasswordField passfield,confirmpassfield;
    public Label errorlabel;

    public void BackButtonAction(Event event)throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("LogIN.fxml"));

        Stage mainStage;
        mainStage =App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void RegisterButtonAction(Event event)throws IOException{
        String name = username.getText();
        String email = aemail.getText();
        String phone = phoneno.getText();
        String password = passfield.getText();
        String confirmpass = confirmpassfield.getText();

        if(password.equals(confirmpass))
        {
            User user = new User (name,email,phone,password);
            try{
                user.insert();
                errorlabel.setText("Successfully Register Your Account!");
                Parent window;
                window =  FXMLLoader.load(getClass().getResource("LogIN.fxml"));

                Stage mainStage;
                mainStage =App.parentWindow;
                mainStage.getScene().setRoot(window);

            }catch(SQLException e ){
                e.printStackTrace();
                errorlabel.setText(e.getMessage());
            }
        }
         else {
            errorlabel.setText("Wrong Password!");
        }

    }
>>>>>>> 5276791506759066cc8492f4be63341502d99438
    
}
