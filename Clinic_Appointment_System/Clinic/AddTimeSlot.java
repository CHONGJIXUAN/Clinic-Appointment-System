package Assignment.Clinic;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddTimeSlot extends JFrame {
    private JTextField startField, endField;

    public AddTimeSlot() {
        setTitle("Add Time Slot");
        setSize(400, 300);
        setLayout(null);

        JLabel startLabel = new JLabel("Start Time (HH:MM):");
        startLabel.setBounds(50, 50, 150, 30);
        add(startLabel);

        startField = new JTextField();
        startField.setBounds(200, 50, 150, 30);
        add(startField);

        JLabel endLabel = new JLabel("End Time (HH:MM):");
        endLabel.setBounds(50, 100, 150, 30);
        add(endLabel);

        endField = new JTextField();
        endField.setBounds(200, 100, 150, 30);
        add(endField);

        JButton addButton = new JButton("Add Time Slot");
        addButton.setBounds(100, 150, 200, 30);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String start = startField.getText();
                String end = endField.getText();

                boolean overlap = checkOverlap(start, end);

                if (!overlap) {
                    addTimeSlot(start, end);
                    JOptionPane.showMessageDialog(null, "Time slot added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Time slot overlaps with an existing time slot.");
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean checkOverlap(String start, String end) {
        boolean overlap = false;
        try {
            File file = new File("time_slots.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String existingStart = parts[0];
                String existingEnd = parts[1];
                if (start.compareTo(existingEnd) < 0 && end.compareTo(existingStart) > 0) {
                    overlap = true;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return overlap;
    }

    private void addTimeSlot(String start, String end) {
        try {
            File file = new File("time_slots.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(start + "," + end + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
