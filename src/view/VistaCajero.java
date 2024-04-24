package view;

import Socket.Cajero1;
import Socket.Cliente;
import Socket.Servidor;
import bo.ProductoBO;
import bo.VentaBO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.DetalleVenta;
import entity.Venta;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 *
 * @author Kevscl
 */
public class VistaCajero extends javax.swing.JFrame implements Observer{

    public static String hostcajero = "";
    Venta v = new Venta();
    DetalleVenta dv = new DetalleVenta();
    VentaBO vdao = new VentaBO();
    static int cont = 1;
    static float sumIva = 0, sumTotal = 0, sumSubTotal = 0;
    private static DefaultTableModel modelo = new DefaultTableModel();

    public VistaCajero() {
        initComponents();
        ObtenerIP();
        setTitle("Vista Cajero");
        Servidor s = new Servidor(5050);
        Thread t = new Thread(s);
        t.start();
        imagenesEscala();
        btnVenta.setVisible(false);
        idMax();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void idMax() {
        String id = vdao.getMaxID();
        txtIdVenta.setText(id);
    }
    
    public static void ObtenerIP() {
        try {
            // Obtener la dirección IP local
            InetAddress localhost = InetAddress.getLocalHost();
            String ipAddress = localhost.getHostAddress();

            System.out.println("Dirección IP: " + ipAddress);
            TxtIPCaja.setText(ipAddress);
            hostcajero = ipAddress;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void imagenesEscala() {
        EscalarImagen i1 = new EscalarImagen();
        i1.escalar("/images/fondoCajero.jpg", labelFondo);
        i1.escalar("/images/logo.png", labelLogo);
    }

    public static class ItemVenta {

        private int id;
        private String nombre;
        private int cantidad;
        private float precioUnitario;
        private float precioTotal;
        private static JTextField txtSubTotal;

        // Constructor
        public ItemVenta(int id, String nombre, int cantidad, float precioUnitario, float precioTotal) {
            this.id = id;
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
            this.precioTotal = precioTotal;
        }

        // Getter para id
        public int getId() {
            return id;
        }

        // Setter para id
        public void setId(int id) {
            this.id = id;
        }

        // Getter para nombre
        public String getNombre() {
            return nombre;
        }

        // Setter para nombre
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        // Getter para cantidad
        public int getCantidad() {
            return cantidad;
        }

        // Setter para cantidad
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        // Getter para precioUnitario
        public float getPrecioUnitario() {
            return precioUnitario;
        }

        // Setter para precioUnitario
        public void setPrecioUnitario(float precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        // Getter para precioTotal
        public float getPrecioTotal() {
            return precioTotal;
        }

        // Setter para precioTotal
        public void setPrecioTotal(float precioTotal) {
            this.precioTotal = precioTotal;
        }
    }

//    public static void recibirMensajeVendedor(String respuesta, int idP, String nom, float precio, int cant) {
//        //txtMensajeCajero.setText("\n" + respuesta);
//        tabla(idP, nom, precio, cant);
//    }

    public static void tabla(int idP, String nom, float precio, int cant) {
        DecimalFormat df = new DecimalFormat("#.00");
        modelo = (DefaultTableModel) tbVenta.getModel();
        // Definimos los datos de la tabla
        String nombre = nom;
        int id = idP;
        int cantidad = cant;
        float pUni = precio;
        float pSubtotal = cantidad * pUni;
        sumSubTotal = sumSubTotal + pSubtotal;
        float pIva = pSubtotal * 0.16f;
        sumIva = sumIva + pIva;
        float pTotal = pSubtotal + pIva;
        sumTotal = sumTotal + pTotal;

        ItemVenta item = new ItemVenta(id, nombre, cantidad, pUni, pTotal);

        Object[] obj = new Object[6];
        obj[0] = cont;
        obj[1] = item.getId();
        obj[2] = item.getNombre();
        obj[3] = item.getCantidad();
        obj[4] = (item.getPrecioUnitario());
        obj[5] = (item.getPrecioTotal());

        // Agregamos el objeto a nuestro modelo
        modelo.addRow(obj);

        // Aumentamos el contador
        cont++;

        // Actualizamos los totales en la interfaz (si es necesario)
        txtSubTotal.setText(df.format(sumSubTotal));
        txtIVA.setText(df.format(sumIva));
        txtTotal.setText(df.format(sumTotal));
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
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensajeCajero = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        btnVenta = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        TxtIPCaja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cajero.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 100, 100));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel1.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 140));

        txtMensajeCajero.setColumns(20);
        txtMensajeCajero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtMensajeCajero.setLineWrap(true);
        txtMensajeCajero.setRows(5);
        txtMensajeCajero.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMensajeCajero);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 576, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carro de compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contador", "ID", "Nombre", "Cantidad", "P. Unitario", "P. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 620, 330));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Subtotal:");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("IVA 16%:");

        txtIVA.setEditable(false);
        txtIVA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Importe:");

        txtImporte.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Cambio:");

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btnVenta.setBackground(new java.awt.Color(0, 0, 255));
        btnVenta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vender.png"))); // NOI18N
        btnVenta.setText("Generar Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnVenta)))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 310, 310));

        txtIdVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, 80, -1));

        TxtIPCaja.setEditable(false);
        jPanel1.add(TxtIPCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 160, 180, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Fact:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        labelFondo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
        DecimalFormat df = new DecimalFormat("#.00");
        float total = Float.parseFloat(txtTotal.getText());
        float importe = Float.parseFloat(txtImporte.getText());
        float cambio = importe - total;
        if (importe > total) {
            txtCambio.setText(df.format(cambio) + "");
            btnVenta.setVisible(true);
        } else {
            txtCambio.setText("");
            btnVenta.setVisible(false);
        }
    }//GEN-LAST:event_txtImporteKeyReleased

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        guardaVenta();
        guardaDetalleVenta();
        
        String respuesta = "Agente Cajero: se ha generado la venta Factura " + txtIdVenta.getText();
        Cajero1 c = new Cajero1("192.168.1.125", respuesta);
        Thread l = new Thread(c);
        l.start();
        generaPDF();

        //VistaCliente.recibirMensajeCajero(mensaje);
    }//GEN-LAST:event_btnVentaActionPerformed
    
    public void generaPDF() {
        try {
            FileOutputStream archivo;
            File file = new File("C://reportes//Reporte " + txtIdVenta.getText() + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance(getClass().getClassLoader().getResource("images/logo.png"));

            Date date = new Date();
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: " + txtIdVenta.getText() + "\nFecha: " + new SimpleDateFormat("MM/dd/yyyy").format(date) + "\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ComunaEncabezado = new float[]{20f, 30f, 70f, 50f};
            Encabezado.setWidths(ComunaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            Encabezado.addCell(img);
            String name = "SiVenDi";
            String frase = "Viste con estilo, vive con pasión";
            String tel = "7221595250";
            String dir = "EDOMEX";
            String ra = "Dinamita Store";

            Encabezado.addCell("");
            Encabezado.addCell(name + "\n" + frase + "\nTel: " + tel + "\nDireccion: " + dir + "\n" + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            //Parte 2
            Paragraph cl = new Paragraph();
            cl.add(Chunk.NEWLINE);
            cl.add("Datos del cliente:" + "\n\n");
            doc.add(cl);

            PdfPTable tablacl = new PdfPTable(4);
            tablacl.setWidthPercentage(100);
            tablacl.getDefaultCell().setBorder(0);
            float[] Comunacl = new float[]{30f, 60f, 15f, 20f};
            tablacl.setWidths(Comunacl);
            tablacl.setHorizontalAlignment(Element.ALIGN_LEFT);
            //Buscamos el cliente
            PdfPCell cl1 = new PdfPCell(new Phrase("RFC:", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase(""));
            PdfPCell cl4 = new PdfPCell(new Phrase(""));

            cl1.setBorder(0);
            cl2.setBorder(0);
            cl3.setBorder(0);
            cl4.setBorder(0);
            tablacl.addCell(cl1);
            tablacl.addCell(cl2);
            tablacl.addCell(cl3);
            tablacl.addCell(cl4);

            //Agregamos los get del cliente
            tablacl.addCell("XAXX010101000");
            tablacl.addCell("PÚBLICO EN GENERAL");
            tablacl.addCell("");
            tablacl.addCell("");

            doc.add(tablacl);

            //Tabla producto
            Paragraph pro = new Paragraph();
            pro.add(Chunk.NEWLINE);
            pro.add("\n\nDetalle venta" + "\n\n");
            doc.add(pro);

            PdfPTable tablapr = new PdfPTable(4);
            tablapr.setWidthPercentage(100);
            tablapr.getDefaultCell().setBorder(0);
            float[] Comunapr = new float[]{10f, 60f, 15f, 20f};
            tablapr.setWidths(Comunapr);
            tablapr.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell pro1 = new PdfPCell(new Phrase("Cant:"));
            PdfPCell pro2 = new PdfPCell(new Phrase("Nombre:"));
            PdfPCell pro3 = new PdfPCell(new Phrase("P/Unitario:"));
            PdfPCell pro4 = new PdfPCell(new Phrase("P/Total:"));

            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);

            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);

            tablapr.addCell(pro1);
            tablapr.addCell(pro2);
            tablapr.addCell(pro3);
            tablapr.addCell(pro4);

            //Agregamos los productos de la venta
            for (int i = 0; i < tbVenta.getRowCount(); i++) {
                String cant = tbVenta.getValueAt(i, 3) + "";
                String nomb = tbVenta.getValueAt(i, 2) + "";
                String puni = tbVenta.getValueAt(i, 4) + "";
                String ptot = tbVenta.getValueAt(i, 5) + "";
                tablapr.addCell(cant);
                tablapr.addCell(nomb);
                tablapr.addCell(puni);
                tablapr.addCell(ptot);
            }
            doc.add(tablapr);

            //Parte 3
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Subtotal: " + txtSubTotal.getText());
            info.add("\nIVA 16%: " + txtIVA.getText());
            info.add("\nTotal: " + txtTotal.getText());
            info.add("\n\nImporte: " + txtImporte.getText() + "");
            info.add("\nCambio: " + txtCambio.getText() + "");
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Parte 4
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma: \n\n");
            firma.add("-------------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //Parte 5
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("\n\n Gracias por su Compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            //Cierre del pdf
            doc.close();
            archivo.close();
            //limpiarTodo(); // Cambia "limpiarToto()" por "limpiarTodo()"
            //Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private byte[] getFileBytes(File file) throws IOException {
        byte[] fileBytes;
        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            fileBytes = bos.toByteArray();
        }
        return fileBytes;
    }

    public void guardaVenta() {
        v = new Venta();
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Crear un formateador de fecha
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Formatear la fecha en el formato deseado
        String fechaFormateada = fechaActual.format(formatoFecha);

        int idVenta = Integer.parseInt(txtIdVenta.getText());

        String mpago = "Efectivo";
        float total = Float.parseFloat(txtTotal.getText());
        //Agregamos la venta
        v.setIdVenta(idVenta);
        v.setFecha(fechaFormateada);
        v.setMpago(mpago);
        v.setTotal(total);
        String mensaje = vdao.agregarVenta(v);
        //men.valido(mensaje);
        //idMax();
        //guardaDetalleVenta();
        //generaPDF();
    }

    public void guardaDetalleVenta() {
        dv = new DetalleVenta();
        vdao = new VentaBO();
        for (int i = 0; i < tbVenta.getRowCount(); i++) {
            dv.setIdDetalleVenta(Integer.parseInt(tbVenta.getValueAt(i, 0) + ""));
            dv.setIdProducto(Integer.parseInt(tbVenta.getValueAt(i, 1) + ""));
            dv.setIdVenta(Integer.parseInt(txtIdVenta.getText()));
            dv.setCantidad(Integer.parseInt(tbVenta.getValueAt(i, 3) + ""));
            dv.setpUnitario(Float.parseFloat(tbVenta.getValueAt(i, 4) + ""));
            dv.setTotal(Float.parseFloat(tbVenta.getValueAt(i, 5) + ""));
            String mensaje = vdao.agregarDetalleVenta(dv);
            System.out.println(mensaje);
        }
        //generaPDF();
    }

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
            java.util.logging.Logger.getLogger(VistaCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField TxtIPCaja;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelLogo;
    public static javax.swing.JTable tbVenta;
    private static javax.swing.JTextField txtCambio;
    private static javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtImporte;
    public static javax.swing.JTextArea txtMensajeCajero;
    private static javax.swing.JTextField txtSubTotal;
    private static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object producto) {
        DecimalFormat df1 = new DecimalFormat("#.00");
        String mensaje = (String)producto;
        System.out.println(mensaje);
        // Dividir el mensaje en partes utilizando la coma como separador
        String[] partes = mensaje.split(",");

        // Asignar cada parte a sus respectivas variables
        int id = Integer.parseInt(partes[0]);
        String pro = partes[1];
        double pUni = Double.parseDouble(partes[2]);
        int cant = Integer.parseInt(partes[3]);
        this.txtMensajeCajero.append((String) "\n" + "Agente Vendedor: " + pro + " agregado al carro de compra");
        tabla(id, pro, (float) pUni, cant);
    }

}
