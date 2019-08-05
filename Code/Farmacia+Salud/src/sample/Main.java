package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UNDECORATED);//Para que no salgan el minimizar, maximinAr, y cerrar
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Farmacia +Salud");
        primaryStage.setScene(new Scene(root, 1260, 680));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
