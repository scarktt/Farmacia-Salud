package sample.Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

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
            String query = "SELECT Descripcion FROM Enfermedad";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Descripcion de la enfermedad al combobox");
            e.printStackTrace();
        }
    }
}