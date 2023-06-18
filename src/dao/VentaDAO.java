package dao;

import entity.DetalleVenta;
import entity.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kevscl
 */
public class VentaDAO {

    public String agregarVenta(Connection con, Venta venta) {
        PreparedStatement pst = null;
        String mensaje = "";
        String sql = "INSERT INTO Venta(idVenta, fechaVenta, mPago, total) VALUES(?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, venta.getIdVenta());
            pst.setString(2, venta.getFecha());
            pst.setString(3, venta.getMpago());
            pst.setFloat(4, venta.getTotal());
            // Si se ejecuta correctamente, regresa el siguiente mensaje
            mensaje = "¡Venta realizada con éxito!";
            // Ejecutamos
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            // Si algo falla, regresa el mensaje de error
            mensaje = "ERROR: " + e.getMessage();
        }
        return mensaje;
    }
    
    public String agregarDetalleVenta(Connection con, DetalleVenta detalleVenta) {
        PreparedStatement pst = null;
        String mensaje = "";
        String sql = "INSERT INTO Detalle_Venta(idDetalleVenta, idProducto, idVenta, cantidad, pUnitario, total) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, detalleVenta.getIdDetalleVenta());
            pst.setInt(2, detalleVenta.getIdProducto());
            pst.setInt(3, detalleVenta.getIdVenta());
            pst.setInt(4, detalleVenta.getCantidad());
            pst.setFloat(5, detalleVenta.getpUnitario());
            pst.setFloat(6, detalleVenta.getTotal());
            // Si se ejecuta correctamente regresa el siguiente mensaje
            mensaje = "GUARDADO CORRECTAMENTE";
            // Ejecutamos
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            // Si algo falla regresa
            mensaje = "ERROR: " + e.getMessage();
        }
        /*
     * Regresa el mensaje
     * Si es correcto regresa un mensaje de confirmacion
     * De lo contrario regresa el error
         */
        return mensaje;
    }
    
    public String getMaxID(Connection con) {
        String id = "0";
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(idVenta+1) FROM Venta";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getString(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            // System.out.println("Error al mostrar id " + e.getMessage());
        }
        return id;
    }
}

