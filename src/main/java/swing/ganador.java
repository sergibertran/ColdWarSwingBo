/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import coldware.ConexionBD;
import coldware.Planeta;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DAW2
 */
public class ganador extends javax.swing.JFrame {
    
 private List<Planeta> planetas;
    /**
     * Creates new form ganador
     */
    public ganador(List<Planeta> planetas) {
        initComponents();
          this.setResizable(false);
     
            int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

       
         this.setBounds((ancho/2) - (this.getWidth()/2 ), (alto/2 ) - (this.getHeight()/2 ), 1195, 760);
          cursores();
        addimg();
        empate(planetas);
        HashMap<String, Integer> Ganadores = new HashMap<String, Integer>();
        File file = new File ("output.xml");
        XStream xstream=new XStream();
       
        ArrayList jugadores1 = null;
        
        
                
        if (planetas.size()!=0){
            
        
        if (file.exists()){
        jugadores1 = (ArrayList)xstream.fromXML(file); //lee
        
          
        
        }else{
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ganador.class.getName()).log(Level.SEVERE, null, ex);
            }
        jugadores1 =new ArrayList();    
        }

        jugadores1.add(planetas.get(0).getNombre()); //añade jugador
        
         for (int i = 0; i < jugadores1.size(); i++) {
            String name=jugadores1.get(i).toString();
            
             if (!Ganadores.containsKey(name)){
                 Ganadores.put(name,1);
                 
             }else{
                  Ganadores.put(name,Ganadores.get(name)+1);
             }
  
            }
       
            System.out.println(Ganadores);
            String hola="pula";
            
             ConexionBD.addGanador(planetas.get(0).getNombre());
         Writer writer = null;
         
        try {
            writer = new FileWriter("output.xml");
            } catch (IOException ex) {
                Logger.getLogger(ganador.class.getName()).log(Level.SEVERE, null, ex);
            }

            xstream.toXML(jugadores1, writer);
        }

        //jLabel1.setText(planetas.get(0).getNombre());
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 643, 220, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 160, 150));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 160, 40));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new Main();
        dispose();
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
            java.util.logging.Logger.getLogger(ganador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ganador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ganador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ganador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }
    
    void cursores(){
        
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    }
    void empate(List<Planeta> planetas){
        
        if(planetas.size()<1){
            jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\empate.jpg")); // NOI18N
        }else{
            addganador(planetas);
        }
    }
    
     void addganador(List<Planeta> planetas){
        
       
        if ("Planeta Sejuani".equals(planetas.get(0).getNtipoplaneta())){
             jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\SejuaniSquare1.png")); // NOI18N
       
        }else if ("Planeta Normal".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\MissFortuneSquare1.png")); // NOI18N 
        }else if ("Planeta Gigante".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\GragasSquare1.png")); // NOI18N 
        }else if ("Planeta Azul".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FizzSquare1.png")); // NOI18N 
        }else if ("Planeta Rojo".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\BrandSquare1.png")); // NOI18N 
        }else if ("Planeta Verde".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\IvernSquare1.png")); // NOI18N 
        }else if ("Planeta Vampiro".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\VladimirSquare1.png")); // NOI18N 
        }else if ("Planeta Zombie".equals(planetas.get(0).getNtipoplaneta())){
            
           jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\AmumuSquare1.png")); // NOI18N 
        }
        
        Font fuente = new Font("Calibri", 3, 19);
            jLabel3.setFont(fuente);
            jLabel3.setText(planetas.get(0).getNombre());
            jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FONDOGANADOR.jpg")); // NOI18N
}
    
    void addimg(){
		 jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\FONDOGANADOR.jpg")); // NOI18N
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
