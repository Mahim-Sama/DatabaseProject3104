package GUI;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import DataBase.DBConnection;
import data.OrganizationTable;
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


public class OrganizationTableBoardController {
    Stage window11;
    Scene scene11;

    public TableView<OrganizationTable> table;
    private ObservableList<OrganizationTable> data;

    public TableColumn<OrganizationTable, Integer> ID;
    public TableColumn<OrganizationTable,String> name;
    public TableColumn<OrganizationTable,String> Address;
    public TableColumn<OrganizationTable,String> mail;
    public TableColumn<OrganizationTable,String> contactNo;
    public TableColumn<OrganizationTable,String> donationType;   

    DBConnection dbc = new DBConnection();

    public void start(Stage arg0) throws IOException {
        window11 = arg0;
        //Parent root11 = FXMLLoader.load(getClass().getResource("/GUI/OrganizationTableBoard.fxml"));
        FXMLLoader fl = new FXMLLoader();
        Parent root11 = fl.load(getClass().getResource("/GUI/OrganizationTableBoard.fxml").openStream());
        OrganizationTableBoardController otb = fl.getController();
        
        //datashow();

        data = FXCollections.observableArrayList();
        try {
            Connection con = dbc.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Organization";
            ResultSet rs = st.executeQuery(query);  
            while(rs.next()){
                data.add(new OrganizationTable(rs.getInt("Oid"), rs.getString("OrgName"),rs.getString("Address"),rs.getString("mail"),rs.getString("contactNo"),rs.getString("donationType")));    
                
            }
            // System.out.println(data.get(0).getName());
            // System.out.println(data.get(0).getContact());
            otb.data = data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        otb.OrgTableCell();
    
        //end datashow
        scene11 = new Scene(root11);
        window11.setScene(scene11);
        window11.show();
    }


    public void OrgTableCell(){
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        contactNo.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        donationType.setCellValueFactory(new PropertyValueFactory<>("donationType"));
        table.setItems(data);
    }

    

    public void OrgdataboardBack(ActionEvent event){
        Organization_Controller oc = new Organization_Controller();
        try {
            oc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
