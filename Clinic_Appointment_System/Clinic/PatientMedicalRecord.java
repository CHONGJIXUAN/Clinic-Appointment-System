package Assignment.Clinic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PatientMedicalRecord extends JFrame {

    private JTable recordTable;

    public PatientMedicalRecord() {
        setTitle("Patient Medical Records");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = { "Name", "Age", "Gender", "Height", "Weight", "Blood Type" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = searchField.getText();
                model.setRowCount(0);
                try {
                    File file = new File("medical_records.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] fields = line.split(",");
                        if (fields[0].equalsIgnoreCase(name)) {
                            String[] row = { fields[0], fields[1], fields[2], fields[3], fields[4], fields[5] };
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

        recordTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(recordTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    }
}
