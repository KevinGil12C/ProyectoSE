package bo;

import dao.VentaDAO;
import db.Conexion;
import entity.DetalleVenta;
import entity.Venta;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Kevscl
 */
public class VentaBO {

    private static String mensaje = "";
    private VentaDAO vdao = new VentaDAO();

    public String agregarVenta(Venta v) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = vdao.agregarVenta(conn, v);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String agregarDetalleVenta(DetalleVenta v) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = vdao.agregarDetalleVenta(conn, v);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    //Para encontrar el idmax
    public String getMaxID() {
        Connection conn = Conexion.getConnection();
        String id = vdao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
