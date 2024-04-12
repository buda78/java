package practicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class B extends JFrame {
    private JTextField txtEno, txtEName, txtDesignation, txtSalary;
    private JButton btnSave;

    public B() {
        setTitle("Employee Details Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Employee No:"));
        txtEno = new JTextField();
        panel.add(txtEno);

        panel.add(new JLabel("Employee Name:"));
        txtEName = new JTextField();
        panel.add(txtEName);

        panel.add(new JLabel("Designation:"));
        txtDesignation = new JTextField();
        panel.add(txtDesignation);

        panel.add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        panel.add(txtSalary);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new SaveButtonListener());
        panel.add(btnSave);

        add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String eno = txtEno.getText();
            String ename = txtEName.getText();
            String designation = txtDesignation.getText();
            String salary = txtSalary.getText();

            try {
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/bcs",
                        "bcs",
                        "bcs");

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO Employee(Eno, EName, Designation, Salary) " +
                             "VALUES('" + eno + "', '" + ename + "', '" + designation + "', '" + salary + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(B.this, "Employee details saved successfully!");
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(B.this, "Error saving employee details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            B form = new B();
            form.setVisible(true);
        });
    }
}
