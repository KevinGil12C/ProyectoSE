package view;

import Socket.Cliente;
import Socket.Servidor;
import agentes.AgenteCliente;
import entity.Producto;
import jade.core.AID;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static view.VistaVendedor.txtBusqueda;
import static view.VistaVendedor.txtMensajeVendedor;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Kevscl
 */
public class VistaCliente extends javax.swing.JFrame implements Observer {

    public static String hostcliente = "";
    private AgenteCliente agente;
    Producto p;
    

    /**
     * Creates new form VistaCliente
     */
    public VistaCliente() {
        initComponents();
        ObtenerIP();
        Servidor s = new Servidor(5050);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
        setTitle("Vista Cliente");
        imagenesEscala();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void imagenesEscala() {
        EscalarImagen i1 = new EscalarImagen();
        i1.escalar("/images/fondo.jpg", labelFondo);
        i1.escalar("/images/logo.png", labelLogo);
    }

    public static void ObtenerIP() {
        try {
            // Obtener la dirección IP local
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();

            System.out.println("Dirección IP: " + ipAddress);
            TxtIP.setText(ipAddress);
            hostcliente = ipAddress;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void recibirMensajeVendedor(String respuesta) {
        //txtMensajeCliente.append("\n" + respuesta);
    }

    public static void recibirMensajeCajero(String respuesta) {
        txtMensajeCliente.append("\n" + respuesta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        pro9 = new javax.swing.JButton();
        pro1 = new javax.swing.JButton();
        pro2 = new javax.swing.JButton();
        pro3 = new javax.swing.JButton();
        pro4 = new javax.swing.JButton();
        pro5 = new javax.swing.JButton();
        pro6 = new javax.swing.JButton();
        pro7 = new javax.swing.JButton();
        pro8 = new javax.swing.JButton();
        TxtIP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensajeCliente = new javax.swing.JTextArea();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 120));

        pro9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9.png"))); // NOI18N
        pro9.setText("jButton1");
        pro9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro9MouseEntered(evt);
            }
        });
        pro9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro9ActionPerformed(evt);
            }
        });
        jPanel1.add(pro9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 150, 150));

        pro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        pro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro1MouseEntered(evt);
            }
        });
        pro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro1ActionPerformed(evt);
            }
        });
        jPanel1.add(pro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 150, 150));

        pro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        pro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro2MouseEntered(evt);
            }
        });
        pro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro2ActionPerformed(evt);
            }
        });
        jPanel1.add(pro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 150, 150));

        pro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        pro3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro3MouseEntered(evt);
            }
        });
        pro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro3ActionPerformed(evt);
            }
        });
        jPanel1.add(pro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 150, 150));

        pro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png"))); // NOI18N
        pro4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro4MouseEntered(evt);
            }
        });
        pro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro4ActionPerformed(evt);
            }
        });
        jPanel1.add(pro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 150, 150));

        pro5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png"))); // NOI18N
        pro5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro5MouseEntered(evt);
            }
        });
        pro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro5ActionPerformed(evt);
            }
        });
        jPanel1.add(pro5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 150, 150));

        pro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png"))); // NOI18N
        pro6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro6MouseEntered(evt);
            }
        });
        pro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro6ActionPerformed(evt);
            }
        });
        jPanel1.add(pro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 150, 150));

        pro7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7.png"))); // NOI18N
        pro7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro7MouseEntered(evt);
            }
        });
        pro7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro7ActionPerformed(evt);
            }
        });
        jPanel1.add(pro7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 150, 150));

        pro8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8.png"))); // NOI18N
        pro8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro8MouseEntered(evt);
            }
        });
        pro8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pro8ActionPerformed(evt);
            }
        });
        jPanel1.add(pro8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 150, 150));

        TxtIP.setEditable(false);
        jPanel1.add(TxtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 220, -1));

        txtMensajeCliente.setColumns(20);
        txtMensajeCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtMensajeCliente.setLineWrap(true);
        txtMensajeCliente.setRows(5);
        txtMensajeCliente.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMensajeCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 220, 360));
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1044, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro1MouseEntered
        String nombre = "Playera Tipo Polo Caballero";
        double precio = 139.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro1MouseEntered

    private void pro2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro2MouseEntered
        String nombre = "Camisa Lisa Casual Caballero";
        double precio = 299.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro2MouseEntered

    private void pro3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro3MouseEntered
        String nombre = "Playera Bordado HPC Caballero";
        double precio = 109.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro3MouseEntered

    private void pro4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro4MouseEntered
        String nombre = "Playera Estampada Caballero";
        double precio = 109.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro4MouseEntered

    private void pro5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro5MouseEntered
        String nombre = "Traje Corte Inglés Caballero";
        double precio = 799.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro5MouseEntered

    private void pro6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro6MouseEntered
        String nombre = "Jogger Deportivo Caballero";
        double precio = 159.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro6MouseEntered

    private void pro7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro7MouseEntered
        String nombre = "Bermuda Deportiva Caballero";
        double precio = 89.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro7MouseEntered

    private void pro8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro8MouseEntered
        String nombre = "Playera con Flores para dama";
        double precio = 99.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro8MouseEntered

    private void pro9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro9MouseEntered
        String nombre = "Falda Patinadora Dama";
        double precio = 99.99;
        String mensaje = "" + nombre + "\n$" + precio;

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setModal(false);
        dialog.setAlwaysOnTop(true);

        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        dialog.setContentPane(pane);
        dialog.pack();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_pro9MouseEntered

    private void pro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro1ActionPerformed
        String producto = "Playera Tipo Polo Caballero";
        Cliente c = new Cliente("192.168.1.121", producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);

    }//GEN-LAST:event_pro1ActionPerformed

    private void pro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro2ActionPerformed
        String producto = "Camisa Lisa Casual Caballero";
        Cliente c = new Cliente("192.168.1.121", producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro2ActionPerformed

    private void pro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro3ActionPerformed
        String producto = "Playera Bordado HPC Caballero";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro3ActionPerformed

    private void pro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro4ActionPerformed
        String producto = "Playera Estampada Caballero";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro4ActionPerformed

    private void pro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro5ActionPerformed
        String producto = "Traje Corte Inglés Caballero";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro5ActionPerformed

    private void pro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro6ActionPerformed
        String producto = "Jogger Deportivo Caballero";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro6ActionPerformed

    private void pro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro7ActionPerformed
        String producto = "Bermuda Deportiva Caballero";
        VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro7ActionPerformed

    private void pro8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro8ActionPerformed
        String producto = "Playera con Flores para dama";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro8ActionPerformed

    private void pro9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pro9ActionPerformed
        String producto = "Falda Patinadora Dama";
        Cliente c = new Cliente(hostcliente, producto);
        Thread t = new Thread(c);
        t.start();
        //VistaVendedor.recibirMensajeCliente(producto);
    }//GEN-LAST:event_pro9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField TxtIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JButton pro1;
    private javax.swing.JButton pro2;
    private javax.swing.JButton pro3;
    private javax.swing.JButton pro4;
    private javax.swing.JButton pro5;
    private javax.swing.JButton pro6;
    private javax.swing.JButton pro7;
    private javax.swing.JButton pro8;
    private javax.swing.JButton pro9;
    public static javax.swing.JTextArea txtMensajeCliente;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object respuesta) {
        this.txtMensajeCliente.append((String) "\n" + respuesta);
    }
}
