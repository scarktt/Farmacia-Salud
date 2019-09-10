package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Proveedor{
    private IntegerProperty IDproveedor;
    private StringProperty Nombre_proveedor;
    private StringProperty Tipo_proveedor;
    private StringProperty tel1;
    private StringProperty tel2;

    public Proveedor(int IDproveedor, String Nombre_proveedor, String Tipo_proveedor,
                     String tel1, String tel2) {
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
        this.Tipo_proveedor = new SimpleStringProperty(Tipo_proveedor);
        this.tel1 = new SimpleStringProperty(tel1);
        this.tel2 = new SimpleStringProperty(tel2);
    }

    //Metodos atributo: IDproveedor
    public int getIDproveedor() {
        return IDproveedor.get();
    }
    public void setIDproveedor(int IDproveedor) {
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
    }
    public IntegerProperty IDproveedorProperty() {
        return IDproveedor;
    }
    //Metodos atributo: Nombre_proveedor
    public String getNombre_proveedor() {
        return Nombre_proveedor.get();
    }
    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
    }
    public StringProperty Nombre_proveedorProperty() {
        return Nombre_proveedor;
    }
    //Metodos atributo: Tipo_proveedor
    public String getTipo_proveedor() {
        return Tipo_proveedor.get();
    }
    public void setTipo_proveedor(String Tipo_proveedor) {
        this.Tipo_proveedor = new SimpleStringProperty(Tipo_proveedor);
    }
    public StringProperty Tipo_proveedorProperty() {
        return Tipo_proveedor;
    }
    //Metodos atributo: tel1
    public String getTel1() {
        return tel1.get();
    }
    public void setTel1(String tel1) {
        this.tel1 = new SimpleStringProperty(tel1);
    }
    public StringProperty Tel1Property() {
        return tel1;
    }
    //Metodos atributo: tel2
    public String getTel2() {
        return tel2.get();
    }
    public void setTel2(String tel2) {
        this.tel2 = new SimpleStringProperty(tel2);
    }
    public StringProperty Tel2Property() {
        return tel2;
    }

    public static void llenarCmbNombresProveedores (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT DISTINCT Nombre_proveedor FROM Proveedor";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Nombre_proveedor"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del proveedor");
            e.printStackTrace();
        }
    }

    public static void llenarCmbTipoProveedores(Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT DISTINCT Tipo_proveedor FROM Proveedor";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Tipo_proveedor"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del proveedor");
            e.printStackTrace();
        }
    }

    public static void busquedaDinamicaProveedor (Connection connection, String busqueda, ObservableList<Proveedor> data) {


        try {
            String query = "SELECT DISTINCT IDproveedor,Nombre_proveedor,Tipo_proveedor,tel1,tel2 FROM Proveedor" +
                    " WHERE Nombre_proveedor LIKE '"+busqueda+"%'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                data.add(
                        new Proveedor (
                            resultado.getInt("IDproveedor"),
                            resultado.getString("Nombre_proveedor"),
                            resultado.getString("Tipo_proveedor"),
                            resultado.getString("tel1"),
                            resultado.getString("tel2")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar las proveedores al TableView");
            e.printStackTrace();
        }
    }

    public int AgregarProveedor(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Proveedor (IDproveedor," +
                    " Nombre_proveedor, Tipo_proveedor, tel1, tel2) VALUES (?,?,?,?,?)");

            statement.setInt(1,IDproveedor.get());
            statement.setString(2 ,Nombre_proveedor.get());
            statement.setString(3 ,Tipo_proveedor.get());
            statement.setString(4 ,tel1.get());
            statement.setString(5 ,tel2.get());
            return statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int ModificarProveedor(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Proveedor SET\n" +
                    " Nombre_proveedor = ?, Tipo_proveedor = ?, tel1 = ?, tel2 = ? " +
                    "where IDproveedor = ?");

            statement.setString(1 ,Nombre_proveedor.get());
            statement.setString(2 ,Tipo_proveedor.get());
            statement.setString(3 ,tel1.get());
            statement.setString(4 ,tel2.get());
            statement.setInt(5,IDproveedor.get());
            return statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }
    }

    public void EliminarProveedor(Connection connection) {

    }
}