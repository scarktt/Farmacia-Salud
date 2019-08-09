package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.sql.Date;

public class Lote{
    private IntegerProperty IDlote;
    private Date Fecha_venc;

    public Lote(int IDlote, Date Fecha_venc) {
        this.IDlote = new SimpleIntegerProperty(IDlote);
        this.Fecha_venc = Fecha_venc;
    }

    //Metodos atributo: IDlote
    public int getIDlote() {
        return IDlote.get();
    }
    public void setIDlote(int IDlote) {
        this.IDlote = new SimpleIntegerProperty(IDlote);
    }
    public IntegerProperty IDloteProperty() {
        return IDlote;
    }

    //Metodos atributo: Fecha_venc
    public Date getFecha_venc() {
        return Fecha_venc;
    }
    public void setFecha_venc(Date Fecha_venc) {
        this.Fecha_venc = Fecha_venc;
    }
    public Date Fecha_vencProperty() {
        return Fecha_venc;
    }
}