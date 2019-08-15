package sample.Controlador;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacturacionControlador implements Initializable {

    @FXML private AnchorPane APUser;
    @FXML private AnchorPane APNotificacion;
    @FXML private AnchorPane APVenta;
    @FXML private AnchorPane APFacturacion;
    @FXML private AnchorPane APDetalleFactura;
    @FXML private AnchorPane APHistoricoVentas;
    @FXML private AnchorPane APCompra;
    @FXML private AnchorPane APCompras;
    @FXML private AnchorPane APCompras2;
    @FXML private AnchorPane APDetalleCompra;
    @FXML private AnchorPane APHistoricoCompras;
    @FXML private AnchorPane APPedido;
    @FXML private AnchorPane APPedidos;
    @FXML private AnchorPane APDetallePedido;
    @FXML private AnchorPane APHistoricoPedidos;
    @FXML private AnchorPane APProducto;
    @FXML private AnchorPane APProductos;
    @FXML private AnchorPane APHistoricoProducto;
    // Botones de arriba
    @FXML private AnchorPane APBotonesFacturacion;
    @FXML private AnchorPane APBotonesPedido;
    @FXML private AnchorPane APBotonesCompra;
    @FXML private AnchorPane APBotonesProducto;
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

    //Muestra en pantalla el panel de Usuario o notificacion
    public void pressUsuario(MouseEvent event) {
        APUser.setVisible(true);
    }

    public void pressNotificacion(MouseEvent event) {
        APNotificacion.setVisible(true);
    }

    //Oculta el panel de usuario o notificacion
    public void exitUsuario(MouseEvent event) {
        APUser.setVisible(false);
    }

    public void exitNotificacion(MouseEvent event) {
        APNotificacion.setVisible(false);
    }

    public void pressCerrarSesion(MouseEvent event) throws IOException {
        //No funciona
    }

    //Muestra en pantalla la ventana de facturacion
    public void pressFacturacion(MouseEvent event) {
        APVenta.setVisible(true);
        APBotonesFacturacion.setVisible(true);
        APFacturacion.setVisible(true);
        APHistoricoVentas.setVisible(false);
        APDetalleFactura.setVisible(false);
        APCompra.setVisible(false);
        APCompras.setVisible(false);
        APBotonesCompra.setVisible(false);
        APCompras2.setVisible(false);
        APDetalleCompra.setVisible(false);
        APHistoricoCompras.setVisible(false);
        APPedidos.setVisible(false);
        APPedido.setVisible(false);
        APDetallePedido.setVisible(false);
        APHistoricoPedidos.setVisible(false);
        APProductos.setVisible(false);
        APProducto.setVisible(false);
        APBotonesCompra.setVisible(false);
        APBotonesPedido.setVisible(false);
        APBotonesProducto.setVisible(false);

    }

    //Muestra en pantalla la ventana de detalle factura
    public void pressDetalleFactura(MouseEvent event) {
        APDetalleFactura.setVisible(true);
        APFacturacion.setVisible(false);
        APHistoricoVentas.setVisible(false);
    }

    //Muestra en pantalla la ventana de historico de ventas
    public void pressHistoricoVentas(MouseEvent event) {
        APHistoricoVentas.setVisible(true);
        APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false);
    }


    //Muestra en pantalla la ventana de compras
    public void pressCompras(MouseEvent event) {
        APCompra.setVisible(true);
        APBotonesCompra.setVisible(true);
        APCompras.setVisible(true);
        APVenta.setVisible(false);
        APHistoricoVentas.setVisible(false);
        APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false);
        APCompras2.setVisible(false);
        APDetalleCompra.setVisible(false);
        APHistoricoCompras.setVisible(false);
        APPedidos.setVisible(false);
        APPedido.setVisible(false);
        APDetallePedido.setVisible(false);
        APHistoricoPedidos.setVisible(false);
        APHistoricoPedidos.setVisible(false);
        APProductos.setVisible(false);
        APProducto.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPedido.setVisible(false);
        APBotonesProducto.setVisible(false);
    }

    //Muestra en pantalla la ventana de compras2
    public void pressCompras2(MouseEvent event) {
        APCompras2.setVisible(true);
        APDetalleCompra.setVisible(false);
        APHistoricoCompras.setVisible(false);
        APCompras.setVisible(false);
    }

    //Muestra en pantalla la ventana de DetalleCompra
    public void pressDetalleCompra(MouseEvent event) {
        APDetalleCompra.setVisible(true);
        APHistoricoCompras.setVisible(false);
        APCompras2.setVisible(false);
        APCompras.setVisible(false);
    }

    //Muestra en pantalla la ventana de HistoricoCompra
    public void pressHistoricoCompra(MouseEvent event) {
        APHistoricoCompras.setVisible(true);
        APCompras2.setVisible(false);
        APCompras.setVisible(false);
        APDetalleCompra.setVisible(false);
    }

    //Muestra en pantalla la ventana de pedido
    public void pressPedido(MouseEvent event) {
        APPedidos.setVisible(true);
        APPedido.setVisible(true);
        APBotonesPedido.setVisible(true);
        APDetallePedido.setVisible(false);
        APHistoricoPedidos.setVisible(false);
        APBotonesCompra.setVisible(false);
        APVenta.setVisible(false);
        APHistoricoVentas.setVisible(false);
        APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false);
        APCompra.setVisible(false);
        APCompras.setVisible(false);
        APCompras2.setVisible(false);
        APDetalleCompra.setVisible(false);
        APHistoricoCompras.setVisible(false);
        APProductos.setVisible(false);
        APProducto.setVisible(false);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesProducto.setVisible(false);
    }

    //Muestra en pantalla la ventana de Detallepedido
    public void pressDetallePedido(MouseEvent event) {
        APDetallePedido.setVisible(true);
        APHistoricoPedidos.setVisible(false);
        APPedidos.setVisible(false);
    }

    //Muestra en pantalla la ventana de Historicopedido
    public void pressHistoricoPedido(MouseEvent event) {
        APHistoricoPedidos.setVisible(true);
        APPedidos.setVisible(false);
        APDetallePedido.setVisible(false);
    }

    //Muestra en pantalla la ventana de producto
    public void pressProducto(MouseEvent event) {
        APProductos.setVisible(true);
        APProducto.setVisible(true);
        APBotonesProducto.setVisible(true);
        APBotonesCompra.setVisible(false);
        APVenta.setVisible(false);
        APHistoricoVentas.setVisible(false);
        APDetalleFactura.setVisible(false);
        APFacturacion.setVisible(false);
        APCompra.setVisible(false);
        APCompras.setVisible(false);
        APCompras2.setVisible(false);
        APDetalleCompra.setVisible(false);
        APPedidos.setVisible(false);
        APPedido.setVisible(false);
        APDetallePedido.setVisible(false);
        APHistoricoPedidos.setVisible(false);
        APHistoricoCompras.setVisible(false);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPedido.setVisible(false);
    }

    //Muestra en pantalla la ventana de Historicoproducto
    public void pressHistoricoProducto(MouseEvent event) {
        APHistoricoProducto.setVisible(true);
        APProductos.setVisible(false);
        APDetallePedido.setVisible(false);
    }

    public TextField getTxtBuscar() {
        return txtBuscar;
    }

    public void handleKeyReleased(KeyEvent keyEvent) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        Producto.busquedaDinamicaProducto(conexion.getConnection(), keyEvent.getText(), listaNombreProducto);

        // Enlazar listas con TableView
        TVAgregarProductos.setItems(listaNombreProducto);

        // Enlazar columnas con atributos
        TCProducto.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

        conexion.cerrarConexion();
    }
}
