package sample.Controlador;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Modelo.Conexion;
import sample.Modelo.Producto;
import sample.Modelo.Proveedor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProveedorControlador implements Initializable {

    @FXML private TableView<List<StringProperty>> TVProveedor;

    @FXML private TableColumn<List<StringProperty>, String> TCID;
    @FXML private TableColumn<List<StringProperty>, String> TCNombre;
    @FXML private TableColumn<List<StringProperty>, String> TCTipo;
    @FXML private TableColumn<List<StringProperty>, String> TCTel1;
    @FXML private TableColumn<List<StringProperty>, String> TCTel2;

    // Colecciones de tipo StringProperty para el TableView
    private ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

       // LoadDataCmbox(conexion);

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
            TCID.setCellValueFactory(data -> data.getValue().get(0));
            TCNombre.setCellValueFactory(data -> data.getValue().get(1));
            TCTipo.setCellValueFactory(data -> data.getValue().get(2));
            TCTel1.setCellValueFactory(data -> data.getValue().get(3));
            TCTel2.setCellValueFactory(data -> data.getValue().get(4));

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
            TCID.setCellValueFactory(data -> data.getValue().get(0));
            TCNombre.setCellValueFactory(data -> data.getValue().get(1));
            TCTipo.setCellValueFactory(data -> data.getValue().get(2));
            TCTel1.setCellValueFactory(data -> data.getValue().get(3));
            TCTel2.setCellValueFactory(data -> data.getValue().get(4));

            conexion.cerrarConexion();
        }

    }

}
