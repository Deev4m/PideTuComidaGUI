/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pidetucomida.gui.pojo.Pedido;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dev
 */
public class Main extends javax.swing.JFrame {

    String url = "http://localhost:8080/PideTuComidaAPI/resources/api/pedidos";
    Timer timer;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        estiloTabla();
        mostrarPedidosEnTabla();

        // Iniciar el timer para actualizar la tabla en tiempo real
        timer = new Timer();
        timer.schedule(new actualizarTablaTask(), 0, 5000); // Actualizar cada 5 segundos
    }

    public void estiloTabla() {
        setTitle("Gestor de pedidos - Pide Tu Comida");
        setLocationRelativeTo(null); // Se abre en el centro siempre
        // Cambiar el color de fondo a #014B10
        getContentPane().setBackground(Color.decode("#014B10"));

        // Cambiar el color de fondo de la tabla
        jTable1.setBackground(new Color(1, 75, 16));

        // Quitar el borde de la tabla
        jTable1.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Cambiar el color del texto de las filas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setForeground(Color.WHITE); // Establece el color del texto
        jTable1.setDefaultRenderer(Object.class, renderer);

        // Agregar el MouseAdapter para detectar el doble clic en la tabla
        try {
            jTable1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Verificar si se hizo doble clic
                        int filaSeleccionada = jTable1.getSelectedRow();
                        if (filaSeleccionada != -1) { // Para verificar si hay una fila seleccionada y así no salta la excepción
                            int idPedido = (int) jTable1.getValueAt(filaSeleccionada, 0);
                            String fecha = (String) jTable1.getValueAt(filaSeleccionada, 1);
                            String comentario = (String) jTable1.getValueAt(filaSeleccionada, 2);
                            DetallesPedido detallesPedido = new DetallesPedido(idPedido, fecha, comentario);
                            detallesPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Configurar el comportamiento de cierre
                            detallesPedido.setVisible(true);
                        }
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("");
        }

        // Hacer que el JTable se ajuste al tamaño preferido
        jTable1.setFillsViewportHeight(true);
    }

    public void mostrarPedidosEnTabla() {
        try {
            URL direccion = new URL(url);
            HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder resultado = new StringBuilder();
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            rd.close();
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            // Obtener el resultado como cadena JSON
            String json = resultado.toString();

            // Usar Gson para parsear el JSON en una lista de objetos Pedido
            Gson gson = new Gson();
            ArrayList<Pedido> pedidos = gson.fromJson(json, new TypeToken<ArrayList<Pedido>>() {
            }.getType());

            // Recorrer la lista de pedidos y agregar filas a la tabla
            for (Pedido p : pedidos) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getFechaPedido(),
                    p.getComentario(),
                    p.getFormaDePago()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPedidoDeTabla(int idPedido) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            int id = (int) model.getValueAt(i, 0); // Suponiendo que la columna 0 contiene el ID del pedido
            if (id == idPedido) {
                model.removeRow(i);
                break;
            }
        }
    }

    // Subclase para actualizar la tabla en 'tiempo real'
    public class actualizarTablaTask extends TimerTask {

        @Override
        public void run() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    mostrarPedidosEnTabla();
                }
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAddProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Pedido", "Fecha", "Comentario", "Forma de pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAddProducto.setText("Añadir producto");
        jButtonAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jButtonAddProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCerrar)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonAddProducto))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductoActionPerformed
        AddProducto addProducto = new AddProducto();
        addProducto.setVisible(true);
    }//GEN-LAST:event_jButtonAddProductoActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProducto;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
