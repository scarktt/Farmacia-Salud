package sample.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sample.Modelo.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoricoPagosControlador implements Initializable {
    @FXML private ComboBox cmbCategoria;
    @FXML private ComboBox cmbProveedor;

    private ObservableList<String> listaCategoria = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        LoadDataCmbox(conexion);

        conexion.cerrarConexion();
    }

    private void LoadDataCmbox (Conexion conexion) {
        //LLenar listas
        Pagos.llenarCmbTipoPago(conexion.getConnection(), listaCategoria);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);

        // Enlazar listas con ComboBox y tableview
        cmbCategoria.setItems(listaCategoria);
        cmbProveedor.setItems(listaProveedores);
    }
}
