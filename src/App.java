import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.fxml.FXML;
import javafx.stage.StageStyle;

public class App extends Application {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try {
            String dbUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=password123;databaseName=RefugeeManagementSystem";
            connection = DriverManager.getConnection(dbUrl);
            if(connection!=null){
                System.out.println("***Connected***");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }finally{
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/GUI.fxml"));
        Scene scene = new Scene(root);
        arg0.initStyle(StageStyle.DECORATED);
        scene.getStylesheets().add(getClass().getResource("/CSS/CSS.css").toExternalForm());
        arg0.setScene(scene);
        arg0.show();
    }
    
}
