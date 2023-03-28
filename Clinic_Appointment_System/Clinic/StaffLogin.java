package Assignment.Clinic;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StaffLogin extends JFrame implements ActionListener {

    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton;

    public StaffLogin() {

        setTitle("Staff Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        add(panel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        panel.setLayout(null);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            try {
                boolean loginSuccess = false;
                try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        String storedUsername = data[0];
                        String storedPassword = data[1];
                        if (username.equals(storedUsername) && password.equals(storedPassword)) {
                            ClinicMenu clinicMenu = new ClinicMenu();
                            clinicMenu.setVisible(true);
                            dispose();
                            loginSuccess = true;
                            break;
                        }
                    }
                }
                if (!loginSuccess) {
                    JOptionPane.showMessageDialog(loginButton, "Invalid username or password", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    userText.setText("");
                    passwordText.setText("");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Cannot read data.txt", "File Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}
