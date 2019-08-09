package sample.Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Enfermedad{
    private IntegerProperty IDenfermedad;
    private StringProperty Descripcion;

    public Enfermedad(int IDenfermedad, String Descripcion) {
        this.IDenfermedad = new SimpleIntegerProperty(IDenfermedad);
        this.Descripcion = new SimpleStringProperty(Descripcion);
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
    //Metodos atributo: Descripcion
    public String getDescripcion() {
        return Descripcion.get();
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = new SimpleStringProperty(Descripcion);
    }
    public StringProperty DescripcionProperty() {
        return Descripcion;
    }
}