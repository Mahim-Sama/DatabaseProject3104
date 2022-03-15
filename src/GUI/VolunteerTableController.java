package GUI;


import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import DataBase.DBConnection;
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

public class VolunteerTableController {
    Stage stage13;
    Scene scene13;

    public TableView<VolunteerTableConstructor> table;
    private ObservableList<VolunteerTableConstructor> data;

    public TableColumn<VolunteerTableConstructor, Integer> ID;
    public TableColumn<VolunteerTableConstructor,String> vName;
    public TableColumn<VolunteerTableConstructor,String> vOrg;
    public TableColumn<VolunteerTableConstructor,String> vDesignation;
    public TableColumn<VolunteerTableConstructor,String> vMail;
    public TableColumn<VolunteerTableConstructor,String> vContact;
    public TableColumn<VolunteerTableConstructor,String> vGender;
    public TableColumn<VolunteerTableConstructor,String> vBloodGroup;

    DBConnection dbc = new DBConnection();

    public void start(Stage arg0) throws IOException{
        stage13 = arg0;

        FXMLLoader fl = new FXMLLoader();
        Parent root13 = fl.load(getClass().getResource("/GUI/VolunteerTable.fxml").openStream());
        VolunteerTableController vtc = fl.getController();

        //datashow();
        data = FXCollections.observableArrayList();
        try {
            Connection con = dbc.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "SELECT * FROM Volunteer";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                data.add(new VolunteerTableConstructor(rs.getInt("ViD"), rs.getString("vName"),rs.getString("vOrganization"),rs.getString("vDesignation"),rs.getString("vMail"),rs.getString("vContact"),rs.getString("vGender"),rs.getString("vBloodGroup")));
            }
            vtc.data = data;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(data.get(0).getvBloodGroup());
        //end of datashow();

        vtc.VolunteerTableCell();

        scene13 = new Scene(root13);
        stage13.setScene(scene13);
        stage13.show();
    }

    public void VolunteerTableCell(){
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        vName.setCellValueFactory(new PropertyValueFactory<>("vName"));
        vOrg.setCellValueFactory(new PropertyValueFactory<>("vOrg"));
        vDesignation.setCellValueFactory(new PropertyValueFactory<>("vDesignation"));
        vMail.setCellValueFactory(new PropertyValueFactory<>("vMail"));
        vContact.setCellValueFactory(new PropertyValueFactory<>("vContact"));
        vGender.setCellValueFactory(new PropertyValueFactory<>("vGender"));
        vBloodGroup.setCellValueFactory(new PropertyValueFactory<>("vBloodGroup"));
        table.setItems(data);
    }

    public void VolunteerBack(ActionEvent event){
        try {
            Volunteer_Cotroller vc = new Volunteer_Cotroller();
            vc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
