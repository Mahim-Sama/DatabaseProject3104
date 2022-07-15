package GUI;

import java.io.IOException;

//import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.*;
import javafx.scene.control.Button;


public class GUI_controller {
    double x = 0,y = 0;
    Stage window;
    Scene scene;


    public void onClickListener(ActionEvent event) {
        LoginController loginController = new LoginController();
        
        try {
            loginController.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage arg0) throws IOException{
        window = arg0;
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/GUI.fxml"));
        scene = new Scene(root);

        arg0.initStyle(StageStyle.DECORATED);
        scene.getStylesheets().add(getClass().getResource("/CSS/CSS.css").toExternalForm());
        //on mouse drag
        root.setOnMousePressed(MouseEvent -> {
            x = MouseEvent.getSceneX();
            y = MouseEvent.getSceneY();
        });
        root.setOnMouseDragged(MouseEvent -> {
            arg0.setX(MouseEvent.getScreenX() - x);
            arg0.setY(MouseEvent.getScreenY() - y);
        });
 
        arg0.setScene(scene);
        arg0.show();
    }
}


