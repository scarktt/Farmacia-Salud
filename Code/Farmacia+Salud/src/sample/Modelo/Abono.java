package sample.Modelo;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Abono{
    private IntegerProperty IDabono;
    private IntegerProperty FacturaCompraProducto;
    private IntegerProperty IDproveedor;
    private FloatProperty SaldoAbono;

    public Abono(int IDabono, int FacturaCompraProducto, int IDproveedor,
                 float SaldoAbono) {
        this.IDabono = new SimpleIntegerProperty(IDabono);
        this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.SaldoAbono = new SimpleFloatProperty(SaldoAbono);
    }

    //Metodos atributo: IDabono
    public int getIDabono() {
        return IDabono.get();
    }
    public void setIDabono(int IDabono) {
        this.IDabono = new SimpleIntegerProperty(IDabono);
    }
    public IntegerProperty IDabonoProperty() {
        return IDabono;
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
    //Metodos atributo: IDproveedor
    public int getIDproveedor() {
        return IDproveedor.get();
    }
    public void setIDproveedor(int IDproveedor) {
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
    }
    public IntegerProperty IDproveedorProperty() {
        return IDproveedor;
    }
    //Metodos atributo: SaldoAbono
    public float getSaldoAbono() {
        return SaldoAbono.get();
    }
    public void setSaldoAbono(float SaldoAbono) {
        this.SaldoAbono = new SimpleFloatProperty(SaldoAbono);
    }
    public FloatProperty SaldoAbonoProperty() {
        return SaldoAbono;
    }
}