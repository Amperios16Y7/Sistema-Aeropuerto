/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aerodb;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import libreriasql.LibreriaSQL;
/**
 *
 * @author jarqu
 */
public class Usuarios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Usuarios.class.getName());
    
    String nombreTabla = "usuarios";
    DefaultTableModel modelo;
    int idRol;
    public Usuarios(int idRol) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.idRol = idRol;
        try {
            String url = "jdbc:mysql://localhost:3306/aero?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "Oqpwwpqo7";

            Class.forName("com.mysql.cj.jdbc.Driver");

            LibreriaSQL.conectar(url, user, password);

            String[] headers = LibreriaSQL.obtenerNombresColumnas(nombreTabla);
            
            modelo = new DefaultTableModel(headers, 0);
            tabla.setModel(modelo);
            modelo.addTableModelListener(e -> {
                if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();

                    if (idRol == 1) {
                        int respuesta = JOptionPane.showConfirmDialog(
                                null,
                                "¿Está seguro de querer modificar el registro?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (respuesta == JOptionPane.YES_OPTION) {
                            if (fila >= 0 && columna >= 0) {
                                String nombreColumna = modelo.getColumnName(columna);
                                Object nuevoValor = modelo.getValueAt(fila, columna);
                                Object idValor = modelo.getValueAt(fila, 0);

                                String condicion = "id = " + idValor;
                                String columnas = nombreColumna;
                                String[] valores = {nuevoValor.toString()};

                                LibreriaSQL.updateRegistro(nombreTabla, columnas, valores, condicion);
                            }
                        } else {
                            
                        }
                    }
                }

            });

            
            String columnas = "*";
            String condicion = null;
            ArrayList<String[]> datos = (ArrayList<String[]>) LibreriaSQL.getData(nombreTabla, columnas, condicion);
            seleccion(datos);
            
            
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void seleccion(ArrayList<String[]> datos){
        if(!datos.isEmpty()){
        modelo.setRowCount(0);
            for (String[] fila : datos) {
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            String nombreColumnaRol = "rol"; // o el nombre exacto de la columna si es diferente
            int indiceColumnaRol = -1;

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                if (modelo.getColumnName(i).equalsIgnoreCase(nombreColumnaRol)) {
                    indiceColumnaRol = i;
                    break;
                }
            }

            if (indiceColumnaRol != -1) {
                String[] roles = {"Administrador", "Empleado", "Invitado", "Supervisor"};
                javax.swing.JComboBox<String> comboBox = new javax.swing.JComboBox<>(roles);
                tabla.getColumnModel().getColumn(indiceColumnaRol).setCellEditor(new javax.swing.DefaultCellEditor(comboBox));
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "No existen datos con esas condiciones");
        }
    }
    
    private void realizarBusqueda(){
        String buscar = txtBuscar.getText().trim();
        if (buscar.isEmpty() || buscar.equals("Buscar . . .")){
            seleccion((ArrayList<String[]>) LibreriaSQL.getData(nombreTabla, "*", null));
            return;
        }

        String[] columnas = LibreriaSQL.obtenerNombresColumnas(nombreTabla);
        ArrayList<String> condiciones = new ArrayList<>();

        for (String col : columnas){
            String valor = buscar.replace("'", "''");
            condiciones.add(col + " LIKE '%" + valor + "%'");
        }

        String condicionFinal = String.join(" OR ", condiciones);
        ArrayList<String[]> datos = (ArrayList<String[]>) LibreriaSQL.getData(nombreTabla, "*", condicionFinal);
        seleccion(datos);
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        botonera = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        top = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panelgrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        botonera.setBackground(new java.awt.Color(0, 153, 255));
        botonera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerodb/return.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        botonera.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 30));

        btnAgregar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerodb/add.png"))); // NOI18N
        btnAgregar.setText("Añadir");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        botonera.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 80));

        btnEliminar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerodb/remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        botonera.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 80));

        top.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerodb/AdmiAcount.png"))); // NOI18N
        jLabel4.setText("Usuarios");

        btnBuscar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 153, 255));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerodb/SEARCHBLUE.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscar.setText("Buscar . . .");
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabla.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setGridColor(new java.awt.Color(0, 153, 255));
        tabla.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout panelgridLayout = new javax.swing.GroupLayout(panelgrid);
        panelgrid.setLayout(panelgridLayout);
        panelgridLayout.setHorizontalGroup(
            panelgridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelgridLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        panelgridLayout.setVerticalGroup(
            panelgridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelgridLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonera, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(panelgrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelgrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        String[] headers = LibreriaSQL.obtenerNombresColumnas(nombreTabla);
        String[] columnasSinId = new String[(headers.length - 1)];
        for (int i = 1; i < headers.length; i++) {
            columnasSinId[i - 1] = headers[i];
        }
        
        String[] aux = LibreriaSQL.obtenerTiposColumnas(nombreTabla);
        String[] tipos = new String[aux.length];
        
        for(int i = 1; i < aux.length; i++){
            tipos[i-1] = aux[i];
        }
        
        String[] valores = agregarRegistro.mostrarYObtener(columnasSinId, tipos);
        if(valores != null){
            LibreriaSQL.insertarRegistro(nombreTabla, valores);
            modelo.setRowCount(0);
            ArrayList<String[]> datos = (ArrayList<String[]>) LibreriaSQL.getData(nombreTabla, "*", null);
            seleccion(datos);
        }
        else{
            return;
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                
            if (respuesta == JOptionPane.YES_OPTION) {
                Object valorPrimeraColumna = tabla.getValueAt(filaSeleccionada, 0);
                String valorPrimera = valorPrimeraColumna.toString();
                int valor = Integer.parseInt(valorPrimera);
                String condicion = " id = " + valor + ";";
                LibreriaSQL.eliminarRegistro(nombreTabla, condicion);
                ArrayList<String[]> datos = (ArrayList<String[]>) LibreriaSQL.getData(nombreTabla, "*", null);
                seleccion(datos);
            } else if (respuesta == JOptionPane.NO_OPTION) {
                
            }
        } else {
            System.out.println("No se ha seleccionado ninguna fila.");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        realizarBusqueda();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        realizarBusqueda();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        dispose();
        new menu(idRol).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel botonera;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelgrid;
    private javax.swing.JTable tabla;
    private javax.swing.JPanel top;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
