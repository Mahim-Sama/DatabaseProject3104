package GUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import DataBase.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ProblemUpdateController {
    Stage stage15;
    Scene scene15;

    public TextField txt_victim, txt_problem, txt_PrbStatus;
    public ProblemTable pt;
    DBConnection  db = new DBConnection();

    
    public void GetProblemData(ProblemTable pt){
        this.pt = pt;
    }

    public void start(Stage arg0)throws IOException{
        stage15 = arg0;
        //Parent root15 = FXMLLoader.load(getClass().getResource("/GUI/ProblemUpdate.fxml"));
        FXMLLoader fl = new FXMLLoader();
        Parent root15 = fl.load(getClass().getResource("/GUI/ProblemUpdate.fxml").openStream());
        ProblemUpdateController pb = fl.getController(); 
        
        pb.txt_victim.setText(pt.getVictim());
        pb.txt_problem.setText(pt.getProblem());
        pb.txt_PrbStatus.setText(pt.getPrbStatus());

        pb.pt = pt;
        scene15 = new Scene(root15);
        stage15.setScene(scene15);
        stage15.show();
    }

    public void SaveButton(ActionEvent event){
        try {
            Connection con = db.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "UPDATE Problem SET victim = '"+txt_victim.getText()+"', problem = '"+txt_problem.getText()+"', prbStatus = '"+txt_PrbStatus.getText()+"' WHERE ID = "+pt.getID();
            st.executeUpdate(query);
            problemTableBoardController pb = new problemTableBoardController();
            try {
                pb.start((Stage) ((Button) event.getSource()).getScene().getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateBack(ActionEvent event){
        problemTableBoardController pb = new problemTableBoardController();
        try {
            pb.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearProbUpdateTable(ActionEvent event){
        txt_victim.setText("");
        txt_problem.setText("");
        txt_PrbStatus.setText("");
    }
}
