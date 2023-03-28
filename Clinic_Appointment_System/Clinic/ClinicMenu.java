package Assignment.Clinic;

import javax.swing.*;
import java.awt.event.*;

public class ClinicMenu extends JFrame implements ActionListener {
    private JButton timeTableButton;
    private JButton appointmentButton;
    private JButton patientMedicalRecordButton;
    private JButton dailyAppointmentButton;

    public ClinicMenu() {
        setTitle("Clinic Staff");
        setSize(400, 300);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to the Clinic Staff!");
        welcomeLabel.setBounds(100, 50, 200, 30);
        add(welcomeLabel);

        timeTableButton = new JButton("TimeTable");
        timeTableButton.setBounds(100, 100, 200, 30);
        add(timeTableButton);
        timeTableButton.addActionListener(this);

        appointmentButton = new JButton("Appointment");
        appointmentButton.setBounds(100, 150, 200, 30);
        add(appointmentButton);
        appointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffAppointment appointmentFrame = new StaffAppointment();
                appointmentFrame.setVisible(true);
            }
        });

        patientMedicalRecordButton = new JButton("Track Patient Medical Record");
        patientMedicalRecordButton.setBounds(100, 200, 250, 30);
        add(patientMedicalRecordButton);
        patientMedicalRecordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientMedicalRecord appointmentFrame = new PatientMedicalRecord();
                appointmentFrame.setVisible(true);
            }
        });

        dailyAppointmentButton = new JButton("Daily Appointment");
        dailyAppointmentButton.setBounds(100, 250, 250, 30);
        add(dailyAppointmentButton);
        dailyAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DailyAppointment dailyAppointment = new DailyAppointment();
                dailyAppointment.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timeTableButton) {
            timetable timeTable = new timetable();
            timeTable.setVisible(true);
        }
    }
}
