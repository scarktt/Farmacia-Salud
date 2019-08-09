package sample.modelo;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PerdidaProducto{
    private IntegerProperty IDproducto;
    private IntegerProperty IDLote;
    private IntegerProperty IDperdida;
    private IntegerProperty Cantidad;
    private FloatProperty MontoPerdido;

    public PerdidaProducto(int IDproducto, int IDLote, int IDperdida,
                           int Cantidad, float MontoPerdido) {
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.IDLote = new SimpleIntegerProperty(IDLote);
        this.IDperdida = new SimpleIntegerProperty(IDperdida);
        this.Cantidad = new SimpleIntegerProperty(Cantidad);
        this.MontoPerdido = new SimpleFloatProperty(MontoPerdido);
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
    //Metodos atributo: IDperdida
    public int getIDperdida() {
        return IDperdida.get();
    }
    public void setIDperdida(int IDperdida) {
        this.IDperdida = new SimpleIntegerProperty(IDperdida);
    }
    public IntegerProperty IDperdidaProperty() {
        return IDperdida;
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
    //Metodos atributo: MontoPerdido
    public float getMontoPerdido() {
        return MontoPerdido.get();
    }
    public void setMontoPerdido(float MontoPerdido) {
        this.MontoPerdido = new SimpleFloatProperty(MontoPerdido);
    }
    public FloatProperty MontoPerdidoProperty() {
        return MontoPerdido;
    }
}