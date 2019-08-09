package sample.modelo;


import javafx.beans.property.*;

import java.sql.Date;

public class Pedido{
    private IntegerProperty FacturaPedido;
    private IntegerProperty IDproveedor;
    private IntegerProperty IDempleado;
    private Date FechaPedido;
    private FloatProperty MontoPedido;

    public Pedido(int FacturaPedido, int IDproveedor, int IDempleado,
                  Date FechaPedido, float MontoPedido) {
        this.FacturaPedido = new SimpleIntegerProperty(FacturaPedido);
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
        this.FechaPedido = FechaPedido;
        this.MontoPedido = new SimpleFloatProperty(MontoPedido);
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

    //Metodos atributo: FechaPedido
    public Date getFechaPedido() {
        return FechaPedido;
    }
    public void setFechaPedido(Date FechaPedido) {
        this.FechaPedido = FechaPedido;
    }
    public Date FechaPedidoProperty() {
        return FechaPedido;
    }

    //Metodos atributo: MontoPedido
    public float getMontoPedido() {
        return MontoPedido.get();
    }
    public void setMontoPedido(float MontoPedido) {
        this.MontoPedido = new SimpleFloatProperty(MontoPedido);
    }
    public FloatProperty MontoPedidoProperty() {
        return MontoPedido;
    }
}