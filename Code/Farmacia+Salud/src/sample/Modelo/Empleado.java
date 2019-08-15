package sample.Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import java.lang.String;

import java.sql.*;

public class Empleado{
    private IntegerProperty IDempleado;
    private StringProperty CedulaEmpleado;
    private StringProperty Nombre;
    private StringProperty Usuario;
    private StringProperty Pass;

    public Empleado(int IDempleado, String CedulaEmpleado, String Nombre, String Usuario, String Pass) {
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
        this.CedulaEmpleado = new SimpleStringProperty(CedulaEmpleado);
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Usuario = new SimpleStringProperty(Usuario);
        this.Pass = new SimpleStringProperty(Pass);
    }

    public Empleado(String Nombre) {
        this.Nombre = new SimpleStringProperty(Nombre);
    }

    //Metodos atributo: IDempleado
    public int getIDempleado() {
        return IDempleado.get();
    }
    public void setIDempleado(int IDempleado) {
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
    }
    public IntegerProperty IDempleadoProperty() {
        return IDempleado;
    }
    //Metodos atributo: CedulaEmpleado
    public String getCedulaEmpleado() {
        return CedulaEmpleado.get();
    }
    public void setCedulaEmpleado(String CedulaEmpleado) {
        this.CedulaEmpleado = new SimpleStringProperty(CedulaEmpleado);
    }
    public StringProperty CedulaEmpleadoProperty() {
        return CedulaEmpleado;
    }
    //Metodos atributo: Nombre
    public String getNombre() {
        return Nombre.get();
    }
    public void setNombre(String Nombre) {
        this.Nombre = new SimpleStringProperty(Nombre);
    }
    public StringProperty NombreProperty() {
        return Nombre;
    }
    //Metodos atributo: Usuario
    public String getUsuario() {
        return Usuario.get();
    }
    public void setUsuario(String Usuario) {
        this.Usuario = new SimpleStringProperty(Usuario);
    }
    public StringProperty UsuarioProperty() {
        return Usuario;
    }
    //Metodos atributo: Pass
    public String getPass() {
        return Pass.get();
    }
    public void setPass(String Pass) {
        this.Pass = new SimpleStringProperty(Pass);
    }
    public StringProperty PassProperty() {
        return Pass;
    }

    // NOTA: Nunca, nunca soberescribir la clase con el metodo toString.
    // ya que por ejemplo sólo se puede retornar uno de los atributos
    /*@Override
    public String toString () {
        return Nombre.get();
    }*/

    public static void llenarCmbNombresEmpleado (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT Nombre FROM Empleado";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del empleado al combobox");
            e.printStackTrace();
        }
    }
}