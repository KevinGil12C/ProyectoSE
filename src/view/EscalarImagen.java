package view;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Kevscl
 */
public class EscalarImagen {

    /*
    Esta funcion sirve para escalar una imagen
     */
    public void escalar(String rutaImagen, JLabel label) {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(rutaImagen));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        label.setIcon(iconoEscalado);
    }

}
