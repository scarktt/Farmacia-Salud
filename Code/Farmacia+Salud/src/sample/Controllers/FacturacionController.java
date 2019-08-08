package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

public class FacturacionController {

    @FXML private AnchorPane APUser;
    @FXML private AnchorPane APNotificacion;
    @FXML private AnchorPane APFacturacion;
    @FXML private AnchorPane APBotonesFacturacion;
    @FXML private AnchorPane APDetalleFactura;
    @FXML private AnchorPane APHistoricoVentas;
    @FXML private AnchorPane APCompras;
    @FXML private AnchorPane APCompras2;
    @FXML private AnchorPane APBotonesCompra;

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
