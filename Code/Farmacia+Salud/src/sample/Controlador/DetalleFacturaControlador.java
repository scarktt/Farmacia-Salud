package sample.Controlador;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;

public class DetalleFacturaControlador {
    private StringProperty IDproducto;
    private StringProperty Nombre;
    private IntegerProperty Cantidad;
    private IntegerProperty PrecioUnitario;
    private IntegerProperty PrecioTotal;

    public DetalleFacturaControlador (String IDproducto, String Nombre, int Cantidad, int PrecioUnitario, int PrecioTotal) {
        this.IDproducto = new SimpleStringProperty(IDproducto);
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Cantidad = new SimpleIntegerProperty(Cantidad);
        this.PrecioUnitario = new SimpleIntegerProperty(PrecioUnitario);
        this.PrecioTotal = new SimpleIntegerProperty(PrecioTotal);
    }

    public static void fillListFromDataBase (Connection connection, String IDproducto, String IDproveedor) {

    }
}
