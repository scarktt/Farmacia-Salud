package sample.Modelo;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import java.sql.*;

public class Producto {

    private StringProperty Nombre;
    private StringProperty NombreProveedor;
    private StringProperty FormaFarmaceutica;
    private StringProperty Dosis;

    public Producto (String Nombre, String NombreProveedor, String FormaFarmaceutica,
    String Dosis) {
        this.Nombre = new SimpleStringProperty(Nombre);
        this.NombreProveedor = new SimpleStringProperty(NombreProveedor);
        this.FormaFarmaceutica = new SimpleStringProperty(FormaFarmaceutica);
        this.Dosis = new SimpleStringProperty(Dosis);
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
    //Metodos atributo: NombreProveedor
    public String getNombreProveedor() {
        return NombreProveedor.get();
    }
    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = new SimpleStringProperty(NombreProveedor);
    }
    public StringProperty NombreProveedorProperty() {
        return NombreProveedor;
    }
    //Metodos atributo: FormaFarmaceutica
    public String getFormaFarmaceutica() {
        return FormaFarmaceutica.get();
    }
    public void setFormaFarmaceutica(String FormaFarmaceutica) {
        this.FormaFarmaceutica = new SimpleStringProperty(FormaFarmaceutica);
    }
    public StringProperty FormaFarmaceuticaProperty() {
        return FormaFarmaceutica;
    }
    //Metodos atributo: Dosis
    public String getDosis() {
        return Dosis.get();
    }
    public void setDosis(String Dosis) {
        this.Dosis = new SimpleStringProperty(Dosis);
    }
    public StringProperty DosisProperty() {
        return Dosis;
    }

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

    public static void CargarProductos (Connection connection, ObservableList<Producto> data) {

        try {
            String query =
                    "SELECT p.Nombre, p.Forma_farmaceutica, prv.Nombre_proveedor, p.Dosis_Contenido " +
                            "FROM InventarioProducto invp " +
                            "INNER JOIN Producto p ON invp.IDproducto = p.IDproducto " +
                            "INNER JOIN Compra c ON invp.FacturaCompra = c.FacturaCompra " +
                            "INNER JOIN Proveedor prv ON c.IDproveedor = prv.IDproveedor ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                data.add(
                        new Producto (
                                resultado.getString("Nombre"),
                                resultado.getString("Nombre_proveedor"),
                                resultado.getString("Forma_farmaceutica"),
                                resultado.getString("Dosis_Contenido")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al agregar los datos");
            e.printStackTrace();
        }
    }
}
