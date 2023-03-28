package Assignment.Patients;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PatientsRegister extends JFrame implements ActionListener {

    public static Object userText;
    public static Object passwordText;

    private JLabel nameLabel, passwordLabel, confirmPasswordLabel;
    private JTextField nameTextField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;

    public PatientsRegister() {
        setTitle("Clinic Staff Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        nameTextField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        registerButton = new JButton("Register");
        backButton = new JButton("Back");

        registerButton.addActionListener(this);
        backButton.addActionListener(this);

        setLayout(new GridLayout(4, 2));
        add(nameLabel);
        add(nameTextField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(registerButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameTextField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (name.equals("") || password.equals("") || confirmPassword.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
                return;
            }

            try (FileWriter fw = new FileWriter("patient_data.txt", true)) {
                fw.write(name + "," + password + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving registration data: " + ex.getMessage());
                return;
            }

            JOptionPane.showMessageDialog(this, "Registration successful!");
            dispose();
            new PatientsLogin();

        } else if (e.getSource() == backButton) {
            dispose();
            new MainMenu();
        }
    }

    public static void main(String[] args) {
        new PatientsRegister().setVisible(true);
    }

}
