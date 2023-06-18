package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kevscl
 */
public class Conexion {

    private static Connection conn = null;
    private static String url = "jdbc:sqlite:dbSE.db"; // Ruta relativa al archivo de base de datos

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            if (conn != null) {
                //System.out.println("Conexión exitosa");
            } else {
                //System.out.println("No se pudo conectar a la base de datos");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return conn;
    }

    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        Connection conn = c.getConnection();
    }
}
