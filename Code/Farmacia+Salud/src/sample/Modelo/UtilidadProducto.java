package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilidadProducto{
    private IntegerProperty IDutilidadProducto;
    private IntegerProperty IDproducto;
    private IntegerProperty IDenfermedad;

    public UtilidadProducto(int IDutilidadProducto, int IDproducto, int IDenfermedad) {
        this.IDutilidadProducto = new SimpleIntegerProperty(IDutilidadProducto);
        this.IDproducto = new SimpleIntegerProperty(IDproducto);
        this.IDenfermedad = new SimpleIntegerProperty(IDenfermedad);
    }

    //Metodos atributo: IDutilidadProducto
    public int getIDutilidadProducto() {
        return IDutilidadProducto.get();
    }
    public void setIDutilidadProducto(int IDutilidadProducto) {
        this.IDutilidadProducto = new SimpleIntegerProperty(IDutilidadProducto);
    }
    public IntegerProperty IDutilidadProductoProperty() {
        return IDutilidadProducto;
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
    //Metodos atributo: IDenfermedad
    public int getIDenfermedad() {
        return IDenfermedad.get();
    }
    public void setIDenfermedad(int IDenfermedad) {
        this.IDenfermedad = new SimpleIntegerProperty(IDenfermedad);
    }
    public IntegerProperty IDenfermedadProperty() {
        return IDenfermedad;
    }
}