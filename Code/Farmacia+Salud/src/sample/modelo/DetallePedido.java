package sample.modelo;


import javafx.beans.property.*;

public class DetallePedido{
    private IntegerProperty FacturaPedido;
    private IntegerProperty IDproducto;
    private IntegerProperty CantidadUnidad;
    private FloatProperty PrecioxUnidad;
    private BooleanProperty EsProductoNuevo;

    public DetallePedido(int FacturaPedido, int IDproducto, int CantidadUnidad,
                         float PrecioxUnidad, boolean EsProductoNuevo) {
        this.FacturaPedido = new SimpleIntegerProperty(FacturaPedido);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.CantidadUnidad = new SimpleIntegerProperty(CantidadUnidad);
        this.PrecioxUnidad = new SimpleFloatProperty(PrecioxUnidad);
        this.EsProductoNuevo = new SimpleBooleanProperty(EsProductoNuevo);
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

    //Metodos atributo: CantidadUnidad
    public int getCantidadUnidad() {
        return CantidadUnidad.get();
    }
    public void setCantidadUnidad(int CantidadUnidad) {
        this.CantidadUnidad = new SimpleIntegerProperty(CantidadUnidad);
    }
    public IntegerProperty CantidadUnidadProperty() {
        return CantidadUnidad;
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

    //Metodos atributo: EsProductoNuevo
    public boolean getEsProductoNuevo() {
        return EsProductoNuevo.get();
    }
    public void setEsProductoNuevo(boolean EsProductoNuevo) {
        this.EsProductoNuevo = new SimpleBooleanProperty(EsProductoNuevo);
    }
    public BooleanProperty EsProductoNuevoProperty() {
        return EsProductoNuevo;
    }
}