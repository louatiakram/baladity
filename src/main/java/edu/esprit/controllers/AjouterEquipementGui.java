package edu.esprit.controllers;

import edu.esprit.entities.EndUser;
import edu.esprit.entities.Equipement;
import edu.esprit.entities.Muni;
import edu.esprit.services.ServiceEquipement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class AjouterEquipementGui {
    @FXML
    private AnchorPane MainAnchorPaneBaladity;

    @FXML
    private VBox MainLeftSidebar;

    @FXML
    private BorderPane SecondBorderPane;

    @FXML
    private Button ajoutequipementbtn;

    @FXML
    private RadioButton categoriefixe;

    @FXML
    private RadioButton categoriemobile;

    @FXML
    private DatePicker dateajout;

    @FXML
    private TextArea descriptionTF;

    @FXML
    private BorderPane firstborderpane;

    @FXML
    private Label imageequipement;

    @FXML
    private ImageView imagevieweq;

    @FXML
    private Button navigateequipementbtn;

    @FXML
    private TextField nomTF;

    @FXML
    private ComboBox<Integer> quantiteCB;

    @FXML
    private TextField referenceTF;

    @FXML
    private Button telechargerimage;
    private String imagePath;
    private final ServiceEquipement se = new ServiceEquipement();
    Muni muni = new Muni(1);
    EndUser user = new EndUser(1,muni);
    private Label label;

    @FXML
    void BTNGestionAct(ActionEvent event) {

    }

    @FXML
    void BTNGestionEquipement(ActionEvent event) {

    }

    @FXML
    void BTNGestionEvennement(ActionEvent event) {

    }

    @FXML
    void BTNGestionRec(ActionEvent event) {

    }

    @FXML
    void BTNGestionTache(ActionEvent event) {

    }

    @FXML
    void BTNGestionUser(ActionEvent event) {

    }

    @FXML
    void BTNToggleSidebar(ActionEvent event) {

    }

    @FXML
    void ajouterEquipementAction(ActionEvent event) {
// Utilisez imagePath pour enregistrer le chemin absolu de l'image dans la base de données
        Date dateAjout = Date.valueOf(dateajout.getValue()); // Convertissez la valeur du DatePicker en objet Date
        int quantite = Integer.parseInt(quantiteCB.getValue().toString()); // Assurez-vous que la ComboBox est correctement initialisée avec des valeurs
        Equipement equipement = new Equipement(referenceTF.getText(), nomTF.getText(), categoriefixe.isSelected() ? "Fixe" : "Mobile", dateAjout, quantite, imagePath, descriptionTF.getText(), user, muni);

        se.ajouter(equipement); // Ajoutez l'équipement en utilisant votre service

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Equipement ajouté");
        alert.setContentText("L'équipement a été ajouté avec succès !");
        alert.show();
    }

    @FXML
    void navigatetoAfficherEquipementAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AfficherEquipementGui.fxml"));
            referenceTF.getScene().setRoot(root);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry");
            alert.setTitle("Error");
            alert.show();
        }

    }

    @FXML
    void selectQuantite(ActionEvent event) {
        Integer selectedQuantity = (Integer) quantiteCB.getSelectionModel().getSelectedItem();

    }
    @FXML
    public void initialize() {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }
        quantiteCB.setItems(list);
    }

    @FXML
    void telechargerImageEquipemnt(ActionEvent event) {
        telechargerimage.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image", "*.jpg"), new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image files", "*.jpg", "*.png"));
            Stage stage = (Stage) telechargerimage.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                // Affiche le nom du fichier sélectionné
                imageequipement.setText(selectedFile.getName());

                // Récupère le chemin absolu du fichier
                String absolutePath = selectedFile.getAbsolutePath();
                // Stocke le chemin absolu dans la variable de classe
                imagePath = absolutePath;

                // Crée une URL à partir du chemin absolu du fichier
                String fileUrl = new File(absolutePath).toURI().toString();

                // Crée une image à partir de l'URL du fichier
                Image image = new Image(fileUrl);

                // Affiche l'image dans l'ImageView
                imagevieweq.setImage(image);
            }
        });
    }

}
