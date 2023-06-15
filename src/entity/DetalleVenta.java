package entity;

/**
 * La clase DetalleVenta representa un detalle de venta en tu base de datos.
 */
public class DetalleVenta {
    private int idDetalleVenta;
    private int idProducto;
    private int idVenta;
    private int cantidad;
    private float pUnitario;
    private float total;

    public DetalleVenta() {
        // Constructor vacío, puede ser útil en ciertos escenarios
    }

    public DetalleVenta(int idDetalleVenta, int idProducto, int idVenta, int cantidad, float pUnitario, float total) {
        // Constructor con parámetros para establecer los valores iniciales de los atributos
        this.idDetalleVenta = idDetalleVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.pUnitario = pUnitario;
        this.total = total;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getpUnitario() {
        return pUnitario;
    }

    public void setpUnitario(float pUnitario) {
        this.pUnitario = pUnitario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        // Método toString que devuelve una representación en cadena del objeto DetalleVenta
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idProducto=" + idProducto + ", idVenta=" + idVenta + ", cantidad=" + cantidad + ", pUnitario=" + pUnitario + ", total=" + total + '}';
    }
}
