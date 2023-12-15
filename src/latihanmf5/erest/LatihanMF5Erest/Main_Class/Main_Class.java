/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package latihanmf5.erest.LatihanMF5Erest.Main_Class;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Blizzard
 */
public class Main_Class extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/latihanmf5/erest/LatihanMF5Erest/FXML/Input/FXMLInput.fxml"));
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(final WindowEvent windowEvent) {
                Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Anda yakin ingin keluar dari program ini?", ButtonType.OK, ButtonType.CANCEL);
                al.showAndWait();
                if (al.getResult() == ButtonType.CANCEL) {
                    windowEvent.consume();
                }
            }
        }
        );
        stage.setTitle("Input Forms");
        stage.setScene(scene);
        stage.setIconified(false);
       stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
