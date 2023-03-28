package Assignment.Clinic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DailyAppointment extends JFrame {
    private JTable appointmentTable;

    public DailyAppointment() {
        setTitle("Daily Appointment");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        String[] columns = { "Doctor", "Date", "Time" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String doctor = searchField.getText();
                model.setRowCount(0);
                try {
                    File file = new File("appointments.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] fields = line.split(",");
                        if (fields[0].equals(doctor)) {
                            String[] row = { fields[0], fields[1], fields[2] };
                            model.addRow(row);
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        appointmentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
