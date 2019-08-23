package sample.Modelo;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Producto {

    public static void llenarCmbForma_farmaceutica (Connection connection, ObservableList<String> lista) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT DISTINCT Forma_farmaceutica FROM Producto");

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Forma_farmaceutica"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace();
        }
    }

    public static void llenarCmbUnidadMedida (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT DISTINCT Unidad_medida FROM Producto";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Unidad_medida"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar unidad de medida");
            e.printStackTrace();
        }
    }

    public static void llenarCmbNombresProductos (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT Nombre FROM Producto";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del producto al combobox");
            e.printStackTrace();
        }
    }

    public static void busquedaDinamicaProducto (Connection connection, String busqueda, int tipo, String proveedor,
                                                 String forma_farmaceutica, int dosis, String unidad_medida, String utilidad,
                                                 String indicacion, boolean generico, ObservableList<List<StringProperty>> data) {
        List<StringProperty> firstRow = new ArrayList<>();

        try {
            CallableStatement cst = connection.prepareCall("{call sp_ConsultaProductoEnFacturacion (?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, tipo);
            cst.setString(2, busqueda);
            cst.setString(3, proveedor);
            cst.setString(4, forma_farmaceutica);
            cst.setInt(5, dosis);
            cst.setString(6, unidad_medida);
            cst.setString(7, utilidad);
            cst.setString(8, indicacion);
            cst.setBoolean(9, generico);

            cst.execute();
            final ResultSet resultado = cst.getResultSet();

            while (resultado.next()) {
                firstRow.add(0, new SimpleStringProperty(resultado.getString("IDproducto")));
                firstRow.add(1, new SimpleStringProperty(resultado.getString("Nombre")));
                firstRow.add(2, new SimpleStringProperty(resultado.getString("Nombre_proveedor")));
                data.add(firstRow);
            }

        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del producto al TableView");
            e.printStackTrace();
        }
    }
}