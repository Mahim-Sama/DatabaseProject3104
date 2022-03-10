package GUI;


import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import DataBase.DBConnection;
import data.personINFO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Persondataboard_controller {
    Stage window10;
    Scene scene10;
    VBox vbox;
    
    private TableView<personINFO> table;
    public ObservableList<personINFO> data;

    private TableColumn<?,?> name;
    private TableColumn<?,?> FatherName;
    private TableColumn<?,?> MotherName;
    private TableColumn<?,?> Address;
    private TableColumn<?,?> AGE;
    private TableColumn<?,?> FamilyMember;
    private TableColumn<?,?> Gender;
    private TableColumn<?,?> BloodGroup;   

    DBConnection dbc = new DBConnection();

    public void DataShow(){
        data = FXCollections.observableArrayList();
        PersonTableCell();

        try {
            Connection con = dbc.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Person";
            ResultSet rs = st.executeQuery(query);
            // need to fix the Gender dilemma.  
            while(rs.next()){
                data.add(new personINFO(rs.getString("pName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Address"),rs.getInt("Age"),rs.getInt("FamilyMembers"),/*rs.getString("Gender"),*/rs.getString("BloodGroup")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(data);
    }

    private void PersonTableCell(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        FatherName.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
        MotherName.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("AGE"));
        FamilyMember.setCellValueFactory(new PropertyValueFactory<>("FamilyMember"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        BloodGroup.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
    }
    
    public void start(Stage arg0) throws IOException {
        window10 = arg0;
        Parent root10 = FXMLLoader.load(getClass().getResource("/GUI/Persondataboard.fxml"));
        scene10 = new Scene(root10);
        window10.setScene(scene10);
        window10.show();
    }

    public void PersondataboardBack(ActionEvent event){
        DashboardController DC = new DashboardController();
        try {
            DC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
