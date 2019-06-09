package lk.ijse.dep.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.main.AppInitializer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterActorsController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblHeading;

    @FXML
    private Label lblHeading1;

    @FXML
    private JFXTextField txtMovieName;

    @FXML
    private Label lblHeading111;

    @FXML
    private JFXButton btnSaveMovie;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXTextField txtActorName;

    @FXML
    private JFXTextField txtActorROLE;

    @FXML
    private Label lblHeading1111;

    @FXML
    private JFXComboBox<?> comboActors;

    @FXML
    private JFXComboBox<?> comboMoives;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void btnMakePurchase_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnSaveMovie_OnAction(ActionEvent event) {

    }

    @FXML
    void comboActors_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void comboMoives_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
}
