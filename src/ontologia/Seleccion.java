package ontologia;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class Seleccion implements Predicate {
    private Producto producto;

    public Seleccion() {
    }

    public Seleccion(Producto producto) {
        this.producto = producto;
    }

    @Slot(mandatory = true)
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
