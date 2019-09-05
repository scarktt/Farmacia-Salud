package sample.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;
    private final String host = "localhost";
    private final String port = "3306";
    private final String db = "FarmaciaMasSalud";
    private final String user = "root";
    private final String pass = "12345";
    private final String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user="
            + user + "&password=" + pass + "&useSSL=false";

    public Connection getConnection () {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void establecerConexion() {
        connection = null;

        try{
            connection = DriverManager.getConnection(url); // Nos conectamos a la bd

        } catch (SQLException e){
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            System.out.println("Error de conexion: " + e);
        }
    }

    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
