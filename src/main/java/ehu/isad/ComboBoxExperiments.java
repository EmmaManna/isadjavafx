package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    private ImageView imageView = new ImageView();
    private ListView<Argazki> listViewOfArgazki;
    private ComboBox comboBilduma;
    private Map<String, List<Argazki>> bildumaMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment Image");

        comboBilduma = new ComboBox();
        List<String> bildumak = List.of("abereak", "landareak", "frutak");


        bildumaMap = new HashMap<>();

        bildumaMap.put("abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")
        ));

        bildumaMap.put("landareak", List.of(
                new Argazki("Kaktusa", "cactus.png"),
                new Argazki("Berdea", "landareberdea.jpeg"),
                new Argazki("Ezezaguna", "landarehoria.jpeg")
        ));

        bildumaMap.put("frutak", List.of(
                new Argazki("Marrubia", "fresa.jpeg"),
                new Argazki("Sandia", "sandia.png"),
                new Argazki("Sagarra", "sagarra.jpeg")
        ));

        ObservableList<String> bildumaList = FXCollections.observableArrayList();
        bildumaList.addAll(bildumak);

        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));

        comboBilduma.setItems(bildumaList);
        comboBilduma.getSelectionModel().selectFirst();

        listViewOfArgazki = new ListView<>(argazkiList);

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = ((Argazki)observable.getValue()).getFitx();
            imageView.setImage(lortuIrudia(fitx /* 48x48 */));


        });

        listViewOfArgazki.getSelectionModel().selectFirst();

        comboBilduma.setOnAction(e -> {
            String sakatuta = (String) comboBilduma.getValue();
            System.out.println(sakatuta);
            argazkiList.clear();
            argazkiList.addAll(bildumaMap.get(sakatuta));
            listViewOfArgazki.getSelectionModel().selectFirst();

        });



        VBox vbox = new VBox(comboBilduma, listViewOfArgazki, imageView);
        //vbox.setAlignment(Pos.BASELINE_CENTER);
        //vbox.setPadding(new Insets(10,0,0,0));

        Scene scene = new Scene(vbox, 320, 260);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Image lortuIrudia(String irudia){
        InputStream is = getClass().getResourceAsStream("/"+irudia);
        BufferedImage reader = null;
        try {
            reader = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = SwingFXUtils.toFXImage(reader,null);
        return image;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
