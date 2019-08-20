package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    // TextFields
    @FXML private TextField txtBuscar;
    @FXML private TextField txtProducto;
    @FXML private TextField txtCantidad;
    // TableView
    @FXML private TableView<String> TVAgregarProductos;
    // Columna del TableView
    @FXML private TableColumn<String, String> TCProducto;
    @FXML private Button btnInsertar;

    // Colecciones de tipo String para los ComboBox
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaForma_farmaceutica = FXCollections.observableArrayList();
    private ObservableList<String> listaUnidadMedida = FXCollections.observableArrayList();
    private ObservableList<String> listaIndicacion = FXCollections.observableArrayList();
    private ObservableList<String> listaUtilidad = FXCollections.observableArrayList();

    // Colecciones de tipo String para el TableView
    private ObservableList<String> listaNombreProducto = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        System.out.println(TVAgregarProductos.getSelectionModel().getSelectedItem());

        LoadDataCmbox(conexion);

        conexion.cerrarConexion();
    }

    private void LoadDataCmbox (Conexion conexion) {
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

    public void OnTableItemSelected(MouseEvent mouseEvent) {
        // Se obtiene el nombre del item seleccionado
        String value = TVAgregarProductos.getSelectionModel().getSelectedItem();

        // Se le asigna el valor obtenido previamente al text field de producto
        txtProducto.setText(value);
    }

    public void OnButtonToAddClicked(MouseEvent mouseEvent) throws IOException {
        if (cmbVendedor.getValue() != null && txtProducto.getText() != null && txtCantidad.getText() != null) {
            Parent DetalleFacturacionParent = FXMLLoader.load(getClass().getResource("/sample/Vista/DetalleFactura.fxml"));
            Scene DetalleFacturacionScene = new Scene(DetalleFacturacionParent);

            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            window.setScene(DetalleFacturacionScene);
            window.show();

        }
    }
}
