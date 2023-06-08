/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Archivos.Archivo;
import Control.AdmCompra;
import Modelo.Vehiculo;
import Visual.frmRealizarCompra;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
 */
public class frmConsultarCompras extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    AdmCompra adm = new AdmCompra();
    Archivo x = new Archivo();
    DefaultTableModel hola = new DefaultTableModel();
    public static ArrayList<Vehiculo> xx = new ArrayList<Vehiculo>();
    public static ArrayList<Vehiculo> cancelados = new ArrayList<Vehiculo>();
    public static String fecha;

    public frmConsultarCompras() {
        this.setContentPane(fondo);
        modelo();
        initComponents();
        this.setTitle("Consulta de Compras");
        //092657969bloquear();
    }

    public void llenar(Vehiculo p) {
        xx.add(p);
    }

    public void modelo() {
        hola.addColumn("CHASIS");
        hola.addColumn("MARCA");
        hola.addColumn("MODELO");
        hola.addColumn("COLOR");
        hola.addColumn("AÑO");
        hola.addColumn("PRECIO");
        hola.addColumn("MODO DE PAGO");
        hola.addColumn("PRECIO FINAL");
        hola.addColumn("CUOTA");
        hola.addColumn("FECHA");
        ingresar();
    }

    public void ingresar() {
        int fila = 0;

        hola.setNumRows(0);
        for (Vehiculo p : xx) {
            hola.addRow(new Object[1]);
            hola.setValueAt(p.getNumchasis(), fila, 0);
            hola.setValueAt(p.getMarca(), fila, 1);
            hola.setValueAt(p.getModelo(), fila, 2);
            hola.setValueAt(p.getColor(), fila, 3);
            hola.setValueAt(p.getAnio(), fila, 4);
            hola.setValueAt(p.getPrecio(), fila, 5);
            hola.setValueAt(p.getModoPago(), fila, 6);
            hola.setValueAt(p.getPrecioFinal(), fila, 7);
            hola.setValueAt(p.getCuota(), fila, 8);
            hola.setValueAt(fecha, fila, 9);

            fila++;
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

        jPanel1 = new javax.swing.JPanel();
        chasis = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtConsultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        chasis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chasisKeyTyped(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblCompras.setModel(hola);
        jScrollPane1.setViewportView(tblCompras);

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESIONE EN CANCELAR PARA ELIMINAR UNA COMPRA POR #CHASIS ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        txtConsultar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtConsultar.setText("Consultar Compras");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(txtConsultar)
                .addContainerGap(399, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chasis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(chasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCancelar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    /* public void bloquear(){
        tblCompras.setEnabled(false);
        
      
        
    }*/
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        /*bloquear();
       btnConsultar.setEnabled(false);*/
        for (int i = 0; i < xx.size(); i++) {
            if (xx.get(i).getNumchasis().equalsIgnoreCase(chasis.getText())) {
                adm.añadircancelados(xx.get(i), fecha);
                xx.remove(i);
                x.llenarArreglo();
                x.elimnarCancelados(chasis.getText());
                x.eliminartxt();
                x.archivoVehiculos();
                x.volverallenar(fecha);
                dispose();
                new frmConsultarCompras().setVisible(true);
            }
        }


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chasisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chasisKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') || (chasis.getText().trim().length() >= 3)) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_chasisKeyTyped
    private void llenarTabla(JTable tabla, ArrayList<Vehiculo> lista) {
        int fila = 0;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //borrar todas las filas del jtable
        modelo.setNumRows(0);
        if (!lista.isEmpty()) {
            //recorrer la lista
            for (Vehiculo v : lista) {
                modelo.addRow(new Object[1]);
                tabla.setValueAt(v.getMarca(), fila, 0);
                tabla.setValueAt(v.getModelo(), fila, 1);
                tabla.setValueAt(v.getColor(), fila, 2);
                tabla.setValueAt(v.getAnio(), fila, 3);
                tabla.setValueAt(v.getPrecio(), fila, 4);
                tabla.setValueAt(v.getFechaCompra(), fila, 5);
                tabla.setValueAt(v.getModoPago(), fila, 6);
                tabla.setValueAt(v.getPrecioFinal(), fila, 7);
                tabla.setValueAt(v.getCuota(), fila, 8);
                fila++;
            }
        }

    }

    public void llenarTabla() {
        llenarTabla(tblCompras, adm.getListadoCompras());
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
            java.util.logging.Logger.getLogger(frmConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultarCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField chasis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompras;
    private javax.swing.JLabel txtConsultar;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Picture/M1.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
            super.paint(g);
        }
    }

}
