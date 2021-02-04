/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import coldware.Planeta;
import coldware.tipoplanetas.PlanetaNormal;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

/**
 *
 * @author sergi
 */
public class CrearEquipos extends javax.swing.JFrame {

    /**
     * Creates new form CrearEquipos
     */
   static int contJugadores = -1;
    private String[] tipos = new String[]{"Elije planeta","Normal","Sejuani","Gigante","Rojo","Azul","Verde"};
    public CrearEquipos() {
        initComponents();
        addEquipo(3);
    }
    
    private void addEquipo(int a){
      
        
        
        for (int i = 0; i < a; i++) {
            contJugadores++;
            JLabel jLabel = new javax.swing.JLabel();
            JPanel jPanel = new javax.swing.JPanel();
              
            final JLabel jLabelimg = new javax.swing.JLabel();
            JTextField jTextField = new JTextField();
            JComboBox<String> jComboBox = new JComboBox<String>();
            jPanel.setMinimumSize(new java.awt.Dimension(133, 20));
            jLabel.setText("Planeta "+(contJugadores+1)+":");
            jPanel.add(jLabel);
            jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\QuestionMarkSquare64.png")); // NOI18N
            
            jTextField.setColumns(25);
            jPanel.add(jTextField);

            jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(tipos));
            jPanel.add(jComboBox);
            jPanel.add(jLabelimg);
            jPanel1.add(jPanel);
            
            
            
            jComboBox.addActionListener((arg0) -> {

                if ("Sejuani".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\SejuaniSquare64.png")); // NOI18N
                }else if ("Normal".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\MissFortuneSquare64.png")); // NOI18N
                }else if ("Elije planeta".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\QuestionMarkSquare64.png")); // NOI18N
                }else if ("Gigante".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\GragasSquare64.png")); // NOI18N
                }else if ("Azul".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FizzSquare64.png")); // NOI18N
                }else if ("Rojo".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\BrandSquare64.png")); // NOI18N
                }else if ("Verde".equals(jComboBox.getSelectedItem())) {
                    jLabelimg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\IvernSquare64.png")); // NOI18N
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

        labelEquipos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelEquipos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelEquipos.setText("Crear Equipos");
        labelEquipos.setToolTipText("");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMinimumSize(new java.awt.Dimension(133, 20));
        jPanel3.add(jLabel2);

        jPanel1.add(jPanel3);

        btn_add.setText("Añadir");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_create.setText("Crear");
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_create)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_create))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
       if (contJugadores<5){
           addEquipo(1);
        pack(); 
           
       }
        
       
       
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        // TODO add your handling code here:
        String TipoPlaneta = null;
        
        
        
        for (int i = 0; i < jPanel1.getComponents().length; i++) {
            String NombrePlaneta = null;
            
            JPanel jPanelPosicion = (JPanel) jPanel1.getComponent(i);
            for (int j = 0; j < jPanelPosicion.getComponents().length; j++) {
                
                if (jPanelPosicion.getComponent(j) instanceof JTextField){
                    NombrePlaneta=((JTextField)jPanelPosicion.getComponent(j)).getText();
                    
                   // System.out.println(Arrays.toString((String[])combo.getSelectedItem()));
                    //System.out.println("Planeta:"+NombrePlaneta);
                   
                    
                } 
               else if (jPanelPosicion.getComponent(j) instanceof JComboBox){
            
                   // System.out.println(Arrays.toString((String[])combo.getSelectedItem()));
                   // System.out.println("Planeta "+(contJugadores)+":"+NombrePlaneta);
                   
                    //System.out.println( ((JComboBox)jPanelPosicion.getComponent(j)).getSelectedItem());
                    TipoPlaneta=(String) ((JComboBox)jPanelPosicion.getComponent(j)).getSelectedItem();
                    crearPlanetas(TipoPlaneta, NombrePlaneta);
                }
                
                
            }
            
            //Planeta planeta = new PlanetaNormal(i,NombrePlaneta, Partida);
        }
         new AccionPlanetas();
        this.setVisible(false);
    }//GEN-LAST:event_btn_createActionPerformed

    public Planeta crearPlanetas(String TipoPlaneta, String NombrePlaneta){
        
         System.out.println("esta es la funcion"+TipoPlaneta);
         
          switch(TipoPlaneta) 
        { 
            case "Sejuani": 
                System.out.println("Sejuani switch "); 
                System.out.println(NombrePlaneta);
                        
                     
                break; 
            case "Normal": 
                System.out.println("Normal switch"); 
                  System.out.println(NombrePlaneta);
                break; 
            case "Gigante": 
                System.out.println("Gigante switch");
                  System.out.println(NombrePlaneta);
                break; 
                   case "Azul": 
                System.out.println("Azul switch"); 
                  System.out.println(NombrePlaneta);
                break; 
            case "Rojo": 
                System.out.println("Rojo switch"); 
                  System.out.println(NombrePlaneta);
                break; 
                   case "Verde": 
                System.out.println("Verde switch");
                  System.out.println(NombrePlaneta);
                break; 
           
            
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelEquipos;
    // End of variables declaration//GEN-END:variables
}
