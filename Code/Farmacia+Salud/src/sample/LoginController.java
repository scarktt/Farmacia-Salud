package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {


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

    @FXML
    public void IniciarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Vista/PantallaPrincipal.fxml"));//Se carga la siguiente pantalla
        Stage stage = new Stage();//Se crea un nuevo escenario
        Scene scene = new Scene(root, 1260, 680);//Se crea una nueva escena y se indica que tendrá la vista cargada previamente
        stage.setScene(scene);//Se carga el nuevo escenario
        stage.initStyle(StageStyle.UNDECORATED);//Para que no salgan el minimizar, maximinAr, y cerrar
        stage.setResizable(false);//Para que no se pueda redimensionar
        stage.
        stage.show();//Muestra el nuevo escenario
        ((Node) (event.getSource())).getScene().getWindow().hide();//Oculta la ventana actual
    }
}