package Assignment.Patients;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BookAppointment extends JFrame {
    private JLabel doctorLabel;
    private JComboBox<String> doctorComboBox;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel timeLabel;
    private JComboBox<String> timeComboBox;
    private JButton bookButton;

    public BookAppointment() {
        setTitle("Book Appointment");
        setSize(400, 300);
        setLayout(null);

        doctorLabel = new JLabel("Select a doctor:");
        doctorLabel.setBounds(50, 50, 100, 30);
        add(doctorLabel);

        doctorComboBox = new JComboBox<>(new String[] { "Dr. John", "Dr. Jane", "Dr. Mike" });
        doctorComboBox.setBounds(150, 50, 200, 30);
        add(doctorComboBox);

        dateLabel = new JLabel("Enter appointment date:");
        dateLabel.setBounds(50, 100, 200, 30);
        add(dateLabel);

        dateTextField = new JTextField();
        dateTextField.setBounds(250, 100, 100, 30);
        add(dateTextField);

        timeLabel = new JLabel("Select appointment time:");
        timeLabel.setBounds(50, 150, 150, 30);
        add(timeLabel);

        timeComboBox = new JComboBox<>(
                new String[] { "9:00 AM", "10:00 AM", "11:00 AM", "2:00 PM", "3:00 PM", "4:00 PM" });
        timeComboBox.setBounds(200, 150, 150, 30);
        add(timeComboBox);

        bookButton = new JButton("Book Appointment");
        bookButton.setBounds(100, 200, 200, 30);
        add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String doctor = doctorComboBox.getSelectedItem().toString();
                String date = dateTextField.getText();
                String time = timeComboBox.getSelectedItem().toString();

                try {
                    File file = new File("appointments.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[0].equals(doctor) && parts[1].equals(date) && parts[2].equals(time)) {
                            JOptionPane.showMessageDialog(null, "Appointment already exists.");
                            reader.close();
                            return;
                        }
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    FileWriter writer = new FileWriter("appointments.txt", true);
                    writer.write(doctor + "," + date + "," + time + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Appointment booked successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
