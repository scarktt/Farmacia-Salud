package sample.Modelo;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class Abono{
    private IntegerProperty IDabono;
    private IntegerProperty FacturaCompraProducto;
    private IntegerProperty IDproveedor;
    private FloatProperty SaldoAbono;
    private Date FechaAbono;

    public Abono(//int IDabono, int FacturaCompraProducto, int IDproveedor,
                 float SaldoAbono, Date FechaAbono) {
        //this.IDabono = new SimpleIntegerProperty(IDabono);
        //this.FacturaCompraProducto = new SimpleIntegerProperty(FacturaCompraProducto);
        //this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.SaldoAbono = new SimpleFloatProperty(SaldoAbono);
        this.FechaAbono = FechaAbono;
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

    //Metodos atributo: FechaVencPago
    public Date getFechaAbono() {return FechaAbono;}
    public void setFechaAbono(Date FechaAbono) {
        this.FechaAbono = FechaAbono;
    }
    public Date FechaAbonoProperty() {
        return FechaAbono;
    }

    public static void llenarTVAbono(Connection connection, ObservableList<Abono> lista){
        try {
            String query = "SELECT FechaAbono, SaldoAbono FROM Abono;";

            Statement statement = connection.createStatement();
            ResultSet resultado  = statement.executeQuery(query);
            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(new Abono (
                        //resultado.getInt("IDabono"),
                        //resultado.getInt("FacturaCompraProducto"),
                        //resultado.getInt("IDproveedor"),
                        resultado.getFloat("SaldoAbono"),
                        resultado.getDate("FechaAbono"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}