/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aitechs_cms_copy;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author Lenovo
 */


public class submitted2 extends javax.swing.JFrame {
    
    public submitted2() {
        initComponents(); 
        loadSubmitted();
        setVisible(true);
   }
//    private DefaultTableModel model;
//
//     public submitted2() {
//    initComponents();
//
//    model = new DefaultTableModel(
//    new Object[][]{},
//    new String[] { "Student Name", "Accepted Date", "Status", 
//                  "Uniform Paid", "ID Lace Paid", "Membership Fee Paid", "Approve for Printing" }
//) {
//    @Override
//    public boolean isCellEditable(int row, int column) {
//        // allow checkbox columns (4,5,6) and approve button (7) to be editable
//        return column >= 4;
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        if (columnIndex >= 4 && columnIndex <= 6) return Boolean.class; // checkboxes
//        if (columnIndex == 7) return JButton.class;
//        return String.class;
//    }
//    };
//
//    tblSubmitted.setModel(model);
//
//    tblSubmitted.getColumn("Approve for Printing").setCellRenderer(new ButtonRenderer());
//    tblSubmitted.getColumn("Approve for Printing").setCellEditor(new ButtonEditor(new JCheckBox(), tblSubmitted));
//
//    loadSubmittedData();
//    setVisible(true);
//
//}
//     private void loadSubmittedData() {
//        DefaultTableModel model = (DefaultTableModel) tblSubmitted.getModel();
//        model.setRowCount(0);
//
//         String sql = "SELECT p.student_name, p.payment_date, p.status, " +
//                 "p.uniform_paid, p.idlace_paid, p.memfee_paid " +
//                 "FROM payed p " +
//                 "JOIN clearance_requests cr ON p.student_name = cr.student_id " +
//                 "WHERE LOWER(cr.status) IN ('accepted','accept') " +
//                 "AND p.uniform_paid = 'Paid' AND p.idlace_paid = 'Paid' AND p.memfee_paid = 'Paid'";
//
//try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "");
//     Statement stmt = connection.createStatement();
//     ResultSet rs = stmt.executeQuery(sql)) {
//
//    while (rs.next()) {
//        
//        String studentName = rs.getString("student_name");
//        String date = rs.getString("payment_date");
//        String status = rs.getString("status");
//        boolean uniformPaid = "Paid".equalsIgnoreCase(rs.getString("uniform_paid"));
//        boolean idlacePaid = "Paid".equalsIgnoreCase(rs.getString("idlace_paid"));
//        boolean memfeePaid = "Paid".equalsIgnoreCase(rs.getString("memfee_paid"));
//
//        model.addRow(new Object[] { studentName, date, status, uniformPaid, idlacePaid, memfeePaid, "Approve" });
//    }
//
//} catch (SQLException e) {
//    JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
//}
//    }

//
//        // Set the button renderer and editor for the last column
//        tblSubmitted.getColumn("Approved for Printing").setCellRenderer(new ButtonRenderer());
//        tblSubmitted.getColumn("Approved for Printing").setCellEditor(new ButtonEditor(new JCheckBox(), tblSubmitted));
//    }
//}



//    private void updateCheckboxInDB(String studentNo, String columnName, Boolean checked) {
//        String value = checked ? "Yes" : "No";
//        String sql = "UPDATE clearance_requests SET " + columnName + " = ? WHERE student_id = ? AND LOWER(status) IN ('accepted','accept' )";
//
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "");
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, value);
//            ps.setString(2, studentNo);
//            int updated = ps.executeUpdate();
//
//            if (updated == 1) {
//                System.out.println(columnName + " updated to " + value + " for Student No: " + studentNo);
//            } else {
//                JOptionPane.showMessageDialog(this,
//                    "Failed to update " + columnName + " for Student No: " + studentNo,
//                    "Update Error", JOptionPane.ERROR_MESSAGE);
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this,
//                "Database error while updating " + columnName + ": " + e.getMessage(),
//                "Database Error", JOptionPane.ERROR_MESSAGE);
//        }
//}

  

// --- Custom ButtonRenderer Class ---



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        navigationPanel = new javax.swing.JPanel();
        btnNavProfile = new javax.swing.JButton();
        btnRequested = new javax.swing.JButton();
        btnSubmitted = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnMasterlist = new javax.swing.JButton();
        profilePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubmitted = new javax.swing.JTable();
        btnApproved = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(245, 247, 250));
        jPanel4.setPreferredSize(new java.awt.Dimension(1366, 768));

        navigationPanel.setBackground(new java.awt.Color(44, 62, 80));
        navigationPanel.setPreferredSize(new java.awt.Dimension(200, 768));

        btnNavProfile.setText("Profile");
        btnNavProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNavProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavProfileActionPerformed(evt);
            }
        });

        btnRequested.setText("Requested");
        btnRequested.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRequested.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestedActionPerformed(evt);
            }
        });

        btnSubmitted.setText("Approved");
        btnSubmitted.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSubmitted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmittedActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(44, 62, 80));
        btnLogout.setForeground(new java.awt.Color(245, 247, 250));
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnList.setText("Lists");
        btnList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnMasterlist.setText("Payment Masterlists");
        btnMasterlist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMasterlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterlistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationPanelLayout = new javax.swing.GroupLayout(navigationPanel);
        navigationPanel.setLayout(navigationPanelLayout);
        navigationPanelLayout.setHorizontalGroup(
            navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationPanelLayout.createSequentialGroup()
                .addGroup(navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNavProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMasterlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnLogout)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        navigationPanelLayout.setVerticalGroup(
            navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationPanelLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnNavProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMasterlist, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(37, 37, 37))
        );

        profilePanel.setBackground(new java.awt.Color(245, 247, 250));
        profilePanel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lists of Accepted Clearance Requests");

        tblSubmitted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Invoice Number", "Email", "Name", "Amount", "Method", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSubmitted);

        btnApproved.setText("Approved");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(554, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApproved)
                .addGap(654, 654, 654))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApproved)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/finalHeader.png"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(1366, 160));
        jLabel4.setMinimumSize(new java.awt.Dimension(1366, 160));
        jLabel4.setPreferredSize(new java.awt.Dimension(1366, 160));
        jLabel4.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(navigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void loadSubmitted() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "");
             PreparedStatement pst = conn.prepareStatement("SELECT invoice_number, student_email, student_name, amount, method, status, payment_date, officer_name FROM payed");
             ResultSet rs = pst.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) tblSubmitted.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("invoice_number"),
                        rs.getString("student_email"),
                        rs.getString("student_name"),
                        rs.getDouble("amount"),
                        rs.getString("method"),
                        rs.getString("status"),
                        rs.getTimestamp("payment_date"),
                        rs.getString("officer_name")
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load payments.");
        }
    }
     
    
    private void btnNavProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavProfileActionPerformed
        new officer_dashboard().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnNavProfileActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnRequestedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestedActionPerformed
        new requested().setVisible(true);
 this.dispose();
    }//GEN-LAST:event_btnRequestedActionPerformed

    private void btnSubmittedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmittedActionPerformed
       new submitted2().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnSubmittedActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
          student_lists student_listsForm = new student_lists();  // Create the Dashboard window
    student_listsForm.setVisible(true);             // Show it
    student_listsForm.setLocationRelativeTo(null);  // Optional: center the window
    this.dispose();

    }//GEN-LAST:event_btnListActionPerformed

    private void btnMasterlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterlistActionPerformed
        new masterlistPayment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMasterlistActionPerformed

    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed
        // TODO add your handling code here:
//        int[] selectedRows = tblSubmitted.getSelectedRows();
//
//    if (selectedRows.length == 0) {
//        JOptionPane.showMessageDialog(this, "Please select at least one row to approve for printing.");
//        return;
//    }
//
//    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "")) {
//
//        for (int row : selectedRows) {
//            String name = tblSubmitted.getValueAt(row, 1).toString(); // assuming column 1 is student_email
//            String currentStatus = tblSubmitted.getValueAt(row, 5).toString(); // assuming column 5 is status
//
//            if ("Ready for Printing".equalsIgnoreCase(currentStatus)) {
//                continue; // already approved
//            }
//
//            String updateSql = "UPDATE payed SET status = 'Approved for Printing' WHERE student_name = ?";
//
//            try (PreparedStatement pst = conn.prepareStatement(updateSql)) {
//                pst.setString(1, name);
//                int updated = pst.executeUpdate();
//
//                if (updated > 0) {
//                    tblSubmitted.setValueAt("Ready for Printing", row, 5); // update the table model
//                } else {
//                    JOptionPane.showMessageDialog(this, "Failed to update status for: " + name);
//                }
//            }
//        }
//
//        JOptionPane.showMessageDialog(this, "Selected students approved for printing.");
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
//    }

int[] selectedRows = tblSubmitted.getSelectedRows();

    if (selectedRows.length == 0) {
        JOptionPane.showMessageDialog(this, "Please select at least one row to approve for printing.");
        return;
    }

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "")) {
        for (int row : selectedRows) {
            String email = tblSubmitted.getValueAt(row, 1).toString(); // assuming column 1 is student_email
            String currentStatus = tblSubmitted.getValueAt(row, 5).toString(); // assuming column 5 is status

            if ("Ready for Printing".equalsIgnoreCase(currentStatus)) {
                continue; // Skip already approved
            }

            String updateSql = "UPDATE payed p " +
                               "JOIN students s ON p.student_name = s.student_name " +
                               "SET p.status = 'Approved for Printing' " +
                               "WHERE s.email = ?";

            try (PreparedStatement pst = conn.prepareStatement(updateSql)) {
                pst.setString(1, email);
                int updated = pst.executeUpdate();

                if (updated > 0) {
                    tblSubmitted.setValueAt("Ready for Printing", row, 5); // update UI
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update status for: " + email);
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Selected students approved for printing.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnApprovedActionPerformed

    // Button Renderer to display button in JTable
//    class ButtonRenderer extends JButton implements TableCellRenderer {
//        public ButtonRenderer() {
//            setOpaque(true);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value,
//                                                       boolean isSelected, boolean hasFocus, int row, int column) {
//            setText(value == null ? "Approve" : value.toString());
//            return this;
//        }
//    }
//
//    // Button Editor to handle button clicks in JTable
//    class ButtonEditor extends DefaultCellEditor {
//        private JButton button;
//        private String studentNo;
//        private boolean clicked;
//        private JTable table;
//
//        public ButtonEditor(JCheckBox checkBox, JTable table) {
//            super(checkBox);
//            this.table = table;
//            button = new JButton();
//            button.setOpaque(true);
//
//            button.addActionListener(e -> {
//                fireEditingStopped();
//                onApproveClicked();
//            });
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                                                     boolean isSelected, int row, int column) {
//            studentNo = table.getValueAt(row, 0).toString(); // Student No is in first column
//            button.setText(value == null ? "Approve" : value.toString());
//            clicked = true;
//            return button;
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            clicked = false;
//            return button.getText();
//        }
//
//        @Override
//        public boolean stopCellEditing() {
//            clicked = false;
//            return super.stopCellEditing();
//        }
//
//        private void onApproveClicked() {
//            if (!clicked) return;
//
//    int selectedRow = table.getSelectedRow();
//    if (selectedRow < 0) return;
//
//    // Get studentNo again to be safe
//    studentNo = table.getValueAt(selectedRow, 0).toString();
//
//    // Get checkbox values
//    Boolean uniformPaid = (Boolean) table.getValueAt(selectedRow, 4);
//    Boolean idlacePaid = (Boolean) table.getValueAt(selectedRow, 5);
//    Boolean memfeePaid = (Boolean) table.getValueAt(selectedRow, 6);
//
//    int confirm = JOptionPane.showConfirmDialog(button,
//        "Approve clearance and payments for Student No: " + studentNo + "?\n" +
//        "Uniform Paid: " + uniformPaid + "\n" +
//        "ID Lace Paid: " + idlacePaid + "\n" +
//        "Membership Fee Paid: " + memfeePaid,
//        "Confirm Approval",
//        JOptionPane.YES_NO_OPTION);
//
//    if (confirm != JOptionPane.YES_OPTION) return;
//
//    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aitechs_cms_db", "root", "")) {
//        // Update payment fields and status in one query
//        String sql = "UPDATE payed p " +
//                 "JOIN clearance_requests cr ON p.student_id = cr.student_id " +
//                 "SET p.uniform_paid = ?, p.idlace_paid = ?, p.memfee_paid = ?, p.status = 'Approved for Printing' " +
//                 "WHERE p.student_id = ? " +
//                 "AND LOWER(cr.status) IN ('accepted', 'accept') " +
//                 "AND p.uniform_paid = 'Paid' AND p.idlace_paid = 'Paid' AND p.memfee_paid = 'Paid'";
//
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, uniformPaid ? "Paid" : "Pending");
//            ps.setString(2, idlacePaid ? "Paid" : "Pending");
//            ps.setString(3, memfeePaid ? "Paid" : "Pending");
//            ps.setString(4, studentNo);
//
//            int updated = ps.executeUpdate();
//
//            if (updated > 0) {
//                JOptionPane.showMessageDialog(button, "Clearance and payment approvals saved for Student No: " + studentNo);
//loadSubmittedData();
//                // Update status and payment checkboxes in table model
//                table.setValueAt("Approved for Printing", selectedRow, 3); // status column
//                // optionally set checkboxes again for sync (not really needed)
//            } else {
//                JOptionPane.showMessageDialog(button, "Failed to update status in database.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(button, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }
//        }
//    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new submitted2());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasterlist;
    private javax.swing.JButton btnNavProfile;
    private javax.swing.JButton btnRequested;
    private javax.swing.JButton btnSubmitted;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTable tblSubmitted;
    // End of variables declaration//GEN-END:variables
}
