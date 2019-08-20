package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import sample.Modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacturacionControlador implements Initializable {

    @FXML private AnchorPane APFacturacion;
    // ComboBox
    @FXML private ComboBox<String> cmbVendedor;
    @FXML private ComboBox<String> cmbProveedor;
    @FXML private ComboBox<String> cmbForma_Farmaceutica;
    @FXML private ComboBox<String> cmbUnidadMedida;
    @FXML private ComboBox<String> cmbUtilidad;
    @FXML private ComboBox<String> cmbIndicacion;
    // TextFields
    @FXML private TextField txtProducto;
    @FXML private TextField txtCantidad;
    // TableView
    @FXML private TableView<String> TVAgregarProductos;
    // Columna del TableView
    @FXML private TableColumn<String, String> TCProducto;

    // Colecciones de tipo String para los ComboBox
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaForma_farmaceutica = FXCollections.observableArrayList();
    private ObservableList<String> listaUnidadMedida = FXCollections.observableArrayList();
    private ObservableList<String> listaIndicacion = FXCollections.observableArrayList();
    private ObservableList<String> listaUtilidad = FXCollections.observableArrayList();

    // Colecciones de tipo String para el TableView
    private ObservableList<String> listaNombreProducto = FXCollections.observableArrayList();

    // Colecciones de tipo Producto
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        Producto.AgregarListaProductos(conexion.getConnection(), listaProductos);

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

    public void OnTableItemSelected() {
        // Se obtiene el nombre del item seleccionado
        String value = TVAgregarProductos.getSelectionModel().getSelectedItem();

        // Se le asigna el valor obtenido previamente al text field de producto
        txtProducto.setText(value);
    }

    private Boolean addProduct = false;

    public void OnButtonToAddClicked() {
        // El objetivo del siguiente condicional es verificar que se hayan completado todos los elementos necesarios
        // para proceder a agregar un determinado producto en la pantalla de Detalle Facturacion.
        if (cmbVendedor.getValue() != null && !txtProducto.getText().equals("") && !txtCantidad.getText().equals("")) {
            addProduct = true;

        }
    }

    public void OnButtonToGoDetalleFacturaClicked() throws IOException {
        // El objetivo del siguiente if es verificar que se haya agregado al menos un producto para asi
        // pasar a la siguiente pantalla de Detalle Factura.
        if (addProduct) {
            AnchorPane APDetalleFactura = FXMLLoader.load(getClass().getResource("/sample/Vista/DetalleFactura.fxml"));
            APFacturacion.getChildren().setAll(APDetalleFactura);
        }
    }
}
