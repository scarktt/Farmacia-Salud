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
    private CompraProducto MontoCompra;
    private CompraProducto ReciboColector;
    private CompraProducto FechaVencPago;

    public Pagos(//int IDPagos, int IDempleado, String TipoPago, float MontoPago, Date FechaPago,
                 Proveedor Nombre_proveedor, CompraProducto MontoCompra)//,CompraProducto ReciboColector,
                 //CompraProducto FechaVencPago )
                 {
        /*this.IDPagos = new SimpleIntegerProperty(IDPagos);
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
        this.TipoPago = new SimpleStringProperty(TipoPago);
        this.MontoPago = new SimpleFloatProperty(MontoPago);
        this.FechaPago = FechaPago;*/
        this.Nombre_proveedor = Nombre_proveedor;
        this.MontoCompra = MontoCompra;
        //this.ReciboColector = ReciboColector;
        //this.FechaVencPago = FechaVencPago;
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

    public static void llenarTVPagoServicio(Connection connection, ObservableList<Pagos> lista){
        try {
            String query = "SELECT P.IDproveedor, P.Tipo_proveedor, P.Nombre_proveedor, P.tel1, P.tel2, \n" +
                    "CP.FacturaCompraProducto, CP.FacturaPedido, CP.IDproducto, CP.FechaCompra, \n" +
                    "CP.MontoCompra, CP.ReciboColector, CP.Status, CP.Observacion, CP.FechaVencPago \n" +
                    "FROM CompraProducto CP INNER JOIN Abono A on \n" +
                    "CP.FacturaCompraProducto = A.FacturaCompraProducto INNER JOIN Proveedor \n" +
                    "P on A.IDProveedor = P.IDProveedor";

            Statement statement = connection.createStatement();
            ResultSet resultado  = statement.executeQuery(query);
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
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}