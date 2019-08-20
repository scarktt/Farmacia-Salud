package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacturacionControlador implements Initializable {

    // ComboBox
    @FXML private ComboBox cmbVendedor;
    @FXML private ComboBox cmbProveedor;
    @FXML private ComboBox cmbForma_Farmaceutica;
    @FXML private ComboBox cmbUnidadMedida;
    @FXML private ComboBox cmbUtilidad;
    @FXML private ComboBox cmbIndicacion;
    @FXML private TextField txtBuscar;
    // TableViewß
    @FXML private TableView<String> TVAgregarProductos;
    // Columnas del TableView
    @FXML private TableColumn<String, String> TCProducto;

    // Colecciones de tipo String
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaForma_farmaceutica = FXCollections.observableArrayList();
    private ObservableList<String> listaUnidadMedida = FXCollections.observableArrayList();
    private ObservableList<String> listaIndicacion = FXCollections.observableArrayList();
    private ObservableList<String> listaUtilidad = FXCollections.observableArrayList();

    // Colecciones de tipo Objeto
    private ObservableList<String> listaNombreProducto = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //LLenar listas
        Empleado.llenarCmbNombresEmpleado(conexion.getConnection(), listaVendedores);
        Proveedor.llenarCmbNombresProveedores(conexion.getConnection(), listaProveedores);
        Producto.llenarCmbForma_farmaceutica(conexion.getConnection(), listaForma_farmaceutica);
        Producto.llenarCmbUnidadMedida(conexion.getConnection(), listaUnidadMedida);
        Enfermedad.llenarCmbEnfermedad(conexion.getConnection(), listaUtilidad);
        Indicacion.llenarCmbIndicacion(conexion.getConnection(), listaIndicacion);


        // Enlazar listas con ComboBox
        cmbVendedor.setItems(listaVendedores);
        cmbProveedor.setItems(listaProveedores);
        cmbForma_Farmaceutica.setItems(listaForma_farmaceutica);
        cmbUnidadMedida.setItems(listaUnidadMedida);
        cmbIndicacion.setItems(listaIndicacion);
        cmbUtilidad.setItems(listaUtilidad);



        conexion.cerrarConexion();
    }

    //Cierra el programa
    public void pressExit() {
        System.exit(0);
    }

    //Minimiza el programa
    public void pressMin() {
        //setIconified(1);aun no funciona
    }

    private String text = "";

    public void handleKeyReleased(KeyEvent keyEvent) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        if (keyEvent.getCode() != KeyCode.BACK_SPACE) {
            // Se agrega la letra digitada caracter a caracter, esto debido a que cada vez que se entra en este metodo
            // (handleKeyReleased) el parametro del mismo solo recibe el caracter nuevo y si se envia solo eso para
            // la consulta, la busqueda va a ser incorrecta.
            text = text + keyEvent.getText();
            listaNombreProducto.clear();

            Producto.busquedaDinamicaProducto(conexion.getConnection(), text, listaNombreProducto);

            // Enlazar listas con TableView
            TVAgregarProductos.setItems(listaNombreProducto);

            // Enlazar columnas con atributos
            TCProducto.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            conexion.cerrarConexion();

        } else {

            // Si la longitud del texto es cero, se le establece como cadena vacia. Si no, se resta un caracter
            // del texto. (Esto tiene la finalidad de no activar la excepcion de que la longitud de la cadena
            // sea un numero negativo)
            if (text.length() == 0) {
                text = "";
                listaNombreProducto.clear();

            } else {
                text = text.substring(0, text.length() - 1);
                listaNombreProducto.clear();
            }

            Producto.busquedaDinamicaProducto(conexion.getConnection(), text, listaNombreProducto);

            // Enlazar listas con TableView
            TVAgregarProductos.setItems(listaNombreProducto);

            // Enlazar columnas con atributos
            TCProducto.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            conexion.cerrarConexion();
        }

    }
}
