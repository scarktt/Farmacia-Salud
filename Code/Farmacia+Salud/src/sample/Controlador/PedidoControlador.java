package sample.Controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PedidoControlador implements Initializable {
    @FXML private ComboBox PcmbProveedor;
    @FXML private ComboBox PcmbFormaFarmaceutica;
    @FXML private ComboBox PcmbUnidadMedida;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
