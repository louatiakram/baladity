package edu.esprit.controllers;

import edu.esprit.entities.EndUser;
import edu.esprit.entities.Muni;
import edu.esprit.services.ServiceMuni;
import edu.esprit.services.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class RegisterController implements Initializable {

    @FXML
    private ImageView ImageF;

    @FXML
    private ComboBox<String> muniSelectionComboBox;

    @FXML
    private PasswordField pfConfirmMotDePasse;

    @FXML
    private PasswordField pfMotDePasse;

    @FXML
    private Button pickImageButton;

    @FXML
    private TextField tfAddresse;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfTel;

    File selectedFile = null;

    Muni muni;
    ServiceUser serviceUser = new ServiceUser();

    ServiceMuni serviceMuni = new ServiceMuni();

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");

    @FXML
    void registerAction(ActionEvent event) {
        String nom = tfNom.getText();
        String email = tfEmail.getText();
        String motDePasse = pfMotDePasse.getText();
        String confirmMotDePasse = pfConfirmMotDePasse.getText();
        String numTel = tfTel.getText();
        String location = tfAddresse.getText();
        String selectedMuni = muniSelectionComboBox.getValue();

        // Votre logique de traitement d'inscription ici
        // Vous pouvez appeler votre service pour enregistrer l'utilisateur, par exemple
        if (nom.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || confirmMotDePasse.isEmpty() || numTel.isEmpty() || location.isEmpty() || selectedMuni == null ) {
            showAlert("Veuillez remplir tous les champs!");
        } else if (selectedFile == null) {
            showAlert("Veuillez entrer une image!");
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            showAlert("Veuillez entrer un email valid!");
        } else if(!motDePasse.equals(confirmMotDePasse)){
            showAlert("Vérifier votre mot de passe!");
        } else {
            serviceUser.ajouter(new EndUser(nom, email, motDePasse, "Citoyen", numTel, muni, location, selectedFile.getAbsolutePath()));
            showAlert("Inscription réussie pour : " + nom);
        }
    }

    @FXML
    void muniSelection(ActionEvent event) {

        // Access the selected item in muniSelectionComboBox
        String selectedMuni = muniSelectionComboBox.getValue();
        System.out.println("Selected Muni: " + selectedMuni);
        muni = serviceMuni.getOneByName(selectedMuni);
        System.out.println(muni);

    }


    @FXML
    void pickImageAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            // Handle the selected image file (e.g., display it, process it, etc.)
            System.out.println("Selected image: " + selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            ImageF.setImage(image);
        }
    }

    @FXML
    void handleLabelClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Se connecter");
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry");
            alert.setTitle("Error");
            alert.show();
        }
    }

    private void showAlert(String message) {
        // Affiche une boîte de dialogue d'information avec le message donné
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<String> typesProfile = FXCollections.observableArrayList();
        ObservableList<String> muniSelection = FXCollections.observableArrayList();

//        typesProfile.addAll("Citoyen", "Employé", "Responsable employé");
        muniSelection.addAll("Ariana Ville", "La Soukra", "Mnihla", "Raoued", "Ettadhamen", "Sidi Thabet");

        // Définir les éléments du ComboBox en utilisant la liste observable
//        profilTypeComboBox.setItems(typesProfile);
        muniSelectionComboBox.setItems(muniSelection);
    }
}
