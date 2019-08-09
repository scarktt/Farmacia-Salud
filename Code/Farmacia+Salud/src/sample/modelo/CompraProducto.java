package sample.modelo;

import javafx.beans.property.*;

import java.sql.Date;

public class CompraProducto{
    private IntegerProperty FacturaCompraProducto;
    private IntegerProperty FacturaPedido;
    private IntegerProperty IDproducto;
    private Date FechaCompra;
    private FloatProperty MontoCompra;
    private IntegerProperty ReciboColector;
    private StringProperty Status;
    private StringProperty Observacion;
    private Date FechaVencPago;

    public CompraProducto(int FacturaCompraProducto, int FacturaPedido, int IDproducto,
                          Date FechaCompra, float MontoCompra, int ReciboColector,
                          String Status, String Observacion, Date FechaVencPago) {
        this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
        this.FacturaPedido = new SimpleIntegerProperty(FacturaPedido);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.FechaCompra = FechaCompra;
        this.MontoCompra = new SimpleFloatProperty(MontoCompra);
        this.ReciboColector = new SimpleIntegerProperty(ReciboColector);
        this.Status = new SimpleStringProperty(Status);
        this.Observacion = new SimpleStringProperty(Observacion);
        this.FechaVencPago = FechaVencPago;
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
    public int getReciboColector() {
        return ReciboColector.get();
    }
    public void setReciboColector(int ReciboColector) {
        this.ReciboColector = new SimpleIntegerProperty(ReciboColector);
    }
    public IntegerProperty ReciboColectorProperty() {
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
}