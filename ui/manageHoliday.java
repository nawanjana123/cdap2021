/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.ui;

import com.ttms.controller.commonConstants;
import com.ttms.controller.commonController;
import com.ttms.controller.holidayController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amal
 */
public class manageHoliday extends javax.swing.JFrame {

    /**
     * Creates new form addStudent
     */
    public manageHoliday() {
        initComponents();
        clearAll();
        loadHolidaysToTable();
    }

    private void clearAll() {
        txtDetail.setText("");
        calHolidayFrom.setDate(null);
        calHolidayTo.setDate(null);
    }

    private void uuiConfig() {
        this.setSize(1269, 643);
    }

    private void addHoliday() {
        if (calHolidayFrom.getDate() == null || calHolidayFrom.getDate().toString().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Select holiday from date !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (calHolidayTo.getDate() == null || calHolidayTo.getDate().toString().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Select holiday to date !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDetail.getText().trim().equalsIgnoreCase("") || txtDetail.getText().trim() == null) {
            JOptionPane.showMessageDialog(this, "Please enter holiday detail !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to enter holiday record ?", "Confirm", JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                boolean status = holidayController.addHolidayDetails(commonController.getMysqlDateFromJDateChooser(calHolidayFrom),
                        commonController.getMysqlDateFromJDateChooser(calHolidayTo), txtDetail.getText().trim());
                if (status) {
                    JOptionPane.showMessageDialog(this, "Record successfully added !");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(manageHoliday.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadHolidaysToTable() {
        try {
            String[] columnList = {"holiday_id", "holiday_date_from", "holiday_date_to", "holiday_detail"};
            ResultSet rset = holidayController.getAllHolidays();
            commonController.loadDataToTable(tblHolidayDetails, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(manageHoliday.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editSelectedHoliday() {
        int selectedRow = tblHolidayDetails.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblHolidayDetails.getModel();
        if (selectedRow != -1) {
            new editHoliday(this, true, commonController.getIntOrZeroFromString(dtm.getValueAt(selectedRow, 0).toString())).setVisible(true);
        }
    }

    private void searchByDatesAndDetail(String searchValue) {
        try {
            ArrayList<String[]> attributeCOnditionValueList = new ArrayList<>();

            String[] arr1 = {"holiday_date_from", commonConstants.Sql.LIKE, "%" + searchValue + "%"};
            attributeCOnditionValueList.add(arr1);

            String[] arr2 = {"holiday_date_to", commonConstants.Sql.LIKE, "%" + searchValue + "%"};
            attributeCOnditionValueList.add(arr2);

            String[] arr3 = {"holiday_detail", commonConstants.Sql.LIKE, "%" + searchValue + "%"};
            attributeCOnditionValueList.add(arr3);

            ResultSet rset = holidayController.getHolidayByMoreAttributes(attributeCOnditionValueList, commonConstants.Sql.OR);

            String[] arrayList = {"holiday_id", "holiday_date_from", "holiday_date_to", "holiday_detail"};

            commonController.loadDataToTable(tblHolidayDetails, rset, arrayList);

        } catch (SQLException ex) {
            Logger.getLogger(manageHoliday.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHolidayDetails = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtDetail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        calHolidayFrom = new com.toedter.calendar.JDateChooser();
        calHolidayTo = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        txtSearchByDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Holiday Management");
        setMaximumSize(new java.awt.Dimension(1269, 643));
        setMinimumSize(new java.awt.Dimension(1269, 643));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1269, 643));
        jPanel1.setMinimumSize(new java.awt.Dimension(1269, 643));

        tblHolidayDetails.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblHolidayDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "holiday id", "Holiday From", "Holiday To", "Holiday Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHolidayDetails.setMaximumSize(new java.awt.Dimension(1500, 0));
        tblHolidayDetails.setRowHeight(20);
        tblHolidayDetails.setRowMargin(2);
        tblHolidayDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHolidayDetails);
        if (tblHolidayDetails.getColumnModel().getColumnCount() > 0) {
            tblHolidayDetails.getColumnModel().getColumn(0).setMinWidth(0);
            tblHolidayDetails.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblHolidayDetails.getColumnModel().getColumn(0).setMaxWidth(0);
            tblHolidayDetails.getColumnModel().getColumn(1).setResizable(false);
            tblHolidayDetails.getColumnModel().getColumn(2).setResizable(false);
            tblHolidayDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDetail.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtDetail.setToolTipText("Details / Remarks");
        txtDetail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtDetail.setSelectionColor(new java.awt.Color(255, 255, 0));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons3/Holiday From.png"))); // NOI18N
        jLabel2.setToolTipText("Holiday Date From");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Detail.png"))); // NOI18N
        jLabel4.setToolTipText("Details / Remarks");

        btSave.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 255, 255));
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/saveIcon_green.png"))); // NOI18N
        btSave.setToolTipText("Add new holiday");
        btSave.setBorder(null);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Holiday Details / Remarks");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Holiday From");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons3/Holiday To.png"))); // NOI18N
        jLabel5.setToolTipText("Holiday Date To");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Holiday To");

        calHolidayFrom.setToolTipText("Holiday Date From");
        calHolidayFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                calHolidayFromFocusLost(evt);
            }
        });
        calHolidayFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calHolidayFromMouseExited(evt);
            }
        });
        calHolidayFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calHolidayFromPropertyChange(evt);
            }
        });
        calHolidayFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calHolidayFromKeyReleased(evt);
            }
        });

        calHolidayTo.setToolTipText("Holiday Date To");
        calHolidayTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                calHolidayToFocusLost(evt);
            }
        });
        calHolidayTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calHolidayToMouseExited(evt);
            }
        });
        calHolidayTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calHolidayToPropertyChange(evt);
            }
        });
        calHolidayTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calHolidayToKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSave)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(calHolidayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                        .addComponent(calHolidayFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calHolidayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calHolidayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363))
        );

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/editIcon.png"))); // NOI18N
        btnEdit.setToolTipText("Edit Holiday ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtSearchByDate.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtSearchByDate.setToolTipText("Search by Year / Level");
        txtSearchByDate.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtSearchByDate.setSelectionColor(new java.awt.Color(255, 255, 0));
        txtSearchByDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchByDateKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        addHoliday();
        clearAll();
        loadHolidaysToTable();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editSelectedHoliday();
        loadHolidaysToTable();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchByDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchByDateKeyReleased
        searchByDatesAndDetail(txtSearchByDate.getText().trim());
    }//GEN-LAST:event_txtSearchByDateKeyReleased

    private void calHolidayFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calHolidayFromFocusLost

    }//GEN-LAST:event_calHolidayFromFocusLost

    private void calHolidayFromMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calHolidayFromMouseExited

    }//GEN-LAST:event_calHolidayFromMouseExited

    private void calHolidayFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calHolidayFromPropertyChange
    }//GEN-LAST:event_calHolidayFromPropertyChange

    private void calHolidayFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calHolidayFromKeyReleased

    }//GEN-LAST:event_calHolidayFromKeyReleased

    private void calHolidayToFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calHolidayToFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_calHolidayToFocusLost

    private void calHolidayToMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calHolidayToMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_calHolidayToMouseExited

    private void calHolidayToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calHolidayToPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_calHolidayToPropertyChange

    private void calHolidayToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calHolidayToKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_calHolidayToKeyReleased

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
            java.util.logging.Logger.getLogger(manageHoliday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageHoliday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageHoliday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageHoliday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageHoliday().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnEdit;
    private com.toedter.calendar.JDateChooser calHolidayFrom;
    private com.toedter.calendar.JDateChooser calHolidayTo;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHolidayDetails;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtSearchByDate;
    // End of variables declaration//GEN-END:variables
}
