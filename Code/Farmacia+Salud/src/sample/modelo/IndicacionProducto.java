package sample.modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class IndicacionProducto{
    private IntegerProperty IDindicacionProducto;
    private IntegerProperty IDproducto;
    private IntegerProperty IDindicacion;

    public IndicacionProducto(int IDindicacionProducto, int IDproducto, int IDindicacion) {
        this.IDindicacionProducto = new SimpleIntegerProperty(IDindicacionProducto);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.IDindicacion = new SimpleIntegerProperty(IDindicacion);
    }

    //Metodos atributo: IDindicacionProducto
    public int getIDindicacionProducto() {
        return IDindicacionProducto.get();
    }
    public void setIDindicacionProducto(int IDindicacionProducto) {
        this.IDindicacionProducto = new SimpleIntegerProperty(IDindicacionProducto);
    }
    public IntegerProperty IDindicacionProductoProperty() {
        return IDindicacionProducto;
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
    //Metodos atributo: IDindicacion
    public int getIDindicacion() {
        return IDindicacion.get();
    }
    public void setIDindicacion(int IDindicacion) {
        this.IDindicacion = new SimpleIntegerProperty(IDindicacion);
    }
    public IntegerProperty IDindicacionProperty() {
        return IDindicacion;
    }
}