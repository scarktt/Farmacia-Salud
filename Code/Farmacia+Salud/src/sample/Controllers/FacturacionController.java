package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML private AnchorPane APBotones;

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

    public void pressFacturacion(MouseEvent event) { APFacturacion.setVisible(true); APBotones.setVisible(true);}

}
