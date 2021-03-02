/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;


import coldware.Planeta;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;


/**
 *
 * @author Alex
 */
public class AccionPlanetas extends javax.swing.JDialog {

    /**
     * Creates new form AccionPlanetas
     */
    private int jugador = 0;
    private List<Planeta> planetas;
    private static int ncontador=0;
    private int atacado = 0;
    private int misilesTirados  = 0;
    private boolean atacar;
    private boolean defender;
    
    
 
    public AccionPlanetas(List<Planeta> planetas,int i){
        this.jugador = i;
        this.planetas = planetas;
        initComponents();
        jSpinnerAtacar.setModel(new SpinnerNumberModel(0,0,planetas.get(jugador).getMisiles_ronda(),1));
        jSpinnerDefender.setModel(new SpinnerNumberModel(0,0,planetas.get(jugador).getMisiles_ronda()/2,1));
       
        imgplaneta();
       jLabel7.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\fondoaccionplanetas1.jpg")); // NOI18N
        jTextFieldAtacar.setVisible(false);
        jTextFieldDefender.setVisible(false);
        jComboBoxEquipos.setVisible(false);
        jButtonEjecutar.setVisible(false);
        jSpinnerAtacar.setVisible(false);
        jSpinnerDefender.setVisible(false);
        anadirPlanetasComboBox();
        this.setModal(true);
        this.setVisible(true);
        
       
        
        
        
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButtonAtacar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonDefender = new javax.swing.JButton();
        jTextFieldDefender = new javax.swing.JTextField();
        jComboBoxEquipos = new javax.swing.JComboBox<>();
        jTextFieldAtacar = new javax.swing.JTextField();
        jButtonEjecutar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerAtacar = new javax.swing.JSpinner();
        jSpinnerDefender = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(planetas.get(jugador).getNtipoplaneta());
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jButtonAtacar.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\ATACAR.png")); // NOI18N
        jButtonAtacar.setBorder(null);
        jButtonAtacar.setBorderPainted(false);
        jButtonAtacar.setContentAreaFilled(false);
        jButtonAtacar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 80));

        jButtonDefender.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\DEFENDER.png")); // NOI18N
        jButtonDefender.setBorder(null);
        jButtonDefender.setBorderPainted(false);
        jButtonDefender.setContentAreaFilled(false);
        jButtonDefender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonDefender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefenderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jTextFieldDefender.setText(" ");
        getContentPane().add(jTextFieldDefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 39, -1));

        jComboBoxEquipos.setBackground(new java.awt.Color(255, 170, 0));
        jComboBoxEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jTextFieldAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 36, -1));

        jButtonEjecutar.setText("Ejecutar");
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 299, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Misiles:  "+planetas.get(jugador).getMisiles_ronda());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 185, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Vida:  "+planetas.get(jugador).getVidas());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(planetas.get(jugador).getNombre());
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));
        getContentPane().add(jSpinnerAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 50, 40));
        getContentPane().add(jSpinnerDefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtacarActionPerformed
        
        jTextFieldAtacar.setVisible(true);
        jTextFieldDefender.setVisible(false);
        jComboBoxEquipos.setVisible(true); 
        jButtonEjecutar.setVisible(true);
        jSpinnerAtacar.setVisible(true);
        jSpinnerDefender.setVisible(false);
         atacar=true;
         defender=false;
        this.setModal(true);
         this.setVisible(true);
        
         
        //TEST BAJA 50 MISILES
        
      
    }//GEN-LAST:event_jButtonAtacarActionPerformed


  
    private void jTextFieldAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAtacarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextFieldAtacarActionPerformed

    private void jButtonDefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefenderActionPerformed
        jTextFieldAtacar.setVisible(false);
        jTextFieldDefender.setVisible(true);
        jComboBoxEquipos.setVisible(false); 
        jButtonEjecutar.setVisible(true);
        jSpinnerAtacar.setVisible(false);
        jSpinnerDefender.setVisible(true);
        atacar=false;
        defender=true;
        this.setModal(true);
         this.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonDefenderActionPerformed

    private void jComboBoxEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquiposActionPerformed



        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEquiposActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed

        
        if (atacar){
            jComboBoxEquipos.getSelectedItem();
        
         this.misilesTirados =(Integer)jSpinnerAtacar.getValue();
        for(int j = 0; j < planetas.size();j++){
            if(this.planetas.get(j).getNombre().equals(jComboBoxEquipos.getSelectedItem())){
                this.atacado =j+1;
                break;
            }
        }
       dispose();
        
        }else if (defender){
        
            this.misilesTirados = (Integer)jSpinnerDefender.getValue();
           this.atacado =0;
           
            dispose();
        }
  
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

   
 

    public int getAtacado() {
        return atacado;
    }

    public int getMisilesTirados() {
        return misilesTirados;
    }

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtacar;
    private javax.swing.JButton jButtonDefender;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JComboBox<String> jComboBoxEquipos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinnerAtacar;
    private javax.swing.JSpinner jSpinnerDefender;
    private javax.swing.JTextField jTextFieldAtacar;
    private javax.swing.JTextField jTextFieldDefender;
    // End of variables declaration//GEN-END:variables

    private void imgplaneta() {

        
        if ("Planeta Sejuani".equals(planetas.get(jugador).getNtipoplaneta())){
             jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\SejuaniSquare64.png")); // NOI18N
       
        }else if ("Planeta Normal".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\MissFortuneSquare64.png")); // NOI18N 
        }else if ("Planeta Gigante".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\GragasSquare64.png")); // NOI18N 
        }else if ("Planeta Azul".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FizzSquare64.png")); // NOI18N 
        }else if ("Planeta Rojo".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\BrandSquare64.png")); // NOI18N 
        }else if ("Planeta Verde".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\IvernSquare64.png")); // NOI18N 
        }else if ("Planeta Vampiro".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\VladimirSquare.png")); // NOI18N 
        }else if ("Planeta Zombie".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\AmumuSquare.png")); // NOI18N 
        }
        
        
        
        
        
        
    }

    public void anadirPlanetasComboBox() {
       String labels[] =new String [(planetas.size())-1];
       int contlabel=0;
        for(int j = 0; j < planetas.size();j++){
       if(j!=jugador){
           
           labels[contlabel]=(this.planetas.get(j).getNombre());
       contlabel++;
       }
       
      
                
        
        }
        DefaultComboBoxModel Model=new DefaultComboBoxModel(labels);
        jComboBoxEquipos.setModel(Model);

    }
    
    
}