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
    private StringProperty Tipo_proveedor;
    private StringProperty Nombre_proveedor;
    private StringProperty tel1;
    private StringProperty tel2;

    public Proveedor(int IDproveedor, String Tipo_proveedor, String Nombre_proveedor,
                     String tel1, String tel2) {
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.Tipo_proveedor = new SimpleStringProperty(Tipo_proveedor);
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
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

    public static void busquedaDinamicaProveedor (Connection connection, String busqueda, ObservableList<List<StringProperty>> data) {
        List<StringProperty> Row = new ArrayList<>();

        try {
            String query = "SELECT DISTINCT IDproveedor,Nombre_proveedor,Tipo_proveedor,tel1,tel2 FROM Proveedor" +
                    " WHERE Nombre_proveedor LIKE '"+busqueda+"%'";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                Row.add(0, new SimpleStringProperty(resultado.getString("IDproveedor")));
                Row.add(1, new SimpleStringProperty(resultado.getString("Nombre_proveedor")));
                Row.add(2, new SimpleStringProperty(resultado.getString("Tipo_proveedor")));
                Row.add(3, new SimpleStringProperty(resultado.getString("tel1")));
                Row.add(4, new SimpleStringProperty(resultado.getString("tel2")));
                System.out.println(Row);
                data.add(Row);
                System.out.println(data);
                System.out.println("---------");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar las deudas pendientes al TableView");
            e.printStackTrace();

            //Si compra 10 cojas, de 100 pone 1000 pastillas

        }
    }

}


/*LA caja de 100 la venden en 80 por ejeplo, dependiendo
precio de venta es con el 30%
        es el precio final que se le vende, pero no hacen eso con pastillas porque sale no favorable, con 30%*/