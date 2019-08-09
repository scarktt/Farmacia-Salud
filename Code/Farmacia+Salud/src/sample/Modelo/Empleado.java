package sample.Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import java.lang.String;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    @Override
    public String toString () {
        return Nombre.get();
    }

    public static void llenarInformacion (Connection connection, ObservableList<Empleado> lista) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT IDempleado, CedulaEmpleado,Nombre,Usuario,Pass FROM Empleado");

            while (resultado.next()) {
                lista.add(
                        new Empleado(
                            resultado.getInt("IDempleado"),
                            resultado.getString("CedulaEmpleado"),
                            resultado.getString("Nombre"),
                            resultado.getString("Usuario"),
                            resultado.getString("Pass")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}