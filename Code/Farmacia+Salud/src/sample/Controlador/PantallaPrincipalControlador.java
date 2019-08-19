package sample.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Modelo.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPrincipalControlador implements Initializable {

    @FXML private AnchorPane Contenedor;
    @FXML private AnchorPane APUser;
    @FXML private AnchorPane APNotificacion;
    @FXML private AnchorPane APConfiguracion;
    @FXML private AnchorPane APRol;
    @FXML private AnchorPane APCerrarSesion;
    //Botones de arriiba
    @FXML private AnchorPane APBotonesFacturacion;
    @FXML private AnchorPane APBotonesPedido;
    @FXML private AnchorPane APBotonesCompra;
    @FXML private AnchorPane APBotonesProducto;
    @FXML private AnchorPane APBotonesPagoServicio;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        APConfiguracion.setVisible(true);
        APRol.setVisible(true);
        APCerrarSesion.setVisible(true);
    }
    public void pressNotificacion(MouseEvent event) { APNotificacion.setVisible(true); APNotificacion.setVisible(true);}

    //Oculta el panel de usuario o notificacion
    public void exitUsuario(MouseEvent event) { APUser.setVisible(false);}
    public void exitNotificacion(MouseEvent event) { APNotificacion.setVisible(false);}

    public void pressCerrarSesion(MouseEvent event) throws IOException {
        //No funciona
    }

    //Muestra en pantalla la ventana de facturacion
    @FXML
    public void pressFacturacion(ActionEvent event) throws IOException {
        AnchorPane APFacturacion = FXMLLoader.load(getClass().getResource("/sample/Vista/Facturacion.fxml"));
        Contenedor.getChildren().setAll(APFacturacion);
        APBotonesFacturacion.setVisible(true);
        APBotonesCompra.setVisible(false);
        APBotonesPedido.setVisible(false);
        APBotonesProducto.setVisible(false);
        APBotonesPagoServicio.setVisible(false);
    }

    //Muestra en pantalla la ventana de detalle factura
    @FXML
    public void pressDetalleFactura(ActionEvent event) throws IOException{
        AnchorPane APDetalleFactura = FXMLLoader.load(getClass().getResource("/sample/Vista/DetalleFactura.fxml"));
        Contenedor.getChildren().setAll(APDetalleFactura);
    }

    //Muestra en pantalla la ventana de historico de ventas
    @FXML
    public void pressHistoricoVentas ( ActionEvent event) throws IOException{
        AnchorPane APHistoricoVentas = FXMLLoader.load(getClass().getResource("/sample/Vista/HistoricoVentas.fxml"));
        Contenedor.getChildren().setAll(APHistoricoVentas);
    }


    //Muestra en pantalla la ventana de compras
    @FXML
    public void pressCompras( ActionEvent event) throws IOException {
        AnchorPane APCompra = FXMLLoader.load(getClass().getResource("/sample/Vista/Compra.fxml"));
        Contenedor.getChildren().setAll(APCompra);
        APBotonesCompra.setVisible(true);
        APBotonesPedido.setVisible(false);
        APBotonesProducto.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPagoServicio.setVisible(false);
    }

    //Muestra en pantalla la ventana de compras2
    @FXML
    public void pressCompras2(ActionEvent event) throws IOException {
        AnchorPane APCompra2 = FXMLLoader.load(getClass().getResource("/sample/Vista/Compra2.fxml"));
        Contenedor.getChildren().setAll(APCompra2);
    }

    //Muestra en pantalla la ventana de DetalleCompra
    @FXML
    public void pressDetalleCompra(ActionEvent event) throws IOException{
        AnchorPane APDetalleCompra = FXMLLoader.load(getClass().getResource("/sample/Vista/DetalleCompra.fxml"));
        Contenedor.getChildren().setAll(APDetalleCompra );
    }

    //Muestra en pantalla la ventana de HistoricoCompra
    @FXML
    public void pressHistoricoCompra(ActionEvent event) throws IOException {
        AnchorPane APHistoricoCompras = FXMLLoader.load(getClass().getResource("/sample/Vista/HictoricoCompras.fxml"));
        Contenedor.getChildren().setAll(APHistoricoCompras);
    }

    //Muestra en pantalla la ventana de pedido
    @FXML
    public void pressPedido(ActionEvent event) throws IOException{
        AnchorPane APPedido = FXMLLoader.load(getClass().getResource("/sample/Vista/Pedido.fxml"));
        Contenedor.getChildren().setAll(APPedido );
        APBotonesPedido.setVisible(true);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesProducto.setVisible(false);
        APBotonesPagoServicio.setVisible(false);
    }

    //Muestra en pantalla la ventana de Detallepedido
    @FXML
    public void pressDetallePedido(ActionEvent event) throws IOException{
        AnchorPane APDetallePedido = FXMLLoader.load(getClass().getResource("/sample/Vista/DetallePedido.fxml"));
        Contenedor.getChildren().setAll(APDetallePedido );
    }

    //Muestra en pantalla la ventana de Historicopedido
    @FXML
    public void pressHistoricoPedido(ActionEvent event) throws IOException{
        AnchorPane APHistoricoPedido = FXMLLoader.load(getClass().getResource("/sample/Vista/HistoricoPedido.fxml"));
        Contenedor.getChildren().setAll(APHistoricoPedido);
    }

    //Muestra en pantalla la ventana de producto
    @FXML
   public void pressProducto(ActionEvent event) throws IOException{
        AnchorPane APProducto = FXMLLoader.load(getClass().getResource("/sample/Vista/Producto.fxml"));
        Contenedor.getChildren().setAll(APProducto);
        APBotonesProducto.setVisible(true);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPedido.setVisible(false);
        APBotonesPagoServicio.setVisible(false);
    }

    @FXML
    public void pressAgregarProducto(ActionEvent event) throws IOException{
        AnchorPane  APAgregarProducto  = FXMLLoader.load(getClass().getResource("/sample/Vista/AgregarProducto.fxml"));
        Contenedor.getChildren().setAll( APAgregarProducto);
    }

    @FXML
    public void pressReducirStock(ActionEvent event) throws IOException{
        AnchorPane APReduciStock= FXMLLoader.load(getClass().getResource("/sample/Vista/ReducirStock.fxml"));
        Contenedor.getChildren().setAll(APReduciStock);
    }

    //Muestra en pantalla la ventana de Historicoproducto
    @FXML
    public void pressHistoricoPerdida(ActionEvent event) throws IOException{
        AnchorPane APHistoricoProducto  = FXMLLoader.load(getClass().getResource("/sample/Vista/HistoricoProducto.fxml"));
        Contenedor.getChildren().setAll(APHistoricoProducto );
    }

    //Muestra en pantalla la ventana de proveedor
    @FXML
    public void pressProvedor(ActionEvent event) throws IOException{
        AnchorPane APProveedor = FXMLLoader.load(getClass().getResource("/sample/Vista/Proveedor.fxml"));
        Contenedor.getChildren().setAll(APProveedor);
        APBotonesProducto.setVisible(false);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPedido.setVisible(false);
        APBotonesPagoServicio.setVisible(false);
    }

    //Muestra en pantalla la ventana de pago servicios
    @FXML
    public void pressPagoServicio(ActionEvent event) throws IOException{
        AnchorPane APPagoServicio = FXMLLoader.load(getClass().getResource("/sample/Vista/PagoServicio.fxml"));
        Contenedor.getChildren().setAll(APPagoServicio);
        APBotonesPagoServicio.setVisible(true);
        APBotonesProducto.setVisible(false);
        APBotonesCompra.setVisible(false);
        APBotonesFacturacion.setVisible(false);
        APBotonesPedido.setVisible(false);
    }

    //Muestra en pantalla la ventana de historico servicios
    @FXML
    public void pressHistoricoPago(ActionEvent event) throws IOException{
        AnchorPane APHistoricoPagos  = FXMLLoader.load(getClass().getResource("/sample/Vista/HistoricoPagos.fxml"));
        Contenedor.getChildren().setAll(APHistoricoPagos );
    }
}
