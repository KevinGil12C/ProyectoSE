package entity;

/**
 * La clase Producto representa un producto en tu base de datos.
 */
public class Producto {

    // Definimos los atributos del producto
    private int idProducto;
    private String nombre;
    private float precio;

    public Producto() {
        // Constructor vacío, puede ser útil en ciertos escenarios
    }

    public Producto(int idProducto, String nombre, float precio) {
        // Constructor con parámetros para establecer los valores iniciales de los atributos
        this.idProducto = idProducto;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        // Método toString que devuelve una representación en cadena del objeto Producto
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
}
