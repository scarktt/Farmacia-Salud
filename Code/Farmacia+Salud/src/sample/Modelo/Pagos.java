package sample.Modelo;


import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.*;

public class Pagos{
    private IntegerProperty IDPagos;
    private IntegerProperty IDempleado;
    private StringProperty TipoPago;
    private FloatProperty MontoPago;
    private Date FechaPago;
    private Proveedor Nombre_proveedor;
    private CompraProducto FacturaCompraProducto;

    public Pagos(//int IDPagos, int IDempleado, String TipoPago, float MontoPago, Date FechaPago
                  Proveedor Nombre_proveedor, CompraProducto FacturaCompraProducto) {
        //this.IDPagos = new SimpleIntegerProperty(IDPagos);
        //this.IDempleado = new SimpleIntegerProperty(IDempleado);
        //this.TipoPago = new SimpleStringProperty(TipoPago);
        //this.MontoPago = new SimpleFloatProperty(MontoPago);
        //this.FechaPago = FechaPago;
        this.Nombre_proveedor = Nombre_proveedor;
        this.FacturaCompraProducto = FacturaCompraProducto;
    }

    //Metodos atributo: IDPagos
    public int getIDPagos() {
        return IDPagos.get();
    }
    public void setIDPagos(int IDPagos) {
        this.IDPagos = new SimpleIntegerProperty(IDPagos);
    }
    public IntegerProperty IDPagosProperty() {
        return IDPagos;
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

    //Metodos atributo: TipoPago
    public String getTipoPago() {
        return TipoPago.get();
    }
    public void setTipoPago(String TipoPago) {
        this.TipoPago = new SimpleStringProperty(TipoPago);
    }
    public StringProperty TipoPagoProperty() {
        return TipoPago;
    }

    //Metodos atributo: MontoPago
    public float getMontoPago() {
        return MontoPago.get();
    }
    public void setMontoPago(float MontoPago) {
        this.MontoPago = new SimpleFloatProperty(MontoPago);
    }
    public FloatProperty MontoPagoProperty() {
        return MontoPago;
    }

    //Metodos atributo: FechaPago
    public Date getFechaPago() {
        return FechaPago;
    }
    public void setFechaPago(Date FechaPago) {
        this.FechaPago = FechaPago;
    }
    public Date FechaPagoProperty() {
        return FechaPago;
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

    public static void busquedaDinamicaDeudasPendientes (Connection connection, String busqueda, ObservableList<Pagos> lista) {
        try {
            String query = "SELECT t3.IDproveedor, t3.Tipo_proveedor, t3.Nombre_proveedor, t3.tel1, t3.tel2," +
                    "t1.FacturaCompraProducto, t1.FacturaPedido, t1.IDproducto, t1.FechaCompra, t1.MontoCompra," +
                    "t1.ReciboColector, t1.Status, t1.Observacion, t1.FechaVencPago  " +
                    "FROM CompraProducto t1 " +
                    "INNER JOIN Abono t2 on t1.FacturaCompraProducto = t2.FacturaCompraProducto " +
                    "INNER JOIN Proveedor t3 on t2.IDproveedor = t3.IDproveedor " +
                    "WHERE t3.Nombre_proveedor LIKE '"+busqueda+"%'";
            PreparedStatement statement = connection.prepareStatement(query);
            //statement.setNString(1, busqueda);
            ResultSet resultado = statement.executeQuery();

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(new Pagos (
                        new Proveedor (
                                resultado.getInt("IDproveedor"),
                                resultado.getString("Tipo_proveedor"),
                                resultado.getString("Nombre_proveedor"),
                                resultado.getString("tel1"),
                                resultado.getString("tel2")
                        ), new CompraProducto(
                                resultado.getInt("FacturaCompraProducto"),
                                resultado.getInt("FacturaPedido"),
                                resultado.getInt("IDproducto"),
                                resultado.getDate("FechaCompra"),
                                resultado.getFloat("MontoCompra"),
                                resultado.getString("ReciboColector"),
                                resultado.getString("Status"),
                                resultado.getString("Observacion"),
                                resultado.getDate("FechaVencPago")
                        )
                ));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del producto al TableView");
            e.printStackTrace();
        }
    }
}