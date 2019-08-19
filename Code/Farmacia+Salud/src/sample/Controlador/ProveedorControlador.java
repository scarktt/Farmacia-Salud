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
import sample.Modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProveedorControlador implements Initializable {
    //Combobox
    @FXML private ComboBox cmbTipo;
    @FXML private ComboBox cmbTipo1;
    @FXML private ComboBox cmbTipoAg;
    //Textbox
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono1;
    @FXML private TextField txtTelefono2;
    @FXML private TextField txtNombreAg;
    @FXML private TextField txtTel1;
    @FXML private TextField txtTel2;
    //TableView
    @FXML private TableView TVProveedor;
    //Table column
    @FXML private TableColumn<String, String> TCNombre;

    // Colecciones de tipo String
    private ObservableList<String> listaTipo = FXCollections.observableArrayList();
    // Colecciones de tipo Objeto
    private ObservableList<String> listaNombreProveedor = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //LLenar listas
        Proveedor.llenarCmbTipoProveedores(conexion.getConnection(), listaTipo);

        // Enlazar listas con ComboBox
        cmbTipo.setItems(listaTipo);
        cmbTipo1.setItems(listaTipo);
        cmbTipoAg.setItems(listaTipo);

        conexion.cerrarConexion();
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
            listaNombreProveedor.clear();

            Proveedor.busquedaDinamicaProveedor(conexion.getConnection(), text, listaNombreProveedor);

            // Enlazar listas con TableView
            TVProveedor.setItems(listaNombreProveedor);

            // Enlazar columnas con atributos
            TCNombre.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            conexion.cerrarConexion();

        } else {

            // Si la longitud del texto es cero, se le establece como cadena vacia. Si no, se resta un caracter
            // del texto. (Esto tiene la finalidad de no activar la excepcion de que la longitud de la cadena
            // sea un numero negativo)
            if (text.length() == 0) {
                text = "";
                listaNombreProveedor.clear();

            } else {
                text = text.substring(0, text.length() - 1);
                listaNombreProveedor.clear();
            }

            Proveedor.busquedaDinamicaProveedor(conexion.getConnection(), text, listaNombreProveedor);

            // Enlazar listas con TableView
            TVProveedor.setItems(listaNombreProveedor);

            // Enlazar columnas con atributos
            TCNombre.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            conexion.cerrarConexion();
        }

    }

}
