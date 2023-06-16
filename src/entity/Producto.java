package entity;

/**
 * La clase Producto representa un producto en tu base de datos.
 */
public class Producto {

    // Definimos los atributos del producto
    private int idProducto;
    private String nombre;
    private int stock;
    private float precio;

    public Producto() {
        // Constructor vacío, puede ser útil en ciertos escenarios
    }

    public Producto(int idProducto, String nombre, int stock, float precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // Métodos getter y setter para acceder y modificar los atributos
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }

}
