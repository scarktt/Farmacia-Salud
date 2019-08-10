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

public class Enfermedad{
    private IntegerProperty IDenfermedad;
    private StringProperty Descripcion;

    public Enfermedad(int IDenfermedad, String Descripcion) {
        this.IDenfermedad = new SimpleIntegerProperty(IDenfermedad);
        this.Descripcion = new SimpleStringProperty(Descripcion);
    }

    //Metodos atributo: IDenfermedad
    public int getIDenfermedad() {
        return IDenfermedad.get();
    }
    public void setIDenfermedad(int IDenfermedad) {
        this.IDenfermedad = new SimpleIntegerProperty(IDenfermedad);
    }
    public IntegerProperty IDenfermedadProperty() {
        return IDenfermedad;
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

    public static void llenarCmbEnfermedad (Connection connection, ObservableList<String> lista) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT Descripcion FROM Enfermedad");

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