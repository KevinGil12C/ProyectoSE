package view;

import bo.ProductoBO;
import entity.Producto;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevscl
 */
public class VistaVendedor extends javax.swing.JFrame {
    ProductoBO pbo = new ProductoBO();
    
    /**
     * Creates new form VistaVendedor
     */
    public VistaVendedor() {
        initComponents();
        imagenEscalada();
        listar();
    }

    public void listar() {
        pbo.listarProducto(tbProducto);
    }

    public void imagenEscalada() {
        EscalarImagen img = new EscalarImagen();
        img.escalar("/images/fondoVendedor.jpg", labelFondo);
        img.escalar("/images/logo.png", labelLogo);
    }

    
    
    public static void recibirMensajeCliente(String producto) {
        txtMensajeVendedor.setText("Agente Cliente ha seleccionado " + producto);
        txtBusqueda.setText(producto);
        System.out.println("Agente Cliente ha seleccionado " + producto);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensajeVendedor = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        btnResponder = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel1.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vendedor.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(887, 20, 100, 100));

        txtMensajeVendedor.setColumns(20);
        txtMensajeVendedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtMensajeVendedor.setLineWrap(true);
        txtMensajeVendedor.setRows(5);
        txtMensajeVendedor.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMensajeVendedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 576, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Barra de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Producto:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 27, -1, -1));

        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        jPanel2.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 24, 331, -1));

        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProducto);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 680, 270));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 720, 350));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar producto"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Stock:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });
        jPanel3.add(spinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, -1));

        btnResponder.setBackground(new java.awt.Color(102, 204, 0));
        btnResponder.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnResponder.setForeground(new java.awt.Color(255, 255, 255));
        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });
        jPanel3.add(btnResponder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 130, 40));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 130, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 230, 340));
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        pbo.listarProductoFiltro(tbProducto, txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductoMouseClicked
        int selectedRow = tbProducto.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se seleccionó alguna fila
            String stock = tbProducto.getValueAt(selectedRow, 2).toString(); // Suponiendo que el stock se encuentra en la tercera columna (índice 2)
            txtStock.setText(stock);
        }
    }//GEN-LAST:event_tbProductoMouseClicked

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        int selectedValue = (int) spinner.getValue();
        int stock = Integer.parseInt(txtStock.getText());
        // Verifica si el valor seleccionado está fuera de los límites
        if (selectedValue < 0 || selectedValue > stock) {
            // Establece el valor mínimo o máximo permitido
            if (selectedValue < 0) {
                spinner.setValue(0);
            } else {
                spinner.setValue(stock);
            }
        }
    }//GEN-LAST:event_spinnerStateChanged

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        int selectedRow = tbProducto.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se seleccionó alguna fila
            String pro = tbProducto.getValueAt(selectedRow, 1).toString();
            int stock = Integer.parseInt(txtStock.getText());
            String respuesta = "";
            if (stock > 0) {
                respuesta = "Agente Vendedor: " + pro + " esta disponible";
                System.out.println(respuesta);
                VistaCliente.recibirMensajeVendedor(respuesta);
            } else {
                respuesta = "Agente Vendedor: " + pro + " no esta disponible";
                System.out.println(respuesta);
                VistaCliente.recibirMensajeVendedor(respuesta);
            }
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = tbProducto.getSelectedRow();
        if (selectedRow != -1) { // Se verifica si se seleccionó alguna fila
            int id = Integer.parseInt(tbProducto.getValueAt(selectedRow, 0).toString());
            String pro = tbProducto.getValueAt(selectedRow, 1).toString();
            int stock = Integer.parseInt(tbProducto.getValueAt(selectedRow, 2).toString());
            float pUni = Float.parseFloat(tbProducto.getValueAt(selectedRow, 3).toString());
            int cant = (int) spinner.getValue();
            String respuesta = "";
            if (stock > 0) {
                respuesta = "Agente Vendedor: " + pro + " agregado al carro de compra";
                System.out.println(respuesta);
                //VistaCajero.recibirMensajeVendedor(respuesta, id, pro, pUni, cant);
            } else {
                respuesta = "Agente Vendedor: " + pro + " no esta disponible";
                System.out.println(respuesta);
                VistaCliente.recibirMensajeVendedor(respuesta);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tbProducto;
    public static javax.swing.JTextField txtBusqueda;
    public static javax.swing.JTextArea txtMensajeVendedor;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
