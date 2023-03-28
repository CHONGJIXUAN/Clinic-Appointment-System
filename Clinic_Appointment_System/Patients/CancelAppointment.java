package Assignment.Patients;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CancelAppointment extends JFrame {

    private JButton cancelButton;

    public CancelAppointment() {
        setTitle("Cancel Appointment");
        setSize(400, 300);
        setLayout(null);

        cancelButton = new JButton("Cancel Appointment");
        cancelButton.setBounds(100, 100, 200, 30);
        add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cancelAppointment()) {
                    JOptionPane.showMessageDialog(null, "Appointment cancelled.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error cancelling appointment.");
                }
            }
        });
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
