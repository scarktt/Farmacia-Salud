package sample.Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Proveedor{
    private IntegerProperty IDproveedor;
    private StringProperty Tipo_proveedor;
    private StringProperty Nombre_proveedor;
    private StringProperty tel1;
    private StringProperty tel2;

    public Proveedor(int IDproveedor, String Tipo_proveedor, String Nombre_proveedor,
                     String tel1, String tel2) {
        this.IDproveedor = new SimpleIntegerProperty(IDproveedor);
        this.Tipo_proveedor = new SimpleStringProperty(Tipo_proveedor);
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
        this.tel1 = new SimpleStringProperty(tel1);
        this.tel2 = new SimpleStringProperty(tel2);
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
    //Metodos atributo: Tipo_proveedor
    public String getTipo_proveedor() {
        return Tipo_proveedor.get();
    }
    public void setTipo_proveedor(String Tipo_proveedor) {
        this.Tipo_proveedor = new SimpleStringProperty(Tipo_proveedor);
    }
    public StringProperty Tipo_proveedorProperty() {
        return Tipo_proveedor;
    }
    //Metodos atributo: Nombre_proveedor
    public String getNombre_proveedor() {
        return Nombre_proveedor.get();
    }
    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = new SimpleStringProperty(Nombre_proveedor);
    }
    public StringProperty Nombre_proveedorProperty() {
        return Nombre_proveedor;
    }
    //Metodos atributo: tel1
    public String getTel1() {
        return tel1.get();
    }
    public void setTel1(String tel1) {
        this.tel1 = new SimpleStringProperty(tel1);
    }
    public StringProperty Tel1Property() {
        return tel1;
    }
    //Metodos atributo: tel2
    public String getTel2() {
        return tel2.get();
    }
    public void setTel2(String tel2) {
        this.tel2 = new SimpleStringProperty(tel2);
    }
    public StringProperty Tel2Property() {
        return tel2;
    }
}