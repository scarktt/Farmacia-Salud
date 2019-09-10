package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
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
import java.util.List;
import java.util.ResourceBundle;

public class PagoServicioControlador implements Initializable {
    // ComboBox
    @FXML private ComboBox cmbVendedor;
    @FXML private ComboBox cmbTipoPago;
    @FXML private ComboBox cmbProveedor;
    @FXML private ComboBox cmbVendedorA;
    //Textbox
    @FXML private TextField txtMonto;
    @FXML private TextField txtAgregarAbono;

    // TableView
    @FXML private TableView<Pagos> TVPagoServicio;
    @FXML private TableView<List<StringProperty>> TVAbono;

    @FXML private TableColumn<Pagos, String> TCProveedor;
    @FXML private TableColumn<Pagos, String> TCMonto;
    @FXML private TableColumn<Pagos, String> TCReciboColector;
    @FXML private TableColumn<Pagos, String> TCObservacion;
    @FXML private TableColumn<Pagos, String> TCFechaVencPago;

    @FXML private TableColumn<List<StringProperty>, String> TCFechaAbono;
    @FXML private TableColumn<List<StringProperty>, String> TCSaldoAbono;

    // Colecciones de tipo String
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaTipoPago = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();

    // Colecciones de tipo StringProperty para el TableView
    private ObservableList<Pagos> listaDeudas = FXCollections.observableArrayList();
    private ObservableList<List<StringProperty>> listaAbono = FXCollections.observableArrayList();

    //Colecciones de tipo Abono
    //private ObservableList<Abono> listaAbono = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        LoadDataCmbox(conexion);


        listaAbono.clear();

        Abono.llenarTVAbono(conexion.getConnection(), listaAbono);

        // Enlazar listas con TableView
        TVAbono.setItems(listaAbono);
        //System.out.println(listaAbono);
        // Enlazar columnas con atributos
        TCFechaAbono.setCellValueFactory(listaAbono -> listaAbono.getValue().get(1));
        TCSaldoAbono.setCellValueFactory(listaAbono -> listaAbono.getValue().get(0));

        conexion.cerrarConexion();
    }

    private void LoadDataCmbox (Conexion conexion) {
        //LLenar listas
        Empleado.llenarCmbNombresEmpleado(conexion.getConnection(), listaVendedores);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);
        Pagos.llenarCmbTipoPago(conexion.getConnection(), listaTipoPago);

        // Enlazar listas con ComboBox y tableview
        cmbVendedor.setItems(listaVendedores);
        cmbProveedor.setItems(listaProveedores);
        cmbTipoPago.setItems(listaTipoPago);
        cmbVendedorA.setItems(listaVendedores);
    }


    /************************************ METODO ONACTION PARA EL FILTRO POR PROVEEDOR ************************************/

    private String text = "";

    public void onActionProveedor(ActionEvent event) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        text = text + cmbProveedor.getSelectionModel().getSelectedItem();
        listaDeudas.clear();

        Pagos.busquedaDinamicaDeudasPendientes(conexion.getConnection(), text, listaDeudas);

        //System.out.println(listaDeudas);
        // Enlazar listas con TableView
        TVPagoServicio.setItems(listaDeudas);

        // Enlazar columnas con atributos
        TCProveedor.setCellValueFactory(new PropertyValueFactory<>("Nombre_proveedor"));
        TCMonto.setCellValueFactory(new PropertyValueFactory<>("MontoCompra"));
        TCReciboColector.setCellValueFactory(new PropertyValueFactory<>("ReciboColector"));
        TCObservacion.setCellValueFactory(new PropertyValueFactory<>("Observacion"));
        TCFechaVencPago.setCellValueFactory(new PropertyValueFactory<>("FechaVencPago"));

        conexion.cerrarConexion();
    }
}