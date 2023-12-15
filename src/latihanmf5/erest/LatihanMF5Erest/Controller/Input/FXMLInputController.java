/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihanmf5.erest.LatihanMF5Erest.Controller.Input;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import latihanmf5.erest.LatihanMF5Erest.Controller.Output.FXMLOutputController;
import latihanmf5.erest.LatihanMF5Erest.Model.Mahasiswa;

/**
 *
 * @author Blizzard
 */
public class FXMLInputController implements Initializable {

    Mahasiswa ms = new Mahasiswa();

    @FXML
    private TextField Nama_txt;
    @FXML
    private TextField txt_matakuliah;
    @FXML
    private TextField txtNPM;
    @FXML
    private Button Submit_btn;
    @FXML
    private Button Reset_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Submit_klik(ActionEvent event) {
        if (txtNPM.getText().isEmpty() || txt_matakuliah.getText().isEmpty() || Nama_txt.getText().isEmpty()) {
            Alert alt = new Alert(Alert.AlertType.WARNING, "Data Kosong, Mohon isi terlebih dahulu", ButtonType.OK);
            alt.showAndWait();
            if (alt.getResult().equals(ButtonType.OK)) {
                Nama_txt.isFocused();
            }
        } else {
            ms.setNama(Nama_txt.getText());
            ms.setNPM(txtNPM.getText());
            ms.setMatakuliah(txt_matakuliah.getText());
            try {
                FXMLLoader Muat = new FXMLLoader(getClass().getResource("/latihanmf5/erest/LatihanMF5Erest/FXML/Output/FXMLOutput.fxml"));
                Parent ortu = (Parent) Muat.load();
                FXMLOutputController Output = (FXMLOutputController) Muat.getController();
                Output.getData(ms);
                Scene peragaan = new Scene(ortu);
                Stage panggung = new Stage();
                panggung.setResizable(false);
                panggung.setIconified(false);
                panggung.setTitle("Nilai Akhir");
                panggung.setScene(peragaan);
                panggung.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(final WindowEvent windowEvent) {
                        Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Anda yakin ingin keluar dari program ini?", ButtonType.OK, ButtonType.CANCEL);
                        al.showAndWait();
                        if (al.getResult() == ButtonType.CANCEL) {
                            windowEvent.consume();
                        }
                    }
                }
                );
                panggung.show();
            } catch (IOException E) {
                E.printStackTrace();
            }
        }
    }

    @FXML
    private void Resetklik(ActionEvent event) {
        Alert alt = new Alert(Alert.AlertType.WARNING, "Anda yakin Data ini akan dihapus?", ButtonType.OK);
        alt.showAndWait();
        if (alt.getResult().equals(ButtonType.OK)) {
            Nama_txt.setText("");
            txt_matakuliah.setText("");
            txtNPM.setText("");
        }
    }

}
