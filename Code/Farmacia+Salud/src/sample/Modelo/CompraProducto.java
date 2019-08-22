package sample.Modelo;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.*;

public class CompraProducto{
    private IntegerProperty FacturaCompraProducto;
    private IntegerProperty FacturaPedido;
    private IntegerProperty IDproducto;
    private Date FechaCompra;
    private FloatProperty MontoCompra;
    private StringProperty ReciboColector;
    private StringProperty Status;
    private StringProperty Observacion;
    private Date FechaVencPago;
    private Proveedor Nombre_proveedor;

    public CompraProducto(int FacturaCompraProducto, int FacturaPedido, int IDproducto,Date FechaCompra,
                          float MontoCompra, String ReciboColector,
                          String Status, String Observacion, Date FechaVencPago
                          //Proveedor Nombre_proveedor
                          ) {
        this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
        this.FacturaPedido = new SimpleIntegerProperty(FacturaPedido);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.FechaCompra = FechaCompra;
        this.MontoCompra = new SimpleFloatProperty(MontoCompra);
        this.ReciboColector = new SimpleStringProperty(ReciboColector);
        this.Status = new SimpleStringProperty(Status);
        this.Observacion = new SimpleStringProperty(Observacion);
        this.FechaVencPago = FechaVencPago;
        //this.Nombre_proveedor = Nombre_proveedor;
    }

    //Metodos atributo: FacturaCompraProducto
    public int getFacturaCompraProducto() {
        return FacturaCompraProducto.get();
    }
    public void setFacturaCompraProducto(int FacturaCompraProducto) {
        this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
    }
    public IntegerProperty FacturaCompraProductoProperty() {
        return FacturaCompraProducto;
    }

    //Metodos atributo: FacturaPedido
    public int getFacturaPedido() {
        return FacturaPedido.get();
    }
    public void setFacturaPedido(int FacturaPedido) {
        this.FacturaPedido = new SimpleIntegerProperty(FacturaPedido);
    }
    public IntegerProperty FacturaPedidoProperty() {
        return FacturaPedido;
    }

    //Metodos atributo: IDproducto
    public int getIDproducto() {
        return IDproducto.get();
    }
    public void setIDproducto(int IDproducto) {
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
    }
    public IntegerProperty IDproductoProperty() {
        return IDproducto;
    }

    //Metodos atributo: FechaCompra
    public Date getFechaCompra() {
        return FechaCompra;
    }
    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }
    public Date FechaCompraProperty() {
        return FechaCompra;
    }

    //Metodos atributo: MontoCompra
    public float getMontoCompra() {
        return MontoCompra.get();
    }
    public void setMontoCompra(float MontoCompra) {
        this.MontoCompra = new SimpleFloatProperty(MontoCompra);
    }
    public FloatProperty MontoCompraProperty() {
        return MontoCompra;
    }

    //Metodos atributo: ReciboColector
    public String getReciboColector() {
        return ReciboColector.get();
    }
    public void setReciboColector(String ReciboColector) {this.ReciboColector = new SimpleStringProperty(ReciboColector);}
    public StringProperty ReciboColectorProperty() {
        return ReciboColector;
    }

    //Metodos atributo: Status
    public String getStatus() {
        return Status.get();
    }
    public void setStatus(String Status) {
        this.Status = new SimpleStringProperty(Status);
    }
    public StringProperty StatusProperty() {
        return Status;
    }

    //Metodos atributo: Observacion
    public String getObservacion() {
        return Observacion.get();
    }
    public void setObservacion(String Observacion) {
        this.Observacion = new SimpleStringProperty(Observacion);
    }
    public StringProperty ObservacionProperty() {
        return Observacion;
    }

    //Metodos atributo: FechaVencPago
    public Date getFechaVencPago() {
        return FechaVencPago;
    }
    public void setFechaVencPago(Date FechaVencPago) {
        this.FechaVencPago = FechaVencPago;
    }
    public Date FechaVencPagoProperty() {
        return FechaVencPago;
    }

    public static void llenarCmbFacturaCompra (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT FacturaCompraProducto FROM CompraProducto";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("FacturaCompraProducto"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Factura de Compra de Producto");
            e.printStackTrace();
        }
    }

    /*public static void busquedaDinamicaFacturaCompra (Connection connection, String busqueda, ObservableList<String> lista) {
        try {
            String query = "SELECT t3.Nombre_proveedor, t2.FacturaCompraProducto " +
                    "FROM CompraProducto t1 INNER JOIN Abono t2 " +
                    "on t1.FacturaCompraProducto = t2.FacturaCompraProducto " +
                    "INNER JOIN Proveedor t3 " +
                    "on t2.IDproveedor = t3.IDproveedor " +
                    "WHERE Nombre_proveedor LIKE '"+busqueda+"%'";
            PreparedStatement statement = connection.prepareStatement(query);
            //statement.setNString(1, busqueda);
            ResultSet resultado = statement.executeQuery();

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("FacturaCompraProducto")
                );
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar Nombre del producto al TableView");
            e.printStackTrace();
        }
    }*/
}