package sample.Modelo;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DetalleFactura{
    private IntegerProperty NoFactura;
    private IntegerProperty IDproducto;
    private IntegerProperty IDLote;
    private FloatProperty PrecioUnitario;
    private IntegerProperty Cantidad;
    private FloatProperty Total;

    public DetalleFactura(int NoFactura, int IDproducto, int IDLote,
                          float PrecioUnitario, int Cantidad, float Total) {
        this.NoFactura = new SimpleIntegerProperty(NoFactura);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.IDLote = new SimpleIntegerProperty(IDLote);
        this.PrecioUnitario = new SimpleFloatProperty(PrecioUnitario);
        this.Cantidad = new SimpleIntegerProperty(Cantidad);
        this.Total = new SimpleFloatProperty(Total);
    }

    //Metodos atributo: NoFactura
    public int getNoFactura() {
        return NoFactura.get();
    }
    public void setNoFactura(int NoFactura) {
        this.NoFactura = new SimpleIntegerProperty(NoFactura);
    }
    public IntegerProperty NoFacturaProperty() {
        return NoFactura;
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
    //Metodos atributo: Cantidad
    public int getCantidad() {
        return Cantidad.get();
    }
    public void setCantidad(int Cantidad) {
        this.Cantidad = new SimpleIntegerProperty(Cantidad);
    }
    public IntegerProperty CantidadProperty() {
        return Cantidad;
    }
    //Metodos atributo: Total
    public float getTotal() {
        return Total.get();
    }
    public void setTotal(float Total) {
        this.Total = new SimpleFloatProperty(Total);
    }
    public FloatProperty TotalProperty() {
        return Total;
    }
}