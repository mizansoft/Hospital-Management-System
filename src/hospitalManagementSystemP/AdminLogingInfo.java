/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalManagementSystemP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mizan
 */
public class AdminLogingInfo extends javax.swing.JFrame {

    /**
     * Creates new form AdminInfo
     */
    public AdminLogingInfo() {
        initComponents();
    }

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        checkBoxPassword = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("User_Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 78, -1, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 131, -1, -1));

        jButton1.setText("Create new user");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 198, -1, -1));
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 78, 188, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 131, 188, -1));

        jButton2.setText("loging");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 198, -1, -1));

        checkBoxPassword.setText("Show Password");
        checkBoxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        jLabel3.setText("     Royel Hospital");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 250, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // loging button

        try {
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_s", "root", "mizan123");
            pst = con.prepareStatement(
                    "INSERT INTO admin_user VALUES(?,?)"
            );
            pst.setString(1, userName);
            pst.setString(2, password);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("error " + e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        // loging button
        try {
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_s", "root", "mizan123");
            pst = con.prepareStatement(
                    "SELECT * FROM admin_user"
            );
            ResultSet rs = pst.executeQuery();
            String ac = "";
            String pa = "";

            while (rs.next()) {
                ac = rs.getString(1);
                pa = rs.getString(2);

            }

            if (userName.equals(ac) && password.equals(pa)) {
                JOptionPane.showMessageDialog(this, "Welcome To Royel Hospital ");
                AdminDoctorPatientFile adp = new AdminDoctorPatientFile();
                adp.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Your user and password not correct Try again");
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkBoxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPasswordActionPerformed
        // TODO add your handling code here:
        // show password box
        if (checkBoxPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);

        } else {
            txtPassword.setEchoChar('*');
        }

    }//GEN-LAST:event_checkBoxPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogingInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogingInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogingInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogingInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogingInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
