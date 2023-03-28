package Assignment.Clinic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StaffAppointment extends JFrame {

    public StaffAppointment() {
        setTitle("Staff Appointment");
        setSize(400, 300);
        setLayout(null);

        JLabel label = new JLabel("Staff Appointment");
        label.setBounds(150, 50, 200, 30);
        add(label);

        JButton confirmButton = new JButton("Confirm Appointment");
        confirmButton.setBounds(100, 150, 200, 30);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean result = confirmAppointment();
                if (result) {
                    JOptionPane.showMessageDialog(null, "Appointment confirmed.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error confirming appointment.");
                }
            }
        });
        add(confirmButton);

        JButton cancelButton = new JButton("Cancel Appointment");
        cancelButton.setBounds(100, 200, 200, 30);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean result = cancelAppointment();
                if (result) {
                    JOptionPane.showMessageDialog(null, "Appointment cancelled.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error cancelling appointment.");
                }
            }
        });
        add(cancelButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static boolean confirmAppointment() {
        ArrayList<String> appointments = new ArrayList<>();
        try {
            File file = new File("appointments.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith(", pending")) {
                    appointments.add(line.replace(", pending", ", confirmed"));
                } else {
                    appointments.add(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return false;
        }

        try {
            File file = new File("appointments.txt");
            FileWriter writer = new FileWriter(file);
            for (String appointment : appointments) {
                writer.write(appointment + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cancelAppointment() {
        try {
            FileWriter writer = new FileWriter("appointments.txt");
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
