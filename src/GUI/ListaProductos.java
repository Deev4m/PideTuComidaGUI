/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pidetucomida.pojo.gui.Producto;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dev
 */
public class ListaProductos extends javax.swing.JFrame {

    String urlProductos = "http://localhost:8080/PideTuComidaServer/resources/api/productos";
    String urlBorrarProducto = "http://localhost:8080/PideTuComidaServer/resources/api/productos/borrar/";

    /**
     * Creates new form ListaProductos
     */
    public ListaProductos() {
        initComponents();

        estilo();
        mostrarProductos();
    }

    public void estilo() {
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#014B10"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cambiar el color de fondo de la tabla
        jTable1.setBackground(new Color(1, 75, 16));

        // Quitar el borde de la tabla
        jTable1.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Cambiar el color del texto de las filas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setForeground(Color.WHITE); // Establece el color del texto
        jTable1.setDefaultRenderer(Object.class, renderer);

        // Hacer que el JTable se ajuste al tamaño preferido
        jTable1.setFillsViewportHeight(true);
    }

    public void mostrarProductos() {
        HttpURLConnection conexion = null;
        BufferedReader rd = null;
        try {
            URL direccion = new URL(urlProductos);
            conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("GET");

            rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder resultado = new StringBuilder();
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Usar Gson para parsear el JSON en una lista de objetos Pedido
            Gson gson = new Gson();
            ArrayList<Producto> productos = gson.fromJson(resultado.toString(), new TypeToken<ArrayList<Producto>>() {
            }.getType());

            // Recorrer la lista de pedidos y agregar filas a la tabla
            for (Producto p : productos) {
                model.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getNombre(),
                    p.getDescripcion(),});
            }

//            DefaultListModel<String> listModel = new DefaultListModel<>();
//            Gson gson = new Gson();
//            ArrayList<Producto> productos = gson.fromJson(resultado.toString(), new TypeToken<ArrayList<Producto>>() {
//            }.getType());
//
//            // Recorrer la lista de productos y agregar nombres a la lista
//            for (Producto p : productos) {
//                listModel.addElement(p.getIdProducto() + ", \t " + p.getNombre() + ", \t " + p.getDescripcion());
//            }
//            jListProductosAborrar.setModel(listModel); // Establecer el modelo de lista en el JList
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                conexion.disconnect();
            }
            if (rd != null) {
                try {
                    rd.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar");
                }
            }
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

        jButtonBorrarProducto = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonBorrarProducto.setText("Borrar");
        jButtonBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarProductoActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAtras)
                .addGap(39, 39, 39)
                .addComponent(jButtonBorrarProducto)
                .addGap(167, 167, 167))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarProducto)
                    .addComponent(jButtonAtras))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarProductoActionPerformed
        int filaSeleccionda = jTable1.getSelectedRow();
        if (filaSeleccionda != -1) {
            // Parsear el valor seleccionado para obtener el ID del producto
            int id = (int) jTable1.getValueAt(filaSeleccionda, 0);

            // Realizar la petición de borrado al servidor
            HttpURLConnection conexion = null;
            try {
                URL direccion = new URL(urlBorrarProducto + id);
                conexion = (HttpURLConnection) direccion.openConnection();
                conexion.setRequestMethod("DELETE");

                int responseCode = conexion.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) { // Devuelve un 204. El borrado se realizó
                    mostrarProductos();
                } else {
                    System.out.println("Error al borrar el producto. Código de respuesta: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    conexion.disconnect();
                }
            }
        }
    }//GEN-LAST:event_jButtonBorrarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(ListaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBorrarProducto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
