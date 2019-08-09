package sample.Modelo;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DetalleCompraProducto{
    private IntegerProperty FacturaCompraProducto;
    private IntegerProperty IDproducto;
    private IntegerProperty CantidadUnidades;
    private FloatProperty PrecioxUnidad;

    public DetalleCompraProducto(int FacturaCompraProducto, int IDproducto, int CantidadUnidades,
                                 float PrecioxUnidad) {
        this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.CantidadUnidades = new SimpleIntegerProperty(CantidadUnidades);
        this.PrecioxUnidad = new SimpleFloatProperty(PrecioxUnidad);
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
    //Metodos atributo: CantidadUnidades
    public int getCantidadUnidades() {
        return CantidadUnidades.get();
    }
    public void setCantidadUnidades(int CantidadUnidades) {
        this.CantidadUnidades = new SimpleIntegerProperty(CantidadUnidades);
    }
    public IntegerProperty CantidadUnidadesProperty() {
        return CantidadUnidades;
    }
    //Metodos atributo: PrecioxUnidad
    public float getPrecioxUnidad() {
        return PrecioxUnidad.get();
    }
    public void setPrecioxUnidad(float PrecioxUnidad) {
        this.PrecioxUnidad = new SimpleFloatProperty(PrecioxUnidad);
    }
    public FloatProperty PrecioxUnidadProperty() {
        return PrecioxUnidad;
    }
}