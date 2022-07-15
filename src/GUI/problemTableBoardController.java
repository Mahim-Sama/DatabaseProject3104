package GUI;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import DataBase.DBConnection;
import data.ProblemTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class problemTableBoardController {
    Stage window12;
    Scene scene12;

    public TableView<ProblemTable> table;
    private ObservableList<ProblemTable> data;

    public TableColumn<ProblemTable, Integer> ID;
    public TableColumn<ProblemTable,String> victim;
    public TableColumn<ProblemTable,String> problem;
    public TableColumn<ProblemTable,String> PrbStatus; 

    DBConnection dbc = new DBConnection();

    public void start(Stage arg0) throws IOException {
        window12 = arg0;
        FXMLLoader fl = new FXMLLoader();
        Parent root12 = fl.load(getClass().getResource("/GUI/problemTableBoard.fxml").openStream());
        problemTableBoardController otb = fl.getController();
        
        //datashow();

        data = FXCollections.observableArrayList();
        try {
            Connection con = dbc.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Problem";
            ResultSet rs = st.executeQuery(query);  
            while(rs.next()){
                data.add(new ProblemTable(rs.getInt("ID"), rs.getString("victim"),rs.getString("problem"),rs.getString("prbStatus")));    
                
            }
            otb.data = data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        otb.ProbTableCell();
    
        //end datashow
        scene12 = new Scene(root12);
        window12.setScene(scene12);
        window12.show();
    }


    public void ProbTableCell(){
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        victim.setCellValueFactory(new PropertyValueFactory<>("victim"));
        problem.setCellValueFactory(new PropertyValueFactory<>("problem"));
        PrbStatus.setCellValueFactory(new PropertyValueFactory<>("PrbStatus"));
        table.setItems(data);
    }


    
    public void UpdateFromProblem(ActionEvent event){
        ProblemTable pt = table.getSelectionModel().getSelectedItem();
        if(pt == null){
            return;
        }
        ProblemUpdateController pb = new ProblemUpdateController();
        try {
            pb.GetProblemData(pt);
            pb.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteFromProblem(ActionEvent event){
        ProblemTable pt = table.getSelectionModel().getSelectedItem();
        if(pt == null){
            return;
        }
        int id = pt.getID();
        try {
            Connection con = dbc.DatabaseConnect();
            String query = "DELETE FROM Problem WHERE ID = "+id+"";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            data.remove(pt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ProbdataboardBack(ActionEvent event){
        Problem_Controller pc = new Problem_Controller();
        try {
            pc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
