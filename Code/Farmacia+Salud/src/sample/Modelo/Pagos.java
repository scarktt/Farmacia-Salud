package sample.Modelo;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pagos{
    private IntegerProperty IDPagos;
    private IntegerProperty IDempleado;
    private StringProperty TipoPago;
    private FloatProperty MontoPago;
    private Date FechaPago;

    public Pagos(int IDPagos, int IDempleado, String TipoPago, float MontoPago, Date FechaPago) {
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

    public static void llenarCmbTipoPago (Connection connection, ObservableList<String> lista) {
        try {
            String query = "SELECT DISTINCT TipoPago FROM Pagos";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            // Se recorre el campo que en este caso es el de Nombre
            while (resultado.next()) {
                lista.add(resultado.getString("TipoPago"));
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Tipo de Pago");
            e.printStackTrace();
        }
    }


    public static void busquedaDinamicaDeudasPendientes (Connection connection, String busqueda,
                                                         ObservableList<List<StringProperty>> data) {
        List<StringProperty> Row = new ArrayList<>();

        try {
            String query = "SELECT t3.Nombre_proveedor, t1.MontoCompra, t1.ReciboColector, t1.Observacion, t1.FechaVencPago " +
                    "FROM Compra t1 INNER JOIN Abono t2 on t1.FacturaCompra = t2.FacturaCompra " +
                    "INNER JOIN Proveedor t3 on t2.IDproveedor = t3.IDproveedor WHERE Nombre_proveedor LIKE '"+busqueda+"%'";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                Row.add(0, new SimpleStringProperty(resultado.getString("Nombre_proveedor")));
                Row.add(1, new SimpleStringProperty(resultado.getString("MontoCompra")));
                Row.add(2, new SimpleStringProperty(resultado.getString("ReciboColector")));
                Row.add(3, new SimpleStringProperty(resultado.getString("Observacion")));
                Row.add(4, new SimpleStringProperty(resultado.getString("FechaVencPago")));
                System.out.println(Row);
                data.add(Row);
                System.out.println(Row);
                System.out.println(data);
                System.out.println("---------");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar las deudas pendientes al TableView");
            e.printStackTrace();

            //Si compra 10 cojas, de 100 pone 1000 pastillas

        }
    }
}
