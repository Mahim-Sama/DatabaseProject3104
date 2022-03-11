package GUI;


import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import DataBase.DBConnection;
//import data.personINFO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Persondataboard_controller {
    Stage window10;
    Scene scene10;
    
    public TableView<PersonTable> table;
    public ObservableList<PersonTable> data;

    public TableColumn<PersonTable, Integer> ID;
    public TableColumn<PersonTable,String> name;
    public TableColumn<PersonTable,String> FatherName;
    public TableColumn<PersonTable,String> MotherName;
    public TableColumn<PersonTable,String> Address;
    public TableColumn<PersonTable,Integer> AGE;
    public TableColumn<PersonTable,String> FamilyMember;
    public TableColumn<PersonTable,String> Gender;
    public TableColumn<PersonTable,String> BloodGroup;   

    DBConnection dbc = new DBConnection();

    public void start(Stage arg0) throws IOException {
        window10 = arg0;
        FXMLLoader fl = new FXMLLoader();
        Parent root10 = fl.load(getClass().getResource("/GUI/Persondataboard.fxml").openStream());
        Persondataboard_controller pdc = fl.getController();
        
        //datashow();
        data = FXCollections.observableArrayList();
        try {
            Connection con = dbc.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Person";
            ResultSet rs = st.executeQuery(query);  
            while(rs.next()){
                data.add(new PersonTable(rs.getInt("PiD"), rs.getString("pName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Address"),rs.getInt("Age"),rs.getString("FamilyMembers"),rs.getString("Gender"),rs.getString("BloodGroup")));    
                
            }
            pdc.data = data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        pdc.PersonTableCell();
        
        //end datashow
        scene10 = new Scene(root10);
        window10.setScene(scene10);
        window10.show();
    }


    public void PersonTableCell(){
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        FatherName.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
        MotherName.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("AGE"));
        FamilyMember.setCellValueFactory(new PropertyValueFactory<>("FamilyMember"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        BloodGroup.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
        table.setItems(data);
    }

    

    public void PersondataboardBack(ActionEvent event){
        Person_Controller PC = new Person_Controller();
        try {
            PC.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
