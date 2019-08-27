package sample.Controlador;

import javafx.beans.property.StringProperty;
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
import java.util.List;
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
    @FXML private TextField buscar;
    @FXML private TextField txtProducto;
    @FXML private TextField txtCantidad;
    @FXML private TextField tfDosis;
    // CheckBox
    @FXML private CheckBox ckboxGenerico;
    // TableView
    @FXML private TableView<List<StringProperty>> TVAgregarProductos;
    // Columnas del TableView
    @FXML private TableColumn<List<StringProperty>, String> TCProducto;
    @FXML private TableColumn<List<StringProperty>, String> TCProveedor;

    // Colecciones de tipo String para los ComboBox
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaForma_farmaceutica = FXCollections.observableArrayList();
    private ObservableList<String> listaUnidadMedida = FXCollections.observableArrayList();
    private ObservableList<String> listaIndicacion = FXCollections.observableArrayList();
    private ObservableList<String> listaUtilidad = FXCollections.observableArrayList();

    // Colecciones de tipo StringProperty para el TableView
    private ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

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

    /************************************ METODO HANDLE PARA EL BUSCADOR ************************************/

    private String text = "";

    public void handleKeyReleased(KeyEvent keyEvent) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        if (keyEvent.getCode() != KeyCode.BACK_SPACE) {
            // Se agrega la letra digitada caracter a caracter, esto debido a que cada vez que se entra en este metodo
            // (handleKeyReleased) el parametro del mismo solo recibe el caracter nuevo y si se envia solo eso para
            // la consulta, la busqueda va a ser incorrecta.
            text = text + keyEvent.getText();
            data.clear();

            Producto.busquedaDinamicaProducto(conexion.getConnection(), text, getTipo(), getProveedorValue(),
                    getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

            // Enlazar listas con TableView
            TVAgregarProductos.setItems(data);

            // Enlazar columnas con atributos
            TCProducto.setCellValueFactory(data -> data.getValue().get(0));
            TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

            conexion.cerrarConexion();

        } else {

            // Si la longitud del texto es cero, se le establece como cadena vacia. Si no, se resta un caracter
            // del texto. (Esto tiene la finalidad de no activar la excepcion de que la longitud de la cadena
            // sea un numero negativo)
            if (text.length() == 0) {
                text = "";
                data.clear();

            } else {
                text = text.substring(0, text.length() - 1);
                data.clear();
            }

            Producto.busquedaDinamicaProducto(conexion.getConnection(), text, getTipo(), getProveedorValue(),
                    getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

            // Enlazar listas con TableView
            TVAgregarProductos.setItems(data);

            // Enlazar columnas con atributos
            TCProducto.setCellValueFactory(data -> data.getValue().get(0));
            TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

            conexion.cerrarConexion();
        }

    }

    public void OnReleasedProveedor() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnReleasedFormaF() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnReleasedUnidadMedida() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnReleasedUtilidad() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnReleasedIndicacion() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnMouseClickedGenerico() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        data.clear();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), buscar.getText(), getTipo(), getProveedorValue(),
                getFormafarmaceuticaValue(), getDosisValue(), getUnidadMedidaValue (), getUtilidadValue (), getIndicacion (), getGenerico (), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(data -> data.getValue().get(0));
        TCProveedor.setCellValueFactory(data -> data.getValue().get(1));

        conexion.cerrarConexion();
    }

    public void OnTableItemSelected() {
        // Se obtiene el nombre del item seleccionado
        //String value = TVAgregarProductos.getSelectionModel().getSelectedItem();

        // Se le asigna el valor obtenido previamente al text field de producto
        //txtProducto.setText(value);
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

    /************* METODOS PARA OBTENER LOS VALORES DE LOS CAMPOS DE BUSQUEDA AVANZADA *************/

    private String getProveedorValue() {
        if (cmbProveedor.getSelectionModel().isEmpty()) {
            System.out.println(cmbProveedor.getValue());
            return "%";
        } else {
            return cmbProveedor.getValue();
        }
    }

    private String getFormafarmaceuticaValue () {
        if (cmbForma_Farmaceutica.getSelectionModel().isEmpty()) {
            return "%";
        } else {
            return cmbForma_Farmaceutica.getValue();
        }
    }

    private int getDosisValue () {
        if (tfDosis.getText().equals("")) {
            return 0;
        } else if (isInteger(tfDosis.getText())) {
            return Integer.parseInt(tfDosis.getText());
        } else {
            return 0;
        }
    }

    private String getUnidadMedidaValue () {
        if (cmbUnidadMedida.getSelectionModel().isEmpty()) {
            return "%";
        } else {
            return cmbUnidadMedida.getValue();
        }
    }

    private String getUtilidadValue () {
        if (cmbUtilidad.getSelectionModel().isEmpty()) {
            return "%";
        } else {
            return cmbUtilidad.getValue();
        }
    }

    private String getIndicacion () {
        if (cmbIndicacion.getSelectionModel().isEmpty()) {
            return "%";
        } else {
            return cmbIndicacion.getValue();
        }
    }

    private Boolean getGenerico () {
        return ckboxGenerico.isSelected();
    }

    private boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private int getTipo () {
        if (!tfDosis.getText().equals("") && ckboxGenerico.isSelected()) {
            return 0;
        } else if (tfDosis.getText().equals("") && !ckboxGenerico.isSelected()) {
            return 1;
        } else if (tfDosis.getText().equals("") && ckboxGenerico.isSelected()) {
            return 2;
        } else if (!tfDosis.getText().equals("") && !ckboxGenerico.isSelected()) {
            return 3;
        } else {
            return 0;
        }
    }
}
