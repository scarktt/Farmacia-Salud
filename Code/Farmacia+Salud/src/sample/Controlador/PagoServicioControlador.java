package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Modelo.*;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class PagoServicioControlador implements Initializable {
    // ComboBox
    @FXML private ComboBox cmbVendedor;
    @FXML private ComboBox cmbTipoPago;
    @FXML private ComboBox cmbProveedor;
    @FXML private ComboBox cmbFacturaCompra;
    @FXML private ComboBox cmbVendedorA;
    //Textbox
    @FXML private TextField txtMonto;
    @FXML private TextField txtAgregarAbono;

    // TableView
    @FXML private TableView<Pagos> TVPagoServicio;
    @FXML private TableView<String> TVAbono;

    // Columnas del TableView
    @FXML private TableColumn<Pagos, Proveedor> TCProveedor;
    @FXML private TableColumn<Pagos, CompraProducto> TCMonto;
    @FXML private TableColumn<Pagos, CompraProducto> TCReciboColector;
    @FXML private TableColumn<Pagos, CompraProducto> TCObservacion;
    @FXML private TableColumn<Pagos, CompraProducto> TCFechaVencPago;

    // Colecciones de tipo String
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaTipoPago = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaFacturaCompra = FXCollections.observableArrayList();
    //Colecciones de tipo Pagos
    private ObservableList<Pagos> listaPagos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //LLenar listas
        Empleado.llenarCmbNombresEmpleado(conexion.getConnection(), listaVendedores);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);
        Pagos.llenarCmbTipoPago(conexion.getConnection(), listaTipoPago);
        CompraProducto.llenarCmbFacturaCompra(conexion.getConnection(), listaFacturaCompra);
        Pagos.llenarTVPagoServicio(conexion.getConnection(), listaPagos);

        // Enlazar listas con ComboBox y tableview
        cmbVendedor.setItems(listaVendedores);
        cmbProveedor.setItems(listaProveedores);
        cmbTipoPago.setItems(listaTipoPago);
        cmbFacturaCompra.setItems(listaFacturaCompra);
        cmbVendedorA.setItems(listaVendedores);
        TVPagoServicio.setItems(listaPagos);

        //Enlazar listas con tableview
        TCProveedor.setCellValueFactory(new PropertyValueFactory<Pagos, Proveedor>("Nombre_proveedor"));
        TCMonto.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("MontoCompra"));
        TCReciboColector.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("ReciboColector"));
        TCObservacion.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("Observacion"));
        TCFechaVencPago.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("FechaVencPago"));

        conexion.cerrarConexion();
    }


}
