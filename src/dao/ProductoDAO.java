package dao;

import db.Conexion;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.*;
import entity.*;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevscl
 */
public class ProductoDAO {

    private static final int IMAGE_SIZE = 50; // Tamaño deseado para las imágenes

    public class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaledImage));
            } else {
                setIcon(null);
            }

            // Ajusta la altura de la fila
            table.setRowHeight(row, IMAGE_SIZE + 10); // Puedes ajustar el valor 10 según tus preferencias

            return this;
        }

    }

    public void listarProducto(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID PRODUCTO", "PRODUCTO", "STOCK", "PRECIO", "IMAGEN"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM PRODUCTO ORDER BY idProducto";
        String[] filas = new String[5];
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            int contador = 1;
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                String rutaImagen = "/images/" + contador + ".png";
                try {
                    Image imagen = ImageIO.read(getClass().getResourceAsStream(rutaImagen));
                    ImageIcon icono = new ImageIcon(imagen);
                    filas[4] = ""; // Deja la quinta columna vacía
                    model.addRow(new Object[]{filas[0], filas[1], filas[2], filas[3], icono});
                } catch (Exception e) {
                    System.out.println("NO SE PUEDE CARGAR LA IMAGEN: " + e.getMessage());
                    filas[4] = ""; // Deja la quinta columna vacía
                    model.addRow(filas); // Añade la fila sin la imagen
                }
                contador++;
            }
            tabla.setModel(model);

            // Aplica el ImageRenderer a la columna de imagen
            TableColumn imageColumn = tabla.getColumnModel().getColumn(4);
            imageColumn.setCellRenderer(new ImageRenderer());

            // Ajusta el ancho de la columna de imagen
            imageColumn.setPreferredWidth(IMAGE_SIZE + 10); // Puedes ajustar el valor 10 según tus preferencias

            // Ajusta automáticamente el tamaño de las columnas
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } catch (Exception e) {
            System.out.println("NO SE PUEDE LISTAR LA TABLA " + e.getMessage());
        }
    }

    public void listarProductoFiltro(Connection con, JTable tabla, String busqueda) {
        DefaultTableModel model;
        String[] columnas = {"ID PRODUCTO", "PRODUCTO", "STOCK", "PRECIO", "IMAGEN"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM PRODUCTO WHERE idProducto = ? OR nombre LIKE ? ORDER BY idProducto";
        String[] filas = new String[5];
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, busqueda);
            pst.setString(2, "%" + busqueda + "%");
            rs = pst.executeQuery();
            int contador = 1;
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                String rutaImagen = "/images/" + filas[0] + ".png";
                try {
                    Image imagen = ImageIO.read(getClass().getResourceAsStream(rutaImagen));
                    ImageIcon icono = new ImageIcon(imagen);
                    filas[4] = ""; // Deja la quinta columna vacía
                    model.addRow(new Object[]{filas[0], filas[1], filas[2], filas[3], icono});
                } catch (Exception e) {
                    System.out.println("NO SE PUEDE CARGAR LA IMAGEN: " + e.getMessage());
                    filas[4] = ""; // Deja la quinta columna vacía
                    model.addRow(filas); // Añade la fila sin la imagen
                }
                contador++;
            }
            tabla.setModel(model);

            // Aplica el ImageRenderer a la columna de imagen
            TableColumn imageColumn = tabla.getColumnModel().getColumn(4);
            imageColumn.setCellRenderer(new ImageRenderer());

            // Ajusta el ancho de la columna de imagen
            imageColumn.setPreferredWidth(IMAGE_SIZE + 10); // Puedes ajustar el valor 10 según tus preferencias

            // Ajusta automáticamente el tamaño de las columnas
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } catch (Exception e) {
            System.out.println("NO SE PUEDE LISTAR LA TABLA " + e.getMessage());
        }
    }

}
