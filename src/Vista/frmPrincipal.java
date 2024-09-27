package Vista;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class frmPrincipal extends javax.swing.JFrame {
    int Xmouse,Ymouse;

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnIngresarPaciente.setToolTipText("Ingresa como paciente, da acceso a consulta y agendacion de citas");
        btnIngresarPersonal.setToolTipText("Ingresa como paciente, envia al inicio de seccion del personal");
        btnSalir.setToolTipText("Cierra todos las interfaces y procesos existentes");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresarPaciente = new javax.swing.JButton();
        panelPersonal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblIconoPersonal = new javax.swing.JLabel();
        btnIngresarPersonal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        barraMovimiento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IINGRESAR AL SISTEMA");
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(20, 66, 114));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HOSPITAL ESTRUCTURA DE DATOS");

        jPanel1.setBackground(new java.awt.Color(32, 82, 149));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PACIENTE");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoPaciente.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnIngresarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnIngresarSistemaIcono.png"))); // NOI18N
        btnIngresarPaciente.setText("   INGRESAR");
        btnIngresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnIngresarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresarPaciente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonal.setBackground(new java.awt.Color(32, 82, 149));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PERSONAL");

        lblIconoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoEquipoMedico.png"))); // NOI18N
        lblIconoPersonal.setToolTipText("");

        btnIngresarPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnIngresarSistemaIcono.png"))); // NOI18N
        btnIngresarPersonal.setText("   INGRESAR");
        btnIngresarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPersonalLayout = new javax.swing.GroupLayout(panelPersonal);
        panelPersonal.setLayout(panelPersonalLayout);
        panelPersonalLayout.setHorizontalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconoPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersonalLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(btnIngresarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        panelPersonalLayout.setVerticalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIconoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarPersonal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnSalirIcono.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        barraMovimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMovimientoMouseDragged(evt);
            }
        });
        barraMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMovimientoMousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoHospitalIcono.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(panelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(barraMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        ImageIcon SalirConfirmar = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSalirIcono.png");
        int valor = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere salir del sistema?\n Se perderan todos los avances", "CONFIRMACION DE SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, SalirConfirmar);
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIngresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPacienteActionPerformed
        
        FrmMenuPaciente abrir = new FrmMenuPaciente();
        abrir.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnIngresarPacienteActionPerformed

    private void btnIngresarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPersonalActionPerformed
        
        frmPersonalLogin abrir = new frmPersonalLogin();
        abrir.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnIngresarPersonalActionPerformed

    private void barraMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMovimientoMousePressed
        
        Xmouse = evt.getX();
        Ymouse = evt.getY();
        
    }//GEN-LAST:event_barraMovimientoMousePressed

    private void barraMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMovimientoMouseDragged
        
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
        
    }//GEN-LAST:event_barraMovimientoMouseDragged

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barraMovimiento;
    private javax.swing.JButton btnIngresarPaciente;
    private javax.swing.JButton btnIngresarPersonal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIconoPersonal;
    private javax.swing.JPanel panelPersonal;
    // End of variables declaration//GEN-END:variables
}
