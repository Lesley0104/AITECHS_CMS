package aitechs_cms_copy;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Lenovo
 */
public class StudentRequestForm extends JFrame {
    private final JLabel nameLabel;
    private final JButton requestButton;
    private final JLabel statusLabel;
    private final int studentId;

    public StudentRequestForm(int studentId) {
        this.studentId = studentId;
        student s = session.loggedInStudent;

        setTitle("Request Clearance");
        setSize(400, 200);
        setLayout(new GridLayout(4, 1, 10, 10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nameLabel = new JLabel("", SwingConstants.CENTER);
        requestButton = new JButton("Request Clearance");
        statusLabel = new JLabel("", SwingConstants.CENTER);

        if (s != null) {
            nameLabel.setText("Logged in as: " + s.getName());
        } else {
            nameLabel.setText("Logged in as: Guest");
        }

        add(nameLabel);
        add(requestButton);
        add(statusLabel);

        requestButton.addActionListener(e -> {
            submitRequest();
            checkRequestStatus();
        });

        checkRequestStatus();
        setVisible(true);
    }

    StudentRequestForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void submitRequest() {
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement check = connection.prepareStatement(
                "SELECT status FROM clearance_requests WHERE student_id = ? AND status = 'Pending'"
            );
            check.setInt(1, studentId);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("You already have a pending request.");
                requestButton.setEnabled(false);
                return;
            }

            PreparedStatement insert = connection.prepareStatement(
                "INSERT INTO clearance_requests (student_id, status, request_date) VALUES (?, 'Pending', NOW())"
            );
            insert.setInt(1, studentId);
            insert.executeUpdate();

            statusLabel.setForeground(new Color(0, 128, 0));
            statusLabel.setText("Request submitted successfully!");
            requestButton.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Error submitting request.");
        }
    }

    private void checkRequestStatus() {
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT status FROM clearance_requests WHERE student_id = ? ORDER BY request_date DESC LIMIT 1"
            );
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status");
                switch (status) {
                    case "Pending":
                        statusLabel.setForeground(Color.BLUE);
                        statusLabel.setText("Your request is pending approval.");
                        requestButton.setEnabled(false);
                        break;
                    case "Accepted":
                        statusLabel.setForeground(new Color(0, 128, 0));
                        statusLabel.setText("ACCEPTED. Congratulations!");
                        requestButton.setEnabled(false);
                        break;
                    case "Rejected":
                        statusLabel.setForeground(Color.RED);
                        statusLabel.setText("REJECTED. Please contact the office.");
                        break;
                    default:
                        statusLabel.setText("Request status: " + status);
                }
            } else {
                statusLabel.setText("No clearance request found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Error checking request status.");
        }
    }

    public static void main(String[] args) {
        // This assumes student is already logged in and session.loggedInStudent is set
        if (session.loggedInStudent != null) {
            new StudentRequestForm(session.loggedInStudent.getId());
        } else {
            System.out.println("Student not logged in.");
        }
    }
}
