package sample.Modelo;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pagos{
    private StringProperty Nombre_proveedor;
    private FloatProperty MontoCompra;
    private StringProperty ReciboColector;
    private StringProperty Observacion;
    private Date FechaVencPago;

    public Pagos(String Nombre_proveedor, float MontoCompra, String ReciboColector, String Observacion, Date FechaVencPago) {
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
        this.MontoCompra = new SimpleFloatProperty(MontoCompra);
        this.ReciboColector = new SimpleStringProperty(ReciboColector);
        this.Observacion = new SimpleStringProperty(Observacion);
        this.FechaVencPago = FechaVencPago;
    }

    //Metodos atributo: IDPagos
    public String getNombre_proveedor() {
        return Nombre_proveedor.get();
    }
    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
    }
    public StringProperty IDPagosProperty() {
        return Nombre_proveedor;
    }

    //Metodos atributo: MontoPago
    public float getMontoCompra() {
        return MontoCompra.get();
    }
    public void setMontoCompra(float MontoCompra) {
        this.MontoCompra = new SimpleFloatProperty(MontoCompra);
    }
    public FloatProperty MontoCompraProperty() {
        return MontoCompra;
    }

    //Metodos atributo: IDempleado
    public String getReciboColector() {
        return ReciboColector.get();
    }
    public void setReciboColector(String ReciboColector) {
        this.ReciboColector = new SimpleStringProperty(ReciboColector); }
    public StringProperty ReciboColectorProperty() {
        return ReciboColector;
    }

    //Metodos atributo: TipoPago
    public String getObservacion() {
        return Observacion.get();
    }
    public void setObservacion(String Observacion) {
        this.Observacion = new SimpleStringProperty(Observacion);
    }
    public StringProperty ObservacionProperty() {
        return Observacion;
    }


    //Metodos atributo: FechaPago
    public Date getFechaPago() {
        return FechaVencPago;
    }
    public void setFechaPago(Date FechaVencPago) {
        this.FechaVencPago = FechaVencPago;
    }
    public Date FechaPagoProperty() {
        return FechaVencPago;
    }

    public static void llenarCmbTipoPago (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT DISTINCT TipoPago FROM Pagos";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("TipoPago"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Tipo de Pago");
            e.printStackTrace();
        }
    }


    public static void busquedaDinamicaDeudasPendientes (Connection connection, String busqueda,
                                                         ObservableList<Pagos> data) {

        try {
            String query = "SELECT t3.Nombre_proveedor, t1.MontoCompra, t1.ReciboColector, t1.Observacion, t1.FechaVencPago " +
                    "FROM Compra t1 INNER JOIN Abono t2 on t1.FacturaCompra = t2.FacturaCompra" +
                    " INNER JOIN Proveedor t3 on t2.IDproveedor = t3.IDproveedor WHERE t3.Nombre_proveedor LIKE '"+busqueda+"%'";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                data.add(
                        new Pagos (
                                resultado.getString("Nombre_proveedor"),
                                resultado.getFloat("MontoCompra"),
                                resultado.getString("ReciboColector"),
                                resultado.getString("Observacion"),
                                resultado.getDate("FechaVencPago")
                        )
                );
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar las deudas pendientes al TableView");
            e.printStackTrace();

            //Si compra 10 cojas, de 100 pone 1000 pastillas

        }
    }
}
