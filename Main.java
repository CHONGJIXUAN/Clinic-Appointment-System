import javax.swing.*;

import Assignment.Clinic.ClinicStaff;
import Assignment.Patients.Patients;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        showRoleSelection();
    }

    public static void showRoleSelection() {
        JFrame roleFrame = new JFrame("Role Selection");
        roleFrame.setSize(400, 300);
        roleFrame.setLayout(null);

        JLabel messageLabel = new JLabel("Please select your role:");
        messageLabel.setBounds(100, 50, 200, 30);
        roleFrame.add(messageLabel);

        // Create a JButton for clinic staff
        JButton clinicStaffButton = new JButton("Clinic Staff");
        clinicStaffButton.setBounds(100, 100, 200, 30);
        roleFrame.add(clinicStaffButton);

        // Add an ActionListener to the clinic staff button
        clinicStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClinicStaff ClinicStaff = new ClinicStaff();
                ClinicStaff.setVisible(true);
                roleFrame.dispose();
            }
        });

        JButton patientsButton = new JButton("Patients");
        patientsButton.setBounds(100, 150, 200, 30);
        roleFrame.add(patientsButton);

        // Add an ActionListener to the patients button
        patientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Patients patients = new Patients();
                patients.setVisible(true);
                roleFrame.dispose();
            }
        });

        roleFrame.setVisible(true);
    }

    public static void setVisible(boolean b) {

    }
}
