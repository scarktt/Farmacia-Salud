package sample.Controlador;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML private TextField buscar;
    @FXML private TextField txtProducto;
    @FXML private TextField txtCantidad;
    @FXML private TextField tfDosis;
    // CheckBox
    @FXML private CheckBox ckboxGenerico;
    // TableView
    @FXML private TableView<Producto> TVAgregarProductos;
    // TableView's Columns
    @FXML private TableColumn<Producto, String> TCProducto;
    @FXML private TableColumn<Producto, String> TCProveedor;
    @FXML private TableColumn<Producto, String> TCFormaFarmaceutica;
    @FXML private TableColumn<Producto, String> TCDosis;

    // String Collections for ComboBox Items
    private ObservableList<String> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<String> listaProveedores = FXCollections.observableArrayList();
    private ObservableList<String> listaForma_farmaceutica = FXCollections.observableArrayList();
    private ObservableList<String> listaUnidadMedida = FXCollections.observableArrayList();
    private ObservableList<String> listaIndicacion = FXCollections.observableArrayList();
    private ObservableList<String> listaUtilidad = FXCollections.observableArrayList();

    // String Collections for TableView
    private ObservableList<Producto> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        LoadDataCmbox(conexion);
        getListFromDataBaseAndLoadData(conexion);
        filterList();

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

    /************************************ METODO PARA EL BUSCADOR ************************************/

    private void filterList () {
        FilteredList<Producto> filterData = new FilteredList<>(data, b -> true);

        buscar.textProperty().addListener((observable, oldValue, newValue) -> filterData.setPredicate(Producto -> {

            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = newValue.toLowerCase();

            if (Producto.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (Producto.getNombreProveedor().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else return String.valueOf(Producto.getDosis()).contains(lowerCaseFilter);
        }));

        SortedList<Producto> sortedData = new SortedList<>(filterData);

        sortedData.comparatorProperty().bind(TVAgregarProductos.comparatorProperty());

        TVAgregarProductos.setItems(sortedData);
    }

    private void getListFromDataBaseAndLoadData (Conexion conexion) {
        Producto.CargarProductos(conexion.getConnection(), data);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(data);

        // Llenar los combobox
        TCProducto.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TCProveedor.setCellValueFactory(new PropertyValueFactory<>("NombreProveedor"));
        TCFormaFarmaceutica.setCellValueFactory(new PropertyValueFactory<>("FormaFarmaceutica"));
        TCDosis.setCellValueFactory(new PropertyValueFactory<>("Dosis"));

        conexion.cerrarConexion();
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
