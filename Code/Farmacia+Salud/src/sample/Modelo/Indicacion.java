package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Indicacion{
    private IntegerProperty IDindicacion;
    private StringProperty Descripcion;

    public Indicacion(int IDindicacion, String Descripcion) {
        this.IDindicacion = new SimpleIntegerProperty(IDindicacion);
        this.Descripcion = new SimpleStringProperty(Descripcion);
    }

    //Metodos atributo: IDindicacion
    public int getIDindicacion() {
        return IDindicacion.get();
    }
    public void setIDindicacion(int IDindicacion) {
        this.IDindicacion = new SimpleIntegerProperty(IDindicacion);
    }
    public IntegerProperty IDindicacionProperty() {
        return IDindicacion;
    }
    //Metodos atributo: Descripcion
    public String getDescripcion() {
        return Descripcion.get();
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = new SimpleStringProperty(Descripcion);
    }
    public StringProperty DescripcionProperty() {
        return Descripcion;
    }

    public static void llenarCmbIndicacion (Connection connection, ObservableList<String> lista) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT Descripcion FROM Indicacion");

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace();
        }
    }
}