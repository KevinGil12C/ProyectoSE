package entity;

/**
 * La clase Venta representa una venta en la base de datos.
 */
public class Venta {
    private int idVenta;
    private String fecha;
    private String mpago;
    private float total;

    public Venta() {
        // Constructor vacío, puede ser útil en ciertos escenarios
    }

    public Venta(int idVenta, String fecha, String mpago, float total) {
        // Constructor con parámetros para establecer los valores iniciales de los atributos
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.mpago = mpago;
        this.total = total;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMpago() {
        return mpago;
    }

    public void setMpago(String mpago) {
        this.mpago = mpago;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        // Método toString que devuelve una representación en cadena del objeto Venta
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", mpago=" + mpago + ", total=" + total + '}';
    }
}
