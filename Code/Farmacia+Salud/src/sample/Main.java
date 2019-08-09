package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.modelo.Conexion;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);//Para que no salgan el minimizar, maximizAr, y cerrar
        primaryStage.setResizable(false);

        //Iniciamos el layout
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Farmacia +Salud");
        primaryStage.setScene(new Scene(root, 1260, 680));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Conexion.dbConnect();
        launch(args);
    }
}
