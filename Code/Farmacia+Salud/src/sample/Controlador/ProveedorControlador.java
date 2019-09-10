package sample.Controlador;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Modelo.Conexion;
import sample.Modelo.Producto;
import sample.Modelo.Proveedor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProveedorControlador implements Initializable {

    @FXML private TableView<Proveedor> TVProveedor;

    @FXML private TableColumn<Proveedor, String> TCID;
    @FXML private TableColumn<Proveedor, String> TCNombre;
    @FXML private TableColumn<Proveedor, String> TCTipo;
    @FXML private TableColumn<Proveedor, String> TCTel1;
    @FXML private TableColumn<Proveedor, String> TCTel2;

    //Botones
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;
    @FXML private Button btnEditar;
    @FXML private Button btnListo;
    @FXML private Button btnNuevoProveedor;

    //Textfield
    @FXML private  TextField txtIDAg;
    @FXML private TextField txtNombreAg;
    @FXML private TextField txtTel1Ag;
    @FXML private TextField txtTel2Ag;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTeléfono1;
    @FXML private TextField txtTeléfono2;

    @FXML private Label lblID;

    //Combobox
    @FXML private ComboBox<String> cmbTipoAg;
    @FXML private ComboBox<String> cmbTipo;

    // String Collections for ComboBox Items
    private ObservableList<String> ListaTipoProveedor = FXCollections.observableArrayList();

    // Colecciones de tipo StringProperty para el TableView
    private ObservableList<Proveedor> data = FXCollections.observableArrayList();
     private int posicion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        Proveedor.llenarCmbTipoProveedores(conexion.getConnection(), ListaTipoProveedor);

        cmbTipoAg.setItems(ListaTipoProveedor);
        cmbTipo.setItems(ListaTipoProveedor);

        conexion.cerrarConexion();
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

            Proveedor.busquedaDinamicaProveedor(conexion.getConnection(), text, data);

            // Enlazar listas con TableView
            TVProveedor.setItems(data);

            // Enlazar columnas con atributos
            TCID.setCellValueFactory(new PropertyValueFactory<>("IDproveedor"));
            TCNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre_proveedor"));
            TCTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo_proveedor"));
            TCTel1.setCellValueFactory(new PropertyValueFactory<>("tel1"));
            TCTel2.setCellValueFactory(new PropertyValueFactory<>("tel2"));

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

            Proveedor.busquedaDinamicaProveedor(conexion.getConnection(), text, data);

            // Enlazar listas con TableView
            TVProveedor.setItems(data);

            // Enlazar columnas con atributos
            TCID.setCellValueFactory(new PropertyValueFactory<>("IDproveedor"));
            TCNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre_proveedor"));
            TCTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo_proveedor"));
            TCTel1.setCellValueFactory(new PropertyValueFactory<>("tel1"));
            TCTel2.setCellValueFactory(new PropertyValueFactory<>("tel2"));
            onCLickTableview();
            conexion.cerrarConexion();
        }
    }

    @FXML
    public void Limpiar(){
        lblID.setText("");
        txtNombre.setText("");
        cmbTipo.setValue("");
        txtTeléfono1.setText("");
        txtTeléfono2.setText("");
        btnListo.setDisable(false);

    }

    @FXML
    public void LimpiarAgregar(){
        txtIDAg.setText("");
        txtNombreAg.setText("");
        cmbTipoAg.setValue("");
        txtTel1Ag.setText("");
        txtTel2Ag.setText("");
        btnAgregar.setDisable(false);

    }

    public void onCLickTableview(){
        TVProveedor.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Proveedor>() {
                    @Override
                    public void changed(ObservableValue<? extends Proveedor> observable, Proveedor oldValue, Proveedor newValue) {
                        if (newValue != null)
                            lblID.setText(String.valueOf(newValue.getIDproveedor()));
                            txtNombre.setText(newValue.getNombre_proveedor());
                            cmbTipo.setValue(newValue.getTipo_proveedor());
                            txtTeléfono1.setText(newValue.getTel1());
                            txtTeléfono2.setText(newValue.getTel2());
                            //Mostrando los botones
                            btnEliminar.setVisible(true);
                            btnEditar.setVisible(true);
                            btnListo.setVisible(true);
                        }
                }
        );
    }


    @FXML
    public void GuardarRegistro(){
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //Crear una nueva instancia del tipo Proveedor y despues llamar al metodo guardar el registro de proveedor
        Proveedor p = new Proveedor(Integer.valueOf(txtIDAg.getText()), txtNombreAg.getText(),
                cmbTipoAg.getSelectionModel().getSelectedItem(), txtTel1Ag.getText(), txtTel2Ag.getText());

        int resultado = p.AgregarProveedor(conexion.getConnection());

        if(resultado == 1){
            data.add(p);
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setContentText("Registro ha sido agregado con éxito.");
            mensaje.setHeaderText("Resultado");
            mensaje.show();
            LimpiarAgregar();
        }

        conexion.cerrarConexion();
    }

    @FXML
    public void ActualizarRegistro() {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //Crear una nueva instancia del tipo Proveedor y despues llamar al metodo guardar el registro de proveedor
        Proveedor p = new Proveedor(Integer.valueOf(lblID.getText()), txtNombreAg.getText(),
                cmbTipoAg.getSelectionModel().getSelectedItem(), txtTel1Ag.getText(), txtTel2Ag.getText());

        int resultado = p.ModificarProveedor(conexion.getConnection());

        if(resultado == 1){
            data.set(TVProveedor.getSelectionModel().getSelectedIndex(), p);
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro actualizado");
            mensaje.setContentText("Registro ha sido actualizado con éxito.");
            mensaje.setHeaderText("Resultado");
            mensaje.show();
            LimpiarAgregar();
        }

        conexion.cerrarConexion();
    }
}
