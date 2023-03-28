package Assignment.Patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewTimeSlots extends JFrame implements ActionListener {
    private JTextArea timeSlotsTextArea;

    public ViewTimeSlots() {
        setTitle("View Available Time Slots");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel timeSlotsPanel = new JPanel(new BorderLayout());

        timeSlotsTextArea = new JTextArea(10, 30);
        timeSlotsTextArea.setEditable(false);
        timeSlotsPanel.add(timeSlotsTextArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(timeSlotsPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        add(refreshButton, BorderLayout.SOUTH);

        refreshTimeSlots();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshTimeSlots() {

        timeSlotsTextArea.setText("");

        try (BufferedReader br = new BufferedReader(new FileReader("time_slots.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                timeSlotsTextArea.append(line + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading time slots: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Refresh")) {

            refreshTimeSlots();
        }
    }
}
