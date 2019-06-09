package lk.ijse.dep.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppInitializer extends Application {

    public static AnnotationConfigApplicationContext ctx;

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("error.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            Logger.getLogger("").addHandler(fileHandler);
            launch(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void navigateToHome(Node node, Stage mainStage) throws IOException {
        Parent root = FXMLLoader.load(AppInitializer.class.getResource("/fxml/dashboard.fxml"));
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
    }


    @Override
    public void start(Stage primaryStage) {
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/dashboard.fxml"));
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Movie Management System");
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
