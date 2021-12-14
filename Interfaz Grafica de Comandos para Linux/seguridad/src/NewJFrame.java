
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    String raiz = "/";
    String path;
    int a = 1;
    
    DefaultListModel modeloLista = new DefaultListModel();
    
    public void initResultList(){
        try{ 
        
            String[] cmd = {"sh","-c","ls "+raiz};
            Process pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                modeloLista.addElement(line);
        }
        input.close();
        resultList.setModel(modeloLista);
        resultList.updateUI();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public NewJFrame() {
        initComponents();
        initResultList();
        resultList.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultScrollPane = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList<>();
        pathTextField = new javax.swing.JTextField();
        lslaButton = new javax.swing.JButton();
        cpButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        delUserButton = new javax.swing.JButton();
        showUsersButton = new javax.swing.JButton();
        lsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        resultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultListMouseClicked(evt);
            }
        });
        resultScrollPane.setViewportView(resultList);

        lslaButton.setText("ls -la");
        lslaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lslaButtonActionPerformed(evt);
            }
        });

        cpButton.setText("cp");
        cpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpButtonActionPerformed(evt);
            }
        });

        addUserButton.setText("adduser");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        delUserButton.setText("deluser");
        delUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delUserButtonActionPerformed(evt);
            }
        });

        showUsersButton.setText("Ver Usuarios");
        showUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersButtonActionPerformed(evt);
            }
        });

        lsButton.setText("ls");
        lsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lsButtonActionPerformed(evt);
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
                        .addComponent(addUserButton)
                        .addGap(18, 18, 18)
                        .addComponent(delUserButton)
                        .addGap(18, 18, 18)
                        .addComponent(showUsersButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lsButton)
                        .addGap(18, 18, 18)
                        .addComponent(lslaButton)
                        .addGap(18, 18, 18)
                        .addComponent(cpButton))
                    .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lslaButton)
                    .addComponent(cpButton)
                    .addComponent(lsButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserButton)
                    .addComponent(delUserButton)
                    .addComponent(showUsersButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultListMouseClicked
        if(path!=null){
        String local = path +raiz +resultList.getSelectedValue();
        pathTextField.setText(local);
        resultList.updateUI();
        } else{
            path="";
           String local = raiz+path + resultList.getSelectedValue();
            pathTextField.setText(local);
            resultList.updateUI();
        }
    }//GEN-LAST:event_resultListMouseClicked

    private void lsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lsButtonActionPerformed
        // TODO add your handling code here:
            modeloLista.clear();
        try{ 
            
            path = pathTextField.getText();
            String[] cmd = {"sh","-c","ls "+path};
            Process pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                modeloLista.addElement(line);
        }
        input.close();
        resultList.setModel(modeloLista);
        resultList.updateUI();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lsButtonActionPerformed

    private void lslaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lslaButtonActionPerformed
        // TODO add your handling code here:
        modeloLista.clear();
        try{ 
            
            path = pathTextField.getText();
            String[] cmd = {"sh","-c","ls -la "+path};
            Process pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                modeloLista.addElement(line);
        }
        input.close();
        resultList.setModel(modeloLista);
        resultList.updateUI();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lslaButtonActionPerformed

    private void cpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpButtonActionPerformed
        // TODO add your handling code here:
        String destino = JOptionPane.showInputDialog("Ingresar ruta de copiado");
        if(destino != null && destino != "no"){
            try{ 
                path = pathTextField.getText();
                String[] cmd = {"sh","-c","cp "+path+" "+destino};
                Runtime.getRuntime().exec(cmd);
            } catch(IOException ex){
                ex.printStackTrace();
            }
        } else{ 
            try{ 
                System.out.println("huevos");
                path = pathTextField.getText();
                String[] cmd2 = {"sh","-c","cp "+path+" "+path+(a+=1)};
                Runtime.getRuntime().exec(cmd2);
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }    
    }//GEN-LAST:event_cpButtonActionPerformed

    private void showUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersButtonActionPerformed
        // TODO add your handling code here:
        modeloLista.clear();
        try{ 
            String[] cmd = {"sh","-c","awk -F: '{ print $1}' /etc/passwd"};
            Process pb = Runtime.getRuntime().exec(cmd);
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            while ((line = input.readLine()) != null) {
                modeloLista.addElement(line);
        }
        input.close();
        resultList.setModel(modeloLista);
        resultList.updateUI();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_showUsersButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        // TODO add your handling code here:
        String user = JOptionPane.showInputDialog("User");
        String password = JOptionPane.showInputDialog("Password");
        try{ 
            String[] cmd = {"sh","-c","useradd -p $(openssl passwd -1 "+password+") "+user};
            Process pb = Runtime.getRuntime().exec(cmd);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void delUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delUserButtonActionPerformed
        // TODO add your handling code here:
        String user = JOptionPane.showInputDialog("Ingresar el usuario que quiere eliminar");
        try{ 
            String[] cmd = {"sh","-c","deluser "+user};
            Process pb = Runtime.getRuntime().exec(cmd);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_delUserButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton cpButton;
    private javax.swing.JButton delUserButton;
    private javax.swing.JButton lsButton;
    private javax.swing.JButton lslaButton;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JList<String> resultList;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JButton showUsersButton;
    // End of variables declaration//GEN-END:variables
}
