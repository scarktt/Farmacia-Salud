package sample.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Modelo.Conexion;
import sample.Modelo.Empleado;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacturacionControlador implements Initializable {

    @FXML private AnchorPane APUser;
    @FXML private AnchorPane APNotificacion;
    @FXML private AnchorPane APFacturacion;
    @FXML private AnchorPane APBotonesFacturacion;
    @FXML private AnchorPane APDetalleFactura;
    @FXML private AnchorPane APHistoricoVentas;
    @FXML private AnchorPane APCompras;
    @FXML private AnchorPane APCompras2;
    @FXML private AnchorPane APBotonesCompra;
    @FXML private ComboBox<Empleado> cmbVendidoPor;

    private ObservableList<Empleado> ListaVendedores;

    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        conexion = new Conexion();
        conexion.establecerConexion();

        // Inicializar listas
        ListaVendedores = FXCollections.observableArrayList();

        //LLenar listas
        Empleado.llenarInformacion(conexion.getConnection(), ListaVendedores);

        //Enlazar listas con ComboBox y TableView
        cmbVendidoPor.setItems(ListaVendedores);

        conexion.cerrarConexion();
    }

    //Cierra el programa
    public void pressExit(){
        System.exit(0);
    }
    //Minimiza el programa
    public void pressMin(){
        //setIconified(1);aun no funciona
    }

    //Muestra en pantalla el panel de Usuario o notificacion
    public void pressUsuario(MouseEvent event) {
        APUser.setVisible(true);
    }
    public void pressNotificacion(MouseEvent event) { APNotificacion.setVisible(true);}

    //Oculta el panel de usuario o notificacion
    public void exitUsuario(MouseEvent event) { APUser.setVisible(false);}
    public void exitNotificacion(MouseEvent event) { APNotificacion.setVisible(false);}

    public void pressCerrarSesion(MouseEvent event) throws IOException {
        //No funciona
    }

    //Muestra en pantalla la ventana de facturacion
    public void pressFacturacion(MouseEvent event) {
        APFacturacion.setVisible(true); APBotonesFacturacion.setVisible(true);
        APDetalleFactura.setVisible(false); APHistoricoVentas.setVisible(false);
        APCompras.setVisible(false); APBotonesCompra.setVisible(false);
        APCompras2.setVisible(false);
    }

    //Muestra en pantalla la ventana de detalle factura
    public void pressDetalleFactura(MouseEvent event) {
      APDetalleFactura.setVisible(true);
      APFacturacion.setVisible(false); APHistoricoVentas.setVisible(false);
        APCompras.setVisible(false); APCompras2.setVisible(false);
    }

    //Muestra en pantalla la ventana de historico de ventas
    public void pressHistoricoVentas(MouseEvent event) {
        APHistoricoVentas.setVisible(true);
        APDetalleFactura.setVisible(false); APFacturacion.setVisible(false);
        APCompras.setVisible(false); APCompras2.setVisible(false);
    }

    //Muestra en pantalla la ventana de compras
    public void pressCompras(MouseEvent event) {
        APCompras.setVisible(true); APBotonesCompra.setVisible(true);
        APHistoricoVentas.setVisible(false);APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false); APBotonesFacturacion.setVisible(false);
        APCompras2.setVisible(false);
    }

    //Muestra en pantalla la ventana de compras2
    public void pressCompras2(MouseEvent event) {
        APCompras2.setVisible(true);
        APHistoricoVentas.setVisible(false);APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false); APBotonesFacturacion.setVisible(false);
        APCompras.setVisible(false);
    }
}
