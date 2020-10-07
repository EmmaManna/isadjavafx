package ehu.isad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pasahitzak extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/pasahitzak.fxml"));
        primaryStage.setTitle("Kautotzeko leihoa");
        primaryStage.setScene(new Scene(root,550,350));
        primaryStage.show();
    }
}
