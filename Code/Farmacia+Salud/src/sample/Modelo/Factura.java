package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.sql.Date;

public class Factura{
    private IntegerProperty NoFactura;
    private IntegerProperty IDempleado;
    private Date Fecha;

    public Factura(int NoFactura, int IDempleado, Date Fecha) {
        this.NoFactura = new SimpleIntegerProperty(NoFactura);
        this.IDempleado = new SimpleIntegerProperty(IDempleado);
        this.Fecha = Fecha;
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

    //Metodos atributo: Fecha
    public Date getFecha() {
        return Fecha;
    }
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    public Date FechaProperty() {
        return Fecha;
    }

    public void guardarRegistro () {

    }

    public void actualizarRegistro () {

    }

    public void eliminarRegistro () {

    }

    public void llenarInformacion () {

    }
}