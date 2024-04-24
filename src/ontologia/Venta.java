package ontologia;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class Venta implements AgentAction {
    private Producto producto;
    private int cantidad;

    public Venta() {
    }

    public Venta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Slot(mandatory = true)
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Slot(mandatory = true)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
