package sample.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sample.Modelo.Conexion;
import sample.Modelo.Empleado;
import sample.Modelo.Producto;
import sample.Modelo.Proveedor;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoricoVentasControlador implements Initializable {
    @FXML private ComboBox cmbProducto;
    @FXML private ComboBox cmbVendedor;
    @FXML private ComboBox cmbProveedor;

    ObservableList<String> listaNombresProductos = FXCollections.observableArrayList();
    ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    ObservableList<String> listaProveedores = FXCollections.observableArrayList();

    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        conexion = new Conexion();
        conexion.establecerConexion();

        Producto.llenarCmbNombresProductos(conexion.getConnection(), listaNombresProductos);
        Empleado.llenarCmbNombresEmpleado(conexion.getConnection(), listaVendedores);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);

        cmbProducto.setItems(listaNombresProductos);
        cmbVendedor.setItems(listaVendedores);
        cmbProveedor.setItems(listaProveedores);

        conexion.cerrarConexion();
    }
}
