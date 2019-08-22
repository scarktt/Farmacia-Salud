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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Modelo.*;

import javafx.event.ActionEvent;
import sample.Modelo.*;

import java.net.URL;
import java.sql.Date;
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
    @FXML private TableView<String> TVPagoServicio;
    @FXML private TableView<Abono> TVAbono;

    @FXML private TableColumn<String, String> TCProveedor;
    @FXML private TableColumn<String, String> TCMonto;
    @FXML private TableColumn<String, String> TCReciboColector;
    @FXML private TableColumn<String, String> TCObservacion;
    @FXML private TableColumn<String, String> TCFechaVencPago;

    // Colecciones de tipo String
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaTipoPago = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaFacturaCompra = FXCollections.observableArrayList();

    //Colecciones de tipo Pagos
    private ObservableList<String> listaDeudas = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedor = FXCollections.observableArrayList();
    private ObservableList<String> listaMonto = FXCollections.observableArrayList();
    private ObservableList<String> listaReciboColector = FXCollections.observableArrayList();
    private ObservableList<String> listaObservacion = FXCollections.observableArrayList();
    private ObservableList<String> listaFechaVencPago = FXCollections.observableArrayList();

    //Colecciones de tipo Abono
    private ObservableList<Abono> listaAbono = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //LLenar listas
        Empleado.llenarCmbNombresEmpleado(conexion.getConnection(), listaVendedores);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);
        Pagos.llenarCmbTipoPago(conexion.getConnection(), listaTipoPago);
        CompraProducto.llenarCmbFacturaCompra(conexion.getConnection(), listaFacturaCompra);

        // Enlazar listas con ComboBox y tableview
        cmbVendedor.setItems(listaVendedores);
        cmbProveedor.setItems(listaProveedores);
        cmbTipoPago.setItems(listaTipoPago);
        cmbFacturaCompra.setItems(listaFacturaCompra);
        cmbVendedorA.setItems(listaVendedores);

        conexion.cerrarConexion();
    }

    private String text = "";

    public void handleonActionProveedor(ActionEvent event) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        text = text + cmbProveedor.getSelectionModel().getSelectedItem();
        listaProveedor.clear();listaMonto.clear();listaReciboColector.clear();listaObservacion.clear();listaFechaVencPago.clear();

        Pagos.busquedaDinamicaDeudasPendientes(conexion.getConnection(), text,listaProveedor, listaMonto, listaReciboColector, listaObservacion, listaFechaVencPago);

        TVPagoServicio.setItems(listaProveedor);
        TCProveedor.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        //TVPagoServicio.setItems(listaMonto);
        TCMonto.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

       // TVPagoServicio.setItems(listaReciboColector);
        TCReciboColector.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        //TVPagoServicio.setItems(listaObservacion);
        TCObservacion.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

       // TVPagoServicio.setItems(listaFechaVencPago);
        TCFechaVencPago.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        /*TCMonto.setCellValueFactory(new PropertyValueFactory<String, String>("MontoCompra"));
        TCReciboColector.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("ReciboColector"));
        TCProveedor.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("Observacio"));
        TCFechaVencPago.setCellValueFactory(new PropertyValueFactory<Pagos, CompraProducto>("FechaVencPago"));*/

        conexion.cerrarConexion();
    }
}
