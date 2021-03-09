/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;


import coldware.Planeta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
        String stringVidas="";
        this.jugador = i;
        this.planetas = planetas;
        initComponents();
        anadirImagenes();
         this.setResizable(false);
      
         
               int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

       
         this.setBounds((ancho/2) - (this.getWidth()/2 ), (alto/2 ) - (this.getHeight()/2 ), 1000, 590);
         
         cursores();
         jTextArea1.setBackground(new Color(10,0,0,0));
          jTextArea1.setOpaque(true);
         jTextArea1.setBorder(null);
         jTextArea1.setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 13));
         jScrollPane1.setBorder(null);
         jTextArea1.setHighlighter(null);
         jTextArea1.setEnabled(false);
      
        
        jSpinnerAtacar.setModel(new SpinnerNumberModel(0,0,planetas.get(jugador).getMisiles_ronda(),1));
        jSpinnerDefender.setModel(new SpinnerNumberModel(0,0,planetas.get(jugador).getMisiles_ronda()/2,1));
  
        imgplaneta();
      
        for (int j = 0; j < planetas.size(); j++) {
             stringVidas=stringVidas+"El planeta: "+ planetas.get(j).getNombre()+" tiene => "+planetas.get(j).getVidas()+" vidas\n";
             jTextArea1.setText(stringVidas);
        }
           
        jComboBoxEquipos.setVisible(false);
        jButtonEjecutar.setVisible(false);
        jSpinnerAtacar.setVisible(false);
        jSpinnerDefender.setVisible(false);
      
        anadirPlanetasComboBox();
        anadirImagenes();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonAtacar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonDefender = new javax.swing.JButton();
        jComboBoxEquipos = new javax.swing.JComboBox<>();
        jButtonEjecutar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerAtacar = new javax.swing.JSpinner();
        jSpinnerDefender = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 300, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(planetas.get(jugador).getNtipoplaneta());
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jButtonAtacar.setBorder(null);
        jButtonAtacar.setBorderPainted(false);
        jButtonAtacar.setContentAreaFilled(false);
        jButtonAtacar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 210, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, 100));

        jButtonDefender.setBorder(null);
        jButtonDefender.setBorderPainted(false);
        jButtonDefender.setContentAreaFilled(false);
        jButtonDefender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonDefender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefenderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 210, 40));

        jComboBoxEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 150, -1));

        jButtonEjecutar.setBorder(null);
        jButtonEjecutar.setBorderPainted(false);
        jButtonEjecutar.setContentAreaFilled(false);
        jButtonEjecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 250, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Misiles Ataque:  "+planetas.get(jugador).getMisiles_ronda());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 120, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Vida:  "+planetas.get(jugador).getVidas());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(planetas.get(jugador).getNombre());
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Misiles Defensa:  "+planetas.get(jugador).getMisiles_ronda()/2);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 120, 20));

        jSpinnerAtacar.setModel(new javax.swing.SpinnerListModel(new String[] {"empty"}));
        getContentPane().add(jSpinnerAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 60, 30));
        getContentPane().add(jSpinnerDefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 50, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

void cursores(){
        
        jButtonAtacar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButtonDefender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButtonEjecutar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }
    private void jButtonAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtacarActionPerformed
        
     
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


  
    private void jButtonDefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefenderActionPerformed
     
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
            if (this.misilesTirados==0) {
       
                JOptionPane.showMessageDialog(null, "No puedes atacar con estos misiles", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            
            }
            System.err.println(this.misilesTirados);
        for(int j = 0; j < planetas.size();j++){
            
            if(this.planetas.get(j).getNombre().equals(jComboBoxEquipos.getSelectedItem())){
                this.atacado =planetas.get(j).getNequipo();
                break;
            }
            
        }
      
       dispose();
        
        }else if (defender){
        
            this.misilesTirados = (Integer)jSpinnerDefender.getValue();
             if (this.misilesTirados==0) {
       
                JOptionPane.showMessageDialog(null, "No puedes defenderte con estos misiles", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            
            }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerAtacar;
    private javax.swing.JSpinner jSpinnerDefender;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void imgplaneta() {

        
        if ("Planeta Sejuani".equals(planetas.get(jugador).getNtipoplaneta())){
             jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\SejuaniSquare1.png")); // NOI18N
       
        }else if ("Planeta Normal".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\MissFortuneSquare1.png")); // NOI18N 
        }else if ("Planeta Gigante".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\GragasSquare1.png")); // NOI18N 
        }else if ("Planeta Azul".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FizzSquare1.png")); // NOI18N 
        }else if ("Planeta Rojo".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\BrandSquare1.png")); // NOI18N 
        }else if ("Planeta Verde".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\IvernSquare1.png")); // NOI18N 
        }else if ("Planeta Vampiro".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\VladimirSquare1.png")); // NOI18N 
        }else if ("Planeta Zombie".equals(planetas.get(jugador).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\AmumuSquare1.png")); // NOI18N 
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

    private void anadirImagenes() {
		
		  jButtonEjecutar.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\EJECUTAR.png")); // NOI18N
		  
		  jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\fondoaccionplanetas2.jpg")); // NOI18N
        
        
        
    }
    
    
}