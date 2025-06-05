/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aitechs_cms_copy;

import aitechs_cms_copy.session;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class dlClearance extends javax.swing.JFrame {
    public dlClearance() {
        initComponents();
        setTitle("Clearance Form Preview");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Simulate modality
        setAlwaysOnTop(true);
        addWindowListener(new WindowAdapter() {
            public void windowDeactivated(WindowEvent e) {
                requestFocus();
            }
        });
        
        if (session.loggedInStudent == null) {
            JOptionPane.showMessageDialog(this, "No student is currently logged in.");
            dispose();
        } else {
            loadStudentClearance(session.loggedInStudent.getEmail());
            setLocationRelativeTo(null);
        }
    }



    public boolean printClearance() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Student Clearance");

        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return java.awt.print.Printable.NO_SUCH_PAGE;
            }
            graphics.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
            jPanel1.printAll(graphics);
            return java.awt.print.Printable.PAGE_EXISTS;
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
                return true;
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Print failed: " + ex.getMessage());
            }
        }
        return false;
    }

    private void loadStudentClearance(String email) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT s.student_name, s.year_lvl, s.block, " +
                        "p.uniform_paid, p.memfee_paid, p.idlace_paid, p.status " +
                        "FROM payed p " +
                        "JOIN students s ON p.student_email = s.email " +
                        "WHERE p.student_email = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, email.trim());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("student_name");
                String yearBlock = rs.getString("year_lvl") + " - " + rs.getString("block");
                String u = rs.getString("uniform_paid") == null ? "" : rs.getString("uniform_paid").trim();
                String m = rs.getString("memfee_paid") == null ? "" : rs.getString("memfee_paid").trim();
                String i = rs.getString("idlace_paid") == null ? "" : rs.getString("idlace_paid").trim();
                String status = rs.getString("status") == null ? "" : rs.getString("status").trim();

                // Update UI
                lblName.setText("NAME: " + fullName);
                lblYrBlock.setText("YEAR & BLOCK: " + yearBlock);
                lblU.setText(u);
                lblM.setText(m);
                lblid.setText(i);

                // Check payment status
                boolean allPaid = u.equalsIgnoreCase("paid") 
                              && m.equalsIgnoreCase("paid") 
                              && i.equalsIgnoreCase("paid");
                boolean approved = status.equalsIgnoreCase("approved for printing");

                if (!allPaid || !approved) {
                    StringBuilder sb = new StringBuilder("Clearance is not yet ready. Please complete:\n");
                    if (!u.equalsIgnoreCase("paid")) sb.append("- Uniform Payment\n");
                    if (!m.equalsIgnoreCase("paid")) sb.append("- Membership Fee\n");
                    if (!i.equalsIgnoreCase("paid")) sb.append("- ID Lace Payment\n");
                    if (!status.equalsIgnoreCase("approved for printing")) sb.append("- Officer Approval\n");

                    JOptionPane.showMessageDialog(this, sb.toString());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No payment record found for this student.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    // ... rest of your existing code (initComponents, variables, etc) ...

    // Default constructor (not used when passing email)
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblYrBlock = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblU = new javax.swing.JLabel();
        lblM = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(507, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(507, 574));
        jPanel1.setMinimumSize(new java.awt.Dimension(507, 574));
        jPanel1.setPreferredSize(new java.awt.Dimension(507, 574));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/Clearanceto.jpg"))); // NOI18N
        jLabel2.setText(" ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/Clearance.jpg"))); // NOI18N
        jLabel1.setText(" ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 524, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CLEARANCE FORM");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 91, -1, -1));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("NAME:");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 148, -1, -1));

        lblYrBlock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblYrBlock.setText("YEAR & BLOCK:");
        jPanel1.add(lblYrBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("FEE/S");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 209, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("REMARKS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 209, -1, -1));

        jLabel8.setText("Department Uniform");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 258, -1, -1));

        jLabel9.setText("Membership fee");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 286, -1, -1));

        jLabel10.setText("ID Lace");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 314, -1, -1));

        jLabel11.setText("Others:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 342, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setText("AITECHS President");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 413, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel13.setText("AITECHS Adviser");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 475, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel14.setText(" ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 166, 134, 21));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel15.setText(" ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 166, 141, 21));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel16.setText(" ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 231, 217, 21));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel17.setText(" ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 231, 217, 21));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel18.setText(" ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 364, 217, 21));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/line2.png"))); // NOI18N
        jLabel19.setText(" ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 364, 217, 21));

        lblU.setText(" ");
        jPanel1.add(lblU, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 258, 106, -1));

        lblM.setText(" ");
        jPanel1.add(lblM, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 286, 106, -1));

        lblid.setText(" ");
        jPanel1.add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 314, 106, -1));

        jLabel4.setText(" ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 475, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aitechs_cms_copy/stamp.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 369, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Main method (for standalone testing)
    public static void main(String args[]) {
    // For test purposes only — simulate a logged-in student
//    session.loggedInStudent = new student();
//    session.loggedInStudent.setEmail("student@example.com"); // Replace with a real test email

    java.awt.EventQueue.invokeLater(() -> {
        new dlClearance().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblM;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblU;
    private javax.swing.JLabel lblYrBlock;
    private javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables


   
}
