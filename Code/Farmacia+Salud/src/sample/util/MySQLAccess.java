package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLAccess {
    private static Connection connect = null;

    public static void readDataBase() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/FarmaciaMSalud" + "user=root&password=12345678");

            if (connect != null) {
                System.out.println("Conexion establecida");
            }

        } catch (Exception e) {
            System.out.println("Error de conexion: " + e);
        }

    }

}