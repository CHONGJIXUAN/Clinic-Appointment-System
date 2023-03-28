package Assignment.Clinic;

import javax.swing.*;
import java.awt.event.*;

public class ClinicStaff extends JFrame {
    public ClinicStaff() {
        setTitle("Clinic Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome to the Clinic Staff page!");
        welcomeLabel.setBounds(100, 50, 200, 30);
        add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 200, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffLogin login = new StaffLogin();
                login.setVisible(true);
                dispose();
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 150, 200, 30);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffRegister register = new StaffRegister();
                register.setVisible(true);
                dispose();
            }
        });

        setLayout(null);
        setVisible(true);
    }
}
