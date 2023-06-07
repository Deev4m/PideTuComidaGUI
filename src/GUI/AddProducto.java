/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pidetucomida.pojo.gui.Ingrediente;
import com.pidetucomida.pojo.gui.IngredienteProducto;
import com.pidetucomida.pojo.gui.Producto;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dev
 */
public class AddProducto extends javax.swing.JFrame {

    final String URL_INSERTAR_PRODUCTO = "http://localhost:8080/PideTuComidaServer/resources/api/productos/insert";
    final String URL_INSERTAR_INGREDIENTES = "http://localhost:8080/PideTuComidaServer/resources/api/ingredientesInsert";
    final String URL_INSERTAR_INGREDIENTES_A_PRODUCTO = "http://localhost:8080/PideTuComidaServer/resources/api/ingredientesInsertEnProducto";
    int idProducto;
    ArrayList<Integer> idIngredientes;

    /**
     * Creates new form AddProducto
     */
    public AddProducto() {
        initComponents();
        estilo();
    }

    public void estilo() {
        jTextAreaDescripcion.setLineWrap(true);
        jTextAreaDescripcion.setWrapStyleWord(true);

        setTitle("Añadir Producto");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Se abre en el centro siempre
        // Cambiar el color de fondo a #014B10
        getContentPane().setBackground(Color.decode("#014B10"));
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);
        jLabel3.setForeground(Color.WHITE);
        jLabel4.setForeground(Color.WHITE);
        jLabel5.setForeground(Color.WHITE);

        // Para evitar que se redimensione la ventana al introducir una ruta
        jTextFieldRutaImagen.setPreferredSize(jTextFieldRutaImagen.getSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNombreProducto2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscarImagen = new javax.swing.JButton();
        jTextFieldRutaImagen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jTextFieldPrecioProducto = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jComboBoxSeleccionableTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIngredientes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre");

        jButtonBuscarImagen.setText("Buscar imagen");
        jButtonBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarImagenActionPerformed(evt);
            }
        });

        jTextFieldRutaImagen.setEditable(false);

        jLabel2.setText("Precio");

        jLabel3.setText("Tipo");

        jLabel4.setText("Ingredientes");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jComboBoxSeleccionableTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hamburguesa", "Pizza", "Kebab", "HotDog" }));

        jLabel5.setText("Descripción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButtonAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonBuscarImagen)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldPrecioProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jTextFieldRutaImagen)
                                    .addComponent(jTextFieldNombreProducto)
                                    .addComponent(jComboBoxSeleccionableTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarImagen)
                    .addComponent(jTextFieldRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxSeleccionableTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonAtras))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarImagenActionPerformed
        // Para abrir el explorador de archivos y elegir una imagen
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            String imagenUrl = fichero.getAbsolutePath();
            System.out.println("URL de la imagen seleccionada: " + imagenUrl);
            jTextFieldRutaImagen.setText(imagenUrl);
        }
    }//GEN-LAST:event_jButtonBuscarImagenActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        String rutaImagen = jTextFieldRutaImagen.getText();
        String nombreProducto = jTextFieldNombreProducto.getText();
        String precioProducto = jTextFieldPrecioProducto.getText();
        String tipoSeleccionado = (String) jComboBoxSeleccionableTipo.getSelectedItem();
        String ingredientes = jTextFieldIngredientes.getText();
        String descripcion = jTextAreaDescripcion.getText();

        // Verificar si alguno de los campos requeridos está vacío
        if (rutaImagen.isEmpty() || nombreProducto.isEmpty() || precioProducto.isEmpty() || tipoSeleccionado.isEmpty() || ingredientes.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            double precio = Double.parseDouble(precioProducto);
            agregarProducto(rutaImagen, nombreProducto, precio, tipoSeleccionado, ingredientes, descripcion);

            // Limpiar los campos después de la inserción
            jTextFieldRutaImagen.setText("");
            jTextFieldNombreProducto.setText("");
            jTextFieldPrecioProducto.setText("");
            jComboBoxSeleccionableTipo.setSelectedIndex(0);
            jTextFieldIngredientes.setText("");
            jTextAreaDescripcion.setText("");

            agregarIngredientes(ingredientes);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe poner un número en 'Precio'. (Ejemplo: 10.20)", "Formato erróneo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    public void agregarProducto(String rutaImagen, String nombreProducto, double precioProducto, String tipoSeleccionado, String ingredientes, String descripcion) {
        HttpURLConnection conexion = null;
        FileInputStream ficheroIn = null;
        try {
            // Leer la imagen y convertirla en un arreglo de bytes
            File fichero = new File(rutaImagen);//digo que fichero es y directorio
            byte[] buff = null;
            if (fichero.exists()) {
                ficheroIn = new FileInputStream(fichero);//con esto leeré el fichero para convertirlo en un array de bytes
                long bytes = fichero.length();//cojo la longitud del fichero
                buff = new byte[(int) bytes];//creo un array de bytes de la misma longitud
                int i, j = 0;//declaro variables
                while ((i = ficheroIn.read()) != -1) {//leo el fichero y lo guardo en un array de bytes
                    buff[j] = (byte) i;
                    j++;
                }
            }

            URL direccion = new URL(URL_INSERTAR_PRODUCTO);
            conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            conexion.setRequestProperty("Content-Type", "application/json");

            Producto p = new Producto();
            p.setImg(buff);
            p.setNombre(nombreProducto);
            p.setPrecio(precioProducto);
            p.setTipo(tipoSeleccionado);
            p.setDescripcion(descripcion);

            Gson gson = new Gson();
            String jsonProducto = gson.toJson(p);

            try (OutputStream outputStream = conexion.getOutputStream()) {
                byte[] input = jsonProducto.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }
            // Obtener la respuesta del servidor
            int responseCode = conexion.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // El producto se insertó correctamente
                String response = "";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response += line;
                    }
                }
                idProducto = Integer.parseInt(response);
                JOptionPane.showMessageDialog(this, "Producto insertado correctamente", "Producto insertado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                conexion.disconnect();
            }
            if (ficheroIn != null) {
                try {
                    ficheroIn.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar");
                }
            }
        }
    }

    public void agregarIngredientes(String ingredientes) { // Agrego los ingredientes a la base de datos
        // Lechuga, toMate,      ceboLLA, aguaCate, huevo frito, queso
        HttpURLConnection conexion = null;
        try {
            URL direccion = new URL(URL_INSERTAR_INGREDIENTES);
            conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            conexion.setRequestProperty("Content-Type", "application/json");

            Gson gson = new Gson();
            String[] ingredientesArray = ingredientes.split(",");
            ArrayList<Ingrediente> listaIngredientes = new ArrayList<>();

            for (String i : ingredientesArray) {
                Ingrediente in = new Ingrediente();
                in.setNombre(primeraLetraMayuscula(i.trim()));
                listaIngredientes.add(in);
            }

            String jsonIngredientes = gson.toJson(listaIngredientes);
            // Escribir los datos en la conexión y enviarlos al servidor
            try (OutputStream outputStream = conexion.getOutputStream()) {
                byte[] input = jsonIngredientes.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            int responseCode = conexion.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = "";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response += line;
                    }
                }
                idIngredientes = gson.fromJson(response, new TypeToken<ArrayList<Integer>>() {
                }.getType());
            }
            agregarIngredientesAProducto();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                conexion.disconnect();
            }
        }
    }

    public static String primeraLetraMayuscula(String ingrediente) {
        if (ingrediente == null || ingrediente.isEmpty()) {
            return "";
        }
        String ingredienteFormateado = ingrediente.trim();
        ingredienteFormateado = ingredienteFormateado.substring(0, 1).toUpperCase() + ingredienteFormateado.substring(1).toLowerCase();
        return ingredienteFormateado;
    }

    public void agregarIngredientesAProducto() {
        // Lechuga, toMate,      ceboLLA, aguaCate, huevo frito, queso
        HttpURLConnection conexion = null;
        try {
            URL direccion = new URL(URL_INSERTAR_INGREDIENTES_A_PRODUCTO);
            conexion = (HttpURLConnection) direccion.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            conexion.setRequestProperty("Content-Type", "application/json");

            Gson gson = new Gson();
            IngredienteProducto ip = new IngredienteProducto(idProducto, idIngredientes);
            String jsonIngredienteProducto = gson.toJson(ip);

            // Escribir los datos en la conexión y enviarlos al servidor
            try (OutputStream outputStream = conexion.getOutputStream()) {
                byte[] input = jsonIngredienteProducto.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            int responseCode = conexion.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = "";
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response += line;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                conexion.disconnect();
            }
        }
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
            java.util.logging.Logger.getLogger(AddProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBuscarImagen;
    private javax.swing.JComboBox<String> jComboBoxSeleccionableTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldIngredientes;
    private javax.swing.JTextField jTextFieldNombreProducto;
    private javax.swing.JTextField jTextFieldNombreProducto2;
    private javax.swing.JTextField jTextFieldPrecioProducto;
    private javax.swing.JTextField jTextFieldRutaImagen;
    // End of variables declaration//GEN-END:variables
}
