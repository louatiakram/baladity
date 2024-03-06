package edu.esprit.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainGuiController {

    @FXML
    private Button BTNGestionAct;
    @FXML
    private BorderPane MainAnchorPaneBaladity;

    @FXML
    private BorderPane SecondBorderPane;

    @FXML
    private VBox MainLeftSidebar;

    private boolean isSidebarVisible = true;

    @FXML
    void BTNToggleSidebar(ActionEvent event) {
        TranslateTransition sideBarTransition = new TranslateTransition(Duration.millis(200), MainLeftSidebar);

        double sidebarWidth = 308;
        double hiddenWidth = 0; // Width when sidebar is hidden

        if (isSidebarVisible) {
            // Hide sidebar
            sideBarTransition.setToX(-sidebarWidth);
            isSidebarVisible = false;
            // Set the width of the MainLeftSidebar when sidebar is hidden
            MainLeftSidebar.setPrefWidth(hiddenWidth);
            // Set the width of the SecondBorderPane when sidebar is hidden
            SecondBorderPane.setPrefWidth(SecondBorderPane.getWidth() + sidebarWidth);
        } else {
            // Show sidebar
            sideBarTransition.setToX(0);
            isSidebarVisible = true;
            // Set the width of the MainLeftSidebar back to its original value
            MainLeftSidebar.setPrefWidth(MainLeftSidebar.getWidth() + sidebarWidth);
            // Set the width of the SecondBorderPane back to its original value
            SecondBorderPane.setPrefWidth(SecondBorderPane.getWidth() - sidebarWidth);
        }

        sideBarTransition.play();
    }


    public void BTNGestionEvennement(ActionEvent actionEvent) {
        try {
            System.out.println("Resource URL: " + getClass().getResource("/AjouterActualiteGui.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/AjouterActualiteGui.fxml"));
            BTNGestionAct.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry");
            alert.setTitle("Error");
            alert.show();
        }
    }

    public void BTNGestionUser(ActionEvent actionEvent) {
    }

    public void BTNGestionRec(ActionEvent actionEvent) {
    }

    public void BTNGestionAct(ActionEvent actionEvent) {
        try {
            System.out.println("Resource URL: " + getClass().getResource("/AfficherActualiteGui.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/AfficherActualiteGui.fxml"));
            BTNGestionAct.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry");
            alert.setTitle("Error");
            alert.show();
        }
    }

    public void BTNGestionEquipement(ActionEvent actionEvent) {
    }

    public void BTNGestionTache(ActionEvent actionEvent) {

    }
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void BTNGestionReclamation(ActionEvent actionEvent) {

    }
}
