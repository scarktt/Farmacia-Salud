package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class Controller {
    //Cierra el programa
    public void pressExit(){
        System.exit(0);
    }
    //Minimiza el programa
    public void pressMin(){
        //setIconified(1);aun no funciona
    }
    //Variables
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtpwd;
    @FXML
    private Button btnInSesion;

    /*Clase para bloquear el boton de iniciar sesion hasta  que en
    las cajas de texto se haya escrito algo*/
    public void keyReleaseProperty(){
        String user = txtuser.getText();
        String password = txtpwd.getText();
        boolean Deshabilitar = (user.isEmpty()|| user.trim().isEmpty()) || (password.isEmpty()|| password.trim().isEmpty());
        btnInSesion.setDisable(Deshabilitar);
    }

}
