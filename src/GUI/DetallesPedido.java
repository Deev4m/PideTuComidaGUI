/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pidetucomida.gui.pojo.Cliente;
import com.pidetucomida.gui.pojo.Pedido;
import com.pidetucomida.gui.pojo.Producto;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author dev
 */
public class DetallesPedido extends javax.swing.JFrame {

    String urlDetallesPedido = "http://localhost:8080/PideTuComidaAPI/resources/api/pedidos/detalles_pedido/";
    String urlFinalizar = "http://localhost:8080/PideTuComidaAPI/resources/api/pedidos/finalizarPedido/";

    int idPedido;
    String fecha, comentario;

    /**
     * Creates new form DetallesPedido
     */
    public DetallesPedido(int idPedido, String fecha, String comentario) {
        initComponents();
        setTitle("Detalles del pedido");
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.comentario = comentario;

        estilo();

        // Obtener los detalles del cliente y mostrarlos en los campos
        mostrarDetallesCliente();
    }

    public void estilo() {
        jTextFieldIdPedido.setText(String.valueOf(idPedido)); // Establecer el ID del pedido en el JTextFieldIdPedido
        jTextFieldFechaHora.setText(String.valueOf(fecha));
        jTextAreaComentario.setText(String.valueOf(comentario));
        jTextAreaComentario.setLineWrap(true);
        jTextAreaComentario.setWrapStyleWord(true);

        setLocationRelativeTo(null); // Se abre en el centro siempre
        getContentPane().setBackground(Color.decode("#014B10"));
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);
        jLabel3.setForeground(Color.WHITE);
        jLabel4.setForeground(Color.WHITE);
        jLabel5.setForeground(Color.WHITE);
        jLabel6.setForeground(Color.WHITE);
        jLabel7.setForeground(Color.WHITE);
        jLabel8.setForeground(Color.WHITE);

    }

    public DetallesPedido() {
        initComponents();
        setTitle("Detalles del pedido");
    }

    private void mostrarDetallesCliente() {
        try {
            URL direccion = new URL(urlDetallesPedido + idPedido);
            HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder resultado = new StringBuilder();
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();

            // Obtener el resultado como cadena JSON
            String json = resultado.toString();
            Gson gson = new Gson();
            Cliente c = gson.fromJson(json, Cliente.class);

            jTextFieldNombre.setText(c.getNombre());
            jTextFieldCorreo.setText(c.getCorreo());
            jTextFieldDireccion.setText(c.getDireccionEnvio());
            jTextFieldTelefono.setText(c.getTelefono());

            mostrarProductosDelPedido();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarProductosDelPedido() {
        try {
            URL direccion = new URL(urlDetallesPedido + idPedido + "/productos");
            HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder resultado = new StringBuilder();
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();

            // Crear el modelo de lista
            DefaultListModel<String> listModel = new DefaultListModel<>();

            // Obtener el resultado como cadena JSON
            String json = resultado.toString();
            Gson gson = new Gson();
            ArrayList<Producto> productos = gson.fromJson(json, new TypeToken<ArrayList<Producto>>() {
            }.getType());

            // Recorrer la lista de productos y agregar nombres a la lista
            for (Producto p : productos) {
                listModel.addElement(p.getNombre()); // Agregar el nombre del producto a la lista
            }
            jListProductos.setModel(listModel); // Establecer el modelo de lista en el JList
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAtras = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIdPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFechaHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProductos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaComentario = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText("Finalizar pedido");

        jLabel1.setText("Nombre");

        jTextFieldCorreo.setEditable(false);

        jLabel2.setText("Correo");

        jTextFieldNombre.setEditable(false);

        jLabel3.setText("Dirección");

        jTextFieldDireccion.setEditable(false);

        jLabel4.setText("Teléfono");

        jTextFieldTelefono.setEditable(false);

        jLabel5.setText("Id Pedido");

        jTextFieldIdPedido.setEditable(false);

        jLabel6.setText("Fecha y hora");

        jTextFieldFechaHora.setEditable(false);

        jLabel7.setText("Comentarios");

        jScrollPane1.setViewportView(jListProductos);

        jTextAreaComentario.setEditable(false);
        jTextAreaComentario.setColumns(20);
        jTextAreaComentario.setRows(5);
        jScrollPane3.setViewportView(jTextAreaComentario);

        jLabel8.setText("Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jButtonAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFinalizar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonFinalizar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(DetallesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetallesPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaComentario;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldFechaHora;
    private javax.swing.JTextField jTextFieldIdPedido;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
