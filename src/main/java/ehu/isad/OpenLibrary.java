package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpenLibrary extends Application{

    private ComboBox comboLibruak;
    private Label label = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment Liburuak");

        comboLibruak = new ComboBox();
        comboLibruak.getItems().add("Blockchain: Blueprint for a New Economy");
        comboLibruak.getItems().add("R for Data Science");
        comboLibruak.getItems().add("Fluent Python");
        comboLibruak.getItems().add("Natural Language Processing with PyTorch");
        comboLibruak.getItems().add("Data Algorithms");
        //comboLibruak.getSelectionModel().selectFirst();

        label.setWrapText(true);

        comboLibruak.setOnAction(e -> {
            String sakatuta = (String) comboLibruak.getValue();
            System.out.println(sakatuta);
            String isbn = this.isbnLortu(sakatuta);

            Liburua l = new Liburua();
            l = l.irakurriURLtik(isbn);

            label.setText("Izenburua: "+l.getTitle()+" "+l.getSubtitle()+"\n"+"Orri kopurua: "+l.getNumber_of_pages()+"\n"+"Argitaletxea(k): "+l.getPublishers()[0]);
            for(int i=1; i < l.getPublishers().length; i++){
                 label.setText(label.getText()+", "+l.getPublishers()[i]);
            }

        });

        VBox vbox = new VBox(comboLibruak,label);

        Scene scene = new Scene(vbox, 350, 260);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private String isbnLortu(String lib){
        String isbn = "";
        switch (lib) {
            case "Blockchain: Blueprint for a New Economy":
                isbn = "9781491920497";
                break;
            case "R for Data Science":
                isbn = "1491910399";
                break;
            case "Fluent Python":
                isbn = "1491946008";
                break;
            case "Natural Language Processing with PyTorch":
                isbn = "1491978236";
                break;
            case "Data Algorithms":
                isbn = "9781491906187";
                break;
        }
       return isbn;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

