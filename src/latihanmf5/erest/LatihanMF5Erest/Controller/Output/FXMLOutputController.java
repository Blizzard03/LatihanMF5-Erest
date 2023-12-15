/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihanmf5.erest.LatihanMF5Erest.Controller.Output;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import latihanmf5.erest.LatihanMF5Erest.Model.Mahasiswa;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLOutputController implements Initializable {
    
    @FXML
    private Label NPM_Label;
    @FXML
    private Label Nama_Label;
    @FXML
    private Label Matakuliah_Label;
    @FXML
    private Button Keluarbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void Keluarklik(ActionEvent event) {
        Alert alt = new Alert(Alert.AlertType.CONFIRMATION, "Anda yakin keluar dari program?", ButtonType.NO, ButtonType.YES);
        alt.showAndWait();
        if (alt.getResult().equals(ButtonType.YES)) {
            System.exit(0);
        }
        
    }
    
    public void getData(Mahasiswa msa) {
        NPM_Label.setText(msa.getNPM());
        Nama_Label.setText(msa.getNama());
        Matakuliah_Label.setText(msa.getMatakuliah());
    }
}
