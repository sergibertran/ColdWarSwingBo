/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.thoughtworks.xstream.XStream;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author sergi
 */
public class ranking extends javax.swing.JFrame {

    /**
     * Creates new form ranking
     */
    public ranking()  {
        initComponents();
          this.setBounds(400, 100, 1090, 750);
        Font fuente = new Font("Calibri", 3, 19);
            jTextArea2.setFont(fuente);
        jTextArea2.setBackground(Color.orange);
         jTextArea2.setBorder(null);
     
        String ganadore="";
        File file = new File ("output.xml");
        XStream xstream=new XStream();
       HashMap<String, Integer> Ganadores = new HashMap<String, Integer>();
        ArrayList jugadores1 = null;
        
        
        if (file.exists()){
        jugadores1 = (ArrayList)xstream.fromXML(file); //lee
        
        for (int i = 0; i < jugadores1.size(); i++) {
            String name=jugadores1.get(i).toString();
            
             if (!Ganadores.containsKey(name)){
                 Ganadores.put(name,1);
                 
             }else{
                  Ganadores.put(name,Ganadores.get(name)+1);
             }
  
            }

            List<Map.Entry<String, Integer>> ordenar = Ganadores.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            }).collect(Collectors.toList());
      for  (Map.Entry<String, Integer> entry :ordenar ) {
          
     ganadore=ganadore+entry.getKey() + " Partidas ganadas:" + entry.getValue()+"\n";   
          
    jTextArea2.setText(ganadore);
    
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setCaretColor(new java.awt.Color(204, 102, 0));
        jTextArea2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 488, 320));

        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Alex\\Documents\\DAW2\\Programacion\\ColdWarSwingBo\\src\\main\\java\\img\\RANKING.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         new Main();
        this.setVisible(false);
        
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
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
