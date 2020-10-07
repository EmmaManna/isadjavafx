package ehu.isad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

        @FXML
        private Button btnKautotu;

        @FXML
        private Label lblErabiltzaile;

        @FXML
        private Label lblPasahitza;

        @FXML
        private TextField txtFldErabiltzailea;

        @FXML
        private PasswordField psswrdFld;

        @FXML
        public void klikEgin(ActionEvent event) {
            System.out.println(txtFldErabiltzailea.getText());
            System.out.println(psswrdFld.getText());
            txtFldErabiltzailea.setText("");
            psswrdFld.setText("");

    }


}
