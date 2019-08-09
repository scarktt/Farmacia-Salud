package sample.modelo;


import javafx.beans.property.*;

import java.sql.Date;

public class DetalleProducto{
    private IntegerProperty IDproducto;
    private IntegerProperty IDLote;
    private Date FechaVenc;
    private FloatProperty PrecioUnitario;
    private FloatProperty PrecioVenta;

    public DetalleProducto(int IDproducto, int IDLote, Date FechaVenc,
                           float PrecioUnitario, float PrecioVenta) {
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.IDLote = new SimpleIntegerProperty(IDLote);
        this.FechaVenc = FechaVenc;
        this.PrecioUnitario = new SimpleFloatProperty(PrecioUnitario);
        this.PrecioVenta = new SimpleFloatProperty(PrecioVenta);
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

    //Metodos atributo: IDLote
    public int getIDLote() {
        return IDLote.get();
    }
    public void setIDLote(int IDLote) {
        this.IDLote = new SimpleIntegerProperty(IDLote);
    }
    public IntegerProperty IDLoteProperty() {
        return IDLote;
    }

    //Metodos atributo: FechaVenc
    public Date getFechaVenc() {
        return FechaVenc;
    }
    public void setFechaVenc(Date FechaVenc) {
        this.FechaVenc = FechaVenc;
    }
    public Date FechaVencProperty() {
        return FechaVenc;
    }

    //Metodos atributo: PrecioUnitario
    public float getPrecioUnitario() {
        return PrecioUnitario.get();
    }
    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = new SimpleFloatProperty(PrecioUnitario);
    }
    public FloatProperty PrecioUnitarioProperty() {
        return PrecioUnitario;
    }

    //Metodos atributo: PrecioVenta
    public float getPrecioVenta() {
        return PrecioVenta.get();
    }
    public void setPrecioVenta(float PrecioVenta) {
        this.PrecioVenta = new SimpleFloatProperty(PrecioVenta);
    }
    public FloatProperty PrecioVentaProperty() {
        return PrecioVenta;
    }
}