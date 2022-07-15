package GUI;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.control.Label;
import DataBase.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Problem_Controller {
    Stage window6;
    Scene scene6;
    public Label label_l;
    public TextField txt_victim, txt_problem, txt_PrbStatus;

    DBConnection db = new DBConnection();

    public void start(Stage arg0) throws IOException {
        window6 = arg0;
        Parent root6 = FXMLLoader.load(getClass().getResource("/GUI/Problem.fxml"));
        scene6 = new Scene(root6);
        window6.setScene(scene6);
        window6.show();
    }

    public void SaveProblem(Event event){
        String victim = txt_victim.getText();
        String problem = txt_problem.getText();
        String prbStatus = txt_PrbStatus.getText();

        if(victim.isEmpty() == false && problem.isEmpty() == false && prbStatus.isEmpty() == false){
            try {
                Connection con = db.DatabaseConnect();
                String query = "INSERT INTO \"Problem\"(victim,problem,prbStatus) VALUES('"+victim+"','"+problem+"','"+prbStatus+"')";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                label_l.setText("Saved Successfully!");
            }catch (SQLException e) {
                e.printStackTrace();
                label_l.setText("Couldn't Save!");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            label_l.setText("Please Fill required Fields!");
        }
    }

    public void CreateProblemtable()throws ClassNotFoundException{
        Connection con = db.DatabaseConnect();
        String sql = "CREATE TABLE \"Problem\" (" +
                "    ID INT identity(400000,1) NOT NULL primary key," +
                "    victim VARCHAR(255) NOT NULL," +
                "    problem VARCHAR(255) NOT NULL," +
                "    prbStatus VARCHAR(255) NOT NULL" +
                ");";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Problem Table Created Sucessfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }

    public void showPrbtable(ActionEvent event){
        problemTableBoardController ptb = new problemTableBoardController();
        try {
            ptb.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearProbTable(ActionEvent event){
        txt_victim.setText("");
        txt_problem.setText("");
        txt_PrbStatus.setText("");
        label_l.setText("");
    }

    public void ProblemBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
