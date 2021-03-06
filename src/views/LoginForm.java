/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author Administrator
 */
public class LoginForm extends javax.swing.JFrame {

    User us = new User();
    ResultSet rs;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlbg = new javax.swing.JPanel()
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/views/img/bglogin.jpg"));
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        }
        ;
        pnlHeading = new javax.swing.JPanel()
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/views/img/temp.jpg"));
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        }
        ;
        pnlCenter = new javax.swing.JPanel();
        lblUserID = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan Processing System");
        setResizable(false);

        pnlHeading.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeading.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlHeadingLayout = new javax.swing.GroupLayout(pnlHeading);
        pnlHeading.setLayout(pnlHeadingLayout);
        pnlHeadingLayout.setHorizontalGroup(
            pnlHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlHeadingLayout.setVerticalGroup(
            pnlHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUserID.setFont(new java.awt.Font("VNI-Meli", 2, 18)); // NOI18N
        lblUserID.setText("User Name");
        lblUserID.setPreferredSize(new java.awt.Dimension(100, 35));
        pnlCenter.add(lblUserID);

        txtUserName.setPreferredSize(new java.awt.Dimension(220, 32));
        pnlCenter.add(txtUserName);

        lblPassword.setFont(new java.awt.Font("VNI-Meli", 2, 18)); // NOI18N
        lblPassword.setText("Password");
        lblPassword.setPreferredSize(new java.awt.Dimension(100, 35));
        pnlCenter.add(lblPassword);

        pwdPassword.setPreferredSize(new java.awt.Dimension(220, 32));
        pnlCenter.add(pwdPassword);

        jCheckBox1.setText("Log In As Administrator");
        pnlCenter.add(jCheckBox1);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnLogin.png"))); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnExit.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlbgLayout = new javax.swing.GroupLayout(pnlbg);
        pnlbg.setLayout(pnlbgLayout);
        pnlbgLayout.setHorizontalGroup(
            pnlbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbgLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pnlbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlbgLayout.createSequentialGroup()
                        .addGroup(pnlbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(pnlbgLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        pnlbgLayout.setVerticalGroup(
            pnlbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbgLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pnlHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(516, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:  
        System.exit(1);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String pas = new String(pwdPassword.getPassword());
        if (txtUserName.getText().equals("") || pas.equals("")) {
            JOptionPane.showMessageDialog(null, "You must type username and password");
        } else {
            if (jCheckBox1.isSelected() == true) {
                char[] pass = pwdPassword.getPassword();
                String password = new String(pass);
                boolean isLogin = false;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
                    Statement s = cn.createStatement();
                    rs = s.executeQuery("SELECT [UserName],[Password],[Designation] FROM tblUser");
                    while (rs.next()) {
                        if (txtUserName.getText().equals(rs.getString("UserName")) && password.equals(rs.getString("Password"))
                                && us.admin.equals(rs.getString("Designation"))) {
                            JOptionPane.showMessageDialog(null, "Logged In");
                            this.dispose();
                            new HomeForm(txtUserName.getText(), us.admin).setVisible(true);
                            isLogin = true;
                            break;
                        }
                    }
                    if (isLogin == false) {
                        JOptionPane.showMessageDialog(null, "Wrong UserName of Password");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (jCheckBox1.isSelected() == false) {
                char[] pass = pwdPassword.getPassword();
                String password = new String(pass);
                boolean isLogin = false;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
                    Statement s = cn.createStatement();
                    rs = s.executeQuery("SELECT [UserName],[Password],[Designation] FROM tblUser");
                    while (rs.next()) {
                        if (txtUserName.getText().equals(rs.getString("UserName")) && password.equals(rs.getString("Password"))
                                && us.user.equals(rs.getString("Designation"))) {
                            JOptionPane.showMessageDialog(null, "Logged In");
                            this.dispose();
                            new HomeForm(txtUserName.getText(), us.user).setVisible(true);
                            isLogin = true;
                            break;
                        }
                    }
                    if (isLogin == false) {
                        JOptionPane.showMessageDialog(null, "Wrong UserName of Password");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlHeading;
    private javax.swing.JPanel pnlbg;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
