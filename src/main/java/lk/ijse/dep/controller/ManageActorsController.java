package lk.ijse.dep.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.business.custom.ActorBO;
import lk.ijse.dep.dto.ActorDTO;
import lk.ijse.dep.main.AppInitializer;
import lk.ijse.dep.tableModel.ActorTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageActorsController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblHeading;

    @FXML
    private Label lblHeading1;

    @FXML
    private JFXTextField txtActorID;

    @FXML
    private JFXTextField txtActorName;

    @FXML
    private JFXTextField txtActorAge;

    @FXML
    private Label lblHeading11;

    @FXML
    private Label lblHeading111;

    @FXML
    private Label lblHeading1111;

    @FXML
    private JFXButton btnSaveActor;

    @FXML
    private ImageView imgGoBack;

    @FXML
    private JFXButton btnDeleteActor;

    @FXML
    private TableView<ActorTM> tblActors;

    @FXML
    private TableColumn tblClmActorID;

    @FXML
    private TableColumn tblClmActorName;

    @FXML
    private TableColumn tblClmActorAge;

    private ActorBO actorBO = AppInitializer.ctx.getBean(ActorBO.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblActors.getColumns().get(0).setStyle("-fx-alignment:center");
        tblActors.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("actorID"));
        tblActors.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("actorName"));
        tblActors.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));

        try {
            List<ActorDTO> allActors = actorBO.getAlls();
            for (ActorDTO actor : allActors) {
                tblActors.getItems().add(new ActorTM(actor.getActor_id(),actor.getActor_name(),actor.getActor_age()));
            }
        } catch (Exception ex) {
            Logger.getLogger("lk.ijse.dep.controller").log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnDeleteActor_OnAction(ActionEvent event) {

    }

    @FXML
    void btnMakePurchase_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnSaveActor_OnAction(ActionEvent event) {
        int id = Integer.parseInt(txtActorID.getText());
        String name = txtActorName.getText();
        int age = Integer.parseInt(txtActorAge.getText());

        if (txtActorID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor ID is empty", ButtonType.OK).showAndWait();
            txtActorID.requestFocus();
            return;
        } else if (txtActorName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor Name is empty", ButtonType.OK).showAndWait();
            txtActorName.requestFocus();
            return;
        } else if (txtActorAge.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor age is empty", ButtonType.OK).showAndWait();
            txtActorAge.requestFocus();
            return;
        }

        ActorDTO actorDTO = new ActorDTO(id, name, age);
        try {
            actorBO.save(actorDTO);
            new Alert(Alert.AlertType.INFORMATION, "Actor has been saved successfully", ButtonType.OK).showAndWait();

            ActorTM actorTM = new ActorTM(id, name, age);
            tblActors.getItems().add(actorTM);
            tblActors.scrollTo(actorTM);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the Actor, try again", ButtonType.OK).showAndWait();
            Logger.getLogger("lk.ijse.dep.controller").log(Level.SEVERE, null, e);
        }

        reset();
    }

    @FXML
    void imgGoBack_OnMouseClicked(MouseEvent event) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    private void reset() {
        txtActorAge.clear();
        txtActorID.clear();
        txtActorName.clear();
        txtActorID.requestFocus();
        tblActors.getSelectionModel().clearSelection();
    }
}
