package sample.modelo;


import javafx.beans.property.*;

import java.sql.Date;

public class Pagos{
    private IntegerProperty IDPagos;
    private IntegerProperty IDempleado;
    private StringProperty TipoPago;
    private FloatProperty MontoPago;
    private Date FechaPago;

    public Pagos(int IDPagos, int IDempleado, String TipoPago,
                 float MontoPago, Date FechaPago) {
        this.IDPagos = new SimpleIntegerProperty(IDPagos);
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
        this.TipoPago = new SimpleStringProperty(TipoPago);
        this.MontoPago = new SimpleFloatProperty(MontoPago);
        this.FechaPago = FechaPago;
    }

    //Metodos atributo: IDPagos
    public int getIDPagos() {
        return IDPagos.get();
    }
    public void setIDPagos(int IDPagos) {
        this.IDPagos = new SimpleIntegerProperty(IDPagos);
    }
    public IntegerProperty IDPagosProperty() {
        return IDPagos;
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

    //Metodos atributo: TipoPago
    public String getTipoPago() {
        return TipoPago.get();
    }
    public void setTipoPago(String TipoPago) {
        this.TipoPago = new SimpleStringProperty(TipoPago);
    }
    public StringProperty TipoPagoProperty() {
        return TipoPago;
    }

    //Metodos atributo: MontoPago
    public float getMontoPago() {
        return MontoPago.get();
    }
    public void setMontoPago(float MontoPago) {
        this.MontoPago = new SimpleFloatProperty(MontoPago);
    }
    public FloatProperty MontoPagoProperty() {
        return MontoPago;
    }

    //Metodos atributo: FechaPago
    public Date getFechaPago() {
        return FechaPago;
    }
    public void setFechaPago(Date FechaPago) {
        this.FechaPago = FechaPago;
    }
    public Date FechaPagoProperty() {
        return FechaPago;
    }
}