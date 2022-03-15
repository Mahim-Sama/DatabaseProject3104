package GUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import DataBase.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class PersonUpdateController {
    Stage stage16;
    Scene scene16;
    
    public ChoiceBox<String> cb;
    private String[] BloodGroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    
    public RadioButton malebtn,femalebtn,transbtn;
    public TextField txt_pname, txt_pFatherName, txt_pMotherName, txt_pAddress, txt_pAge, txt_pFamMembers;
    
    DBConnection db = new DBConnection();

    public PersonTable PT;
    public void GetPersonData(PersonTable PT){
        this.PT = PT;
    }
    
    public void start(Stage arg0) throws IOException {
        stage16 = arg0;
        FXMLLoader fl = new FXMLLoader();
        Parent root = fl.load(getClass().getResource("/GUI/PersonUpdate.fxml").openStream());
        PersonUpdateController puc = fl.getController();

        ToggleGroup grp = new ToggleGroup();
        puc.malebtn.setToggleGroup(grp);
        puc.femalebtn.setToggleGroup(grp);
        puc.transbtn.setToggleGroup(grp);
        
        puc.cb.getItems().addAll(BloodGroup);
        puc.PT = PT;
        puc.txt_pname.setText(PT.getName());
        puc.txt_pFatherName.setText(PT.getFatherName());
        puc.txt_pMotherName.setText(PT.getMotherName());
        puc.txt_pAddress.setText(PT.getAddress());
        puc.txt_pAge.setText(String.valueOf(PT.getAGE()));
        puc.txt_pFamMembers.setText(PT.getFamilyMember());
        puc.cb.setValue(PT.getBloodGroup());
        if(PT.getGender().equals("Transgender")){
            puc.transbtn.setSelected(true);
        }else if(PT.getGender().equals("Female")){
            puc.femalebtn.setSelected(true);
        }else{
            puc.malebtn.setSelected(true);
        }

        scene16 = new Scene(root);
        stage16.setScene(scene16);
        stage16.show();
    }
    
    public void UpdateSaveButton(ActionEvent event){
        String Gender;
        if(malebtn.isSelected()){
            Gender = "Male";
        }else if(femalebtn.isSelected()){
            Gender = "Female";
        }else{
            Gender = "Transgender";
        }
        try {
            Connection con = db.DatabaseConnect();
            Statement st = con.createStatement();
            String query = "UPDATE Person SET pName = '"+txt_pname.getText()+"', fatherName = '"+txt_pFatherName.getText()+"', motherName = '"+txt_pMotherName.getText()+"', address = '"+txt_pAddress.getText()+"', age = "+txt_pAge.getText()+", familyMembers = '"+txt_pFamMembers.getText()+"', bloodGroup = '"+cb.getValue()+"', gender  = '"+Gender+"' where pid = " + PT.getID();    
            st.executeUpdate(query);
            Persondataboard_controller pc = new Persondataboard_controller();
            try {
                pc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateBackButton(ActionEvent event){
        Persondataboard_controller pc = new Persondataboard_controller();
        try {
            pc.start((Stage) ((Button) event.getSource()).getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClearPersonUpdateScreen(ActionEvent event){
        txt_pname.setText("");
        txt_pFatherName.setText("");
        txt_pMotherName.setText("");
        txt_pAddress.setText("");
        txt_pAge.setText("");
        txt_pFamMembers.setText("");
        malebtn.setSelected(false);
        femalebtn.setSelected(false);
        transbtn.setSelected(false);
        cb.setValue(null);
    }
}
