package sample.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;
    private final String user = "root";
    private final String pass = "12345678";
    private final String url = "jdbc:mysql://localhost:3306/FarmaciaMSalud";

    public Connection getConnection () {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void establecerConexion() {
        connection = null;

        try{
            connection = DriverManager.getConnection(url, user, pass); // Nos conectamos a la bd

            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (connection != null){
                System.out.println("Conexion establecida");
            }
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
