/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import coldware.Planeta;
import coldware.tipoplanetas.PlanetaNormal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author sergi
 */
public class CrearEquipos extends javax.swing.JFrame {

    /**
     * Creates new form CrearEquipos
     */
    int contJugadores = -1;
    private ControlPartida control;
    private String[] tipos = new String[]{"Elige planeta", "Normal", "Sejuani", "Gigante", "Rojo", "Azul", "Verde", "Vampiro", "Zombie"};

    public CrearEquipos() {
        initComponents();
        jPanel1.setOpaque(true);
        JLabel myLabel = new JLabel();

    }

    CrearEquipos(ControlPartida aThis) {

        initComponents();

        jPanel1.setOpaque(false);
        this.setResizable(false);
       
          int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

       
         this.setBounds((ancho/2) - (this.getWidth()/2 ), (alto/2 ) - (this.getHeight()/2 ), 1027, 550);
        jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\INFORMACION.jpg")); 
         jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\fondocrearequipos1.jpg")); // NOI18N
         jLabel2.setVisible(false);
          jLabel1.setVisible(true);
          jButton1.setVisible(false);
          cursores();
        control = aThis;
    }

    void cursores(){
        
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    private void addEquipo(int a) {

        for (int i = 0; i < a; i++) {
            contJugadores++;
            JLabel jLabel = new javax.swing.JLabel();
            JPanel jPanel = new javax.swing.JPanel();

            jPanel.setOpaque(false);

           
            final JLabel jLabelimg = new javax.swing.JLabel();
            JTextField jTextField = new JTextField();
            JComboBox<String> jComboBox = new JComboBox<String>();
            jPanel.setMinimumSize(new java.awt.Dimension(133, 20));

            Font fuente = new Font("Calibri", 3, 19);
            jLabel.setFont(fuente);
            jLabel.setText("Planeta " + (contJugadores + 1) + ":");
            jPanel.add(jLabel);
            jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\QuestionMarkSquare64.png")); // NOI18N

            jTextField.setColumns(25);
            jTextField.setDocument(new JTextFieldLimit(10));
            jPanel.add(jTextField);

            jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(tipos));
            jPanel.add(jComboBox);
            jPanel.add(jLabelimg);

            jPanel1.add(jPanel);

            jComboBox.addActionListener((arg0) -> {

                if ("Sejuani".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\SejuaniSquare64.png")); // NOI18N
                } else if ("Normal".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\MissFortuneSquare64.png")); // NOI18N
                } else if ("Elije planeta".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\QuestionMarkSquare64.png")); // NOI18N
                } else if ("Gigante".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\GragasSquare64.png")); // NOI18N
                } else if ("Azul".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FizzSquare64.png")); // NOI18N
                } else if ("Rojo".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\BrandSquare64.png")); // NOI18N
                } else if ("Verde".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\IvernSquare64.png")); // NOI18N
                } else if ("Vampiro".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\VladimirSquare.png")); // NOI18N
                } else if ("Zombie".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\AmumuSquare.png")); // NOI18N
                }

            }
            );

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
        btn_add = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();
        btn_info = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 570, 410));

        btn_add.setBorder(null);
        btn_add.setBorderPainted(false);
        btn_add.setContentAreaFilled(false);
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 180, 40));

        btn_create.setBorder(null);
        btn_create.setBorderPainted(false);
        btn_create.setContentAreaFilled(false);
        btn_create.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 220, 60));

        btn_info.setBorder(null);
        btn_info.setBorderPainted(false);
        btn_info.setContentAreaFilled(false);
        btn_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_infoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 130, 60));

        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 80, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 520));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Alex\\Documents\\DAW2\\Programacion\\ColdWarSwingBo\\src\\main\\java\\img\\INFORMACION.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (contJugadores < 5) {
            addEquipo(1);
            pack();
        }


    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed

        List<Planeta> planetas = new ArrayList<>();
        List Nplanetas = new ArrayList();
        // TODO add your handling code here:

        for (int i = 0; i < jPanel1.getComponents().length; i++) {
            String NombrePlaneta = null;
            String TipoPlaneta = null;
            JPanel jPanelPosicion = (JPanel) jPanel1.getComponent(i);
            for (int j = 0; j < jPanelPosicion.getComponents().length; j++) {

                if (jPanelPosicion.getComponent(j) instanceof JTextField) {

                    NombrePlaneta = ((JTextField) jPanelPosicion.getComponent(j)).getText();
                    Nplanetas.add(NombrePlaneta);
                    if (NombrePlaneta.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Debes poner un nombre a tu equipo", "Error", JOptionPane.ERROR_MESSAGE);

                        return;

                    }
                } else if (jPanelPosicion.getComponent(j) instanceof JComboBox) {
                    TipoPlaneta = (String) ((JComboBox) jPanelPosicion.getComponent(j)).getSelectedItem();
                    // System.out.println(Arrays.toString((String[])combo.getSelectedItem()));
                    System.out.println("Planeta " + (contJugadores) + ":" + NombrePlaneta);

                } else if (jPanelPosicion.getComponent(j) instanceof JComboBox) {

                    // System.out.println(Arrays.toString((String[])combo.getSelectedItem()));
                    // System.out.println("Planeta "+(contJugadores)+":"+NombrePlaneta);
                    System.out.println(((JComboBox) jPanelPosicion.getComponent(j)).getSelectedItem());

                }

            }

            final String cmp = NombrePlaneta;
            if (planetas.stream().map(e -> e.getNombre()).anyMatch(m -> m.equals(cmp))) {
                JOptionPane.showMessageDialog(null, "Se repite algun nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                if (NombrePlaneta.length() != 0 && TipoPlaneta != null) {
                    planetas.add(control.getPartida().crearPlanetas(i, TipoPlaneta, NombrePlaneta));

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debes elegir tipo de planeta", "Error", JOptionPane.ERROR_MESSAGE);
                return;

            }

        }
          if (planetas.size()<2) {
                JOptionPane.showMessageDialog(null, "Minimo 2 equipos para jugar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        this.setVisible(false);
        control.empezar(planetas);

        this.setExtendedState(ICONIFIED);

        dispose();


    }//GEN-LAST:event_btn_createActionPerformed

    private void btn_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_infoActionPerformed
        // TODO add your handling code here:
        
        jPanel1.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(true);
        jButton1.setVisible(true);
        btn_add.setVisible(false);
        btn_create.setVisible(false);
        btn_info.setVisible(false);
    }//GEN-LAST:event_btn_infoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
          jLabel1.setVisible(true);
        jLabel2.setVisible(false);
        jButton1.setVisible(true);
        jPanel1.setVisible(true);
         btn_add.setVisible(true);
        btn_create.setVisible(true);
        btn_info.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

class JTextFieldLimit extends PlainDocument {

    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
