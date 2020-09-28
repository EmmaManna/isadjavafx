package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class KriptoPrezioa extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Kripto txanponen prezioak");

        ComboBox comboBox = new ComboBox();
        Label label = new Label();

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            String sakatuta = (String) comboBox.getValue();
            System.out.println(sakatuta);
            Txanpona txanpona = new Txanpona();
            txanpona = txanpona.irakurriURLtik(sakatuta);
            label.setText(String.valueOf(txanpona.price));
        });

        VBox vbox = new VBox(label,comboBox);

        Scene scene = new Scene(vbox, 320, 160);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

