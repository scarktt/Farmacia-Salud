package sample.modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Declaramos la conexion a mysql
    private static Connection connect = null;
    // Declaramos los datos de conexion a la bd
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "12345678";
    private static final String url = "jdbc:mysql://localhost:3306/FarmaciaMSalud";

    // Funcion que va conectarse a mi bd de mysql
    public static void dbConnect() {
        connect = null; // Reseteamos a null la conexion a la bd

        try{
            Class.forName(driver);
            connect = (Connection) DriverManager.getConnection(url, user, pass); // Nos conectamos a la bd

            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (connect != null){
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e){
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            System.out.println("Error de conexion: " + e);
        }
    }
}
