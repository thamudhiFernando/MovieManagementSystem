package lk.ijse.dep.controller;

import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblMenu;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblHeading;

    @FXML
    private ImageView imgManageMovie;

    @FXML
    private ImageView imgManageActors;

    @FXML
    private ImageView imgRegisterActors;

    @FXML
    private Label lblMenu11;

    @FXML
    private Label lblMenu111;

    @FXML
    private Label lblMenu112;

    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void navigate_OnClicked(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "imgManageMovie":
                    root = FXMLLoader.load(this.getClass().getResource("/fxml/manageMovies.fxml"));
                    break;
                case "imgManageActors":
                    root = FXMLLoader.load(this.getClass().getResource("/fxml/manageActors.fxml"));
                    break;
                case "imgRegisterActors":
                    root = FXMLLoader.load(this.getClass().getResource("/fxml/registerActors.fxml"));
                    break;
            }

            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
            }
        }
    }

}
