/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.ui;

import cazzendra.pos.core.Loading;
import com.ttms.controller.UserControl;
import com.ttms.controller.commonController;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amal
 */
public class userManagement extends javax.swing.JFrame {

    /**
     * Creates new form ItemManagement
     */
    public userManagement() {
        initComponents();
        loadDataToTable();
        txtUname.requestFocus();
        panel.setBackground(Loading.getColorCode());
    }

    private void loadDataToTable() {
        try {
            String[] columnList = {"user_id", "user_name", "user_type"};
            ResultSet rset = UserControl.getAllUsers();
            commonController.loadDataToTable(tblUsers, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(userManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearDetails() {
        txtPassword.setText(null);
        txtUname.setText(null);
        comboType.setSelectedIndex(0);
        txtUname.requestFocus();
    }

    private void addUser() {
        try {
            if (txtPassword.getText().trim() != null || txtUname.getText().trim() != null) {
                UserControl.addUser(txtUname.getText(), txtPassword.getText(), comboType.getSelectedItem().toString());
                JOptionPane.showMessageDialog(this, "User Added Successfully !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userManagement.class.getName()).log(Level.SEVERE, null, ex);
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

        panel = new javax.swing.JPanel();
        txtUname = new javax.swing.JTextField();
        comboType = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JTextField();
        btAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Management");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 102, 255));
        setMinimumSize(new java.awt.Dimension(645, 549));
        setResizable(false);

        panel.setMaximumSize(new java.awt.Dimension(1358, 766));
        panel.setMinimumSize(new java.awt.Dimension(1358, 766));
        panel.setPreferredSize(new java.awt.Dimension(1358, 766));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUname.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtUname.setToolTipText("User Name");
        txtUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnameActionPerformed(evt);
            }
        });
        txtUname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnameKeyReleased(evt);
            }
        });
        panel.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 59, 270, 40));

        comboType.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager", "User" }));
        comboType.setToolTipText("Type");
        comboType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });
        panel.add(comboType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 40));

        txtPassword.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtPassword.setToolTipText("Password");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        panel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 59, 280, 40));

        btAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/saveIcon.png"))); // NOI18N
        btAddUser.setToolTipText("Add User");
        btAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddUserActionPerformed(evt);
            }
        });
        panel.add(btAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 100, 48));

        jLabel2.setFont(new java.awt.Font("Ubuntu Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("User Name");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 31, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Password");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 31, -1, -1));

        jLabel7.setFont(new java.awt.Font("Ubuntu Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Type");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        tblUsers.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "User Name", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUsers.getTableHeader().setFont(new Font("Ubuntu", Font.BOLD, 18));
        tblUsers.getTableHeader().setOpaque(false);
        tblUsers.getTableHeader().setBackground(new Color(0, 0, 102));
        tblUsers.getTableHeader().setForeground(new Color(255, 255, 255));
        tblUsers.setRowHeight(22);
        tblUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblUsers);
        if (tblUsers.getColumnModel().getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setMinWidth(0);
            tblUsers.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblUsers.getColumnModel().getColumn(0).setMaxWidth(0);
            tblUsers.getColumnModel().getColumn(1).setResizable(false);
            tblUsers.getColumnModel().getColumn(2).setMinWidth(0);
            tblUsers.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblUsers.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 580, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 537, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddUserActionPerformed
        addUser();
        loadDataToTable();
        clearDetails();
    }//GEN-LAST:event_btAddUserActionPerformed

    private void txtUnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnameKeyReleased
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            txtItemName.requestFocus();
//        }

    }//GEN-LAST:event_txtUnameKeyReleased

    private void txtUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnameActionPerformed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtPassword.requestFocus();
//        }
    }//GEN-LAST:event_txtUnameActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTypeActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        //        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        //            txtItemCode.requestFocus();
        //        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        comboType.requestFocus();
        comboType.showPopup();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void comboTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboTypePopupMenuWillBecomeInvisible
        btAddUser.requestFocus();
    }//GEN-LAST:event_comboTypePopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(userManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddUser;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
