/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import coldware.Planeta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author DAW2
 */
public class ResumenRonda extends javax.swing.JDialog {

    /**
     * Creates new form ResumenRonda
     */
    public ResumenRonda(ArrayList <String> movimientos,List<Planeta> planetas) {
        initComponents();
        String stringMovimientos="";
         String stringVidas="";
         this.setModal(true);
         
        System.out.println("Patata");
 
     
        for (int i = 0; i < movimientos.size(); i++) {
            
            stringMovimientos=stringMovimientos+movimientos.get(i)+" +10 segundos \n";
             jTextArea1.setText(stringMovimientos);
             
             
        }
        for (int i = 0; i < planetas.size(); i++) {
           
            stringVidas=stringVidas+ planetas.get(i).getNombre()+" tiene "+planetas.get(i).getVidas()+"\n ";
             jTextArea2.setText(stringVidas);
            
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("asda");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 700, 210));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 550, 210));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 320, 300));

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
