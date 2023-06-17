package bo;

import dao.ProductoDAO;
import db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Kevscl
 */
public class ProductoBO {
    ProductoDAO pdao = new ProductoDAO();
    public void listarProducto(JTable tabla) {
        Connection conn = Conexion.getConnection();
        pdao.listarProducto(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listarProductoFiltro(JTable tabla, String bsuqueda) {
        Connection conn = Conexion.getConnection();
        pdao.listarProductoFiltro(conn, tabla, bsuqueda);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
