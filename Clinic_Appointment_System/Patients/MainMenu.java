package Assignment.Patients;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private JButton viewTimeslotButton;
    private JButton bookAppointmentButton;
    private JButton cancelAppointmentButton;
    private JButton medicalrecordButton;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(400, 300);
        setLayout(null);
        new ArrayList<Appointment>();

        JLabel welcomeLabel = new JLabel("Welcome to the Main Menu!");
        welcomeLabel.setBounds(100, 50, 200, 30);
        add(welcomeLabel);

        viewTimeslotButton = new JButton("View Available Timeslots");
        viewTimeslotButton.setBounds(100, 100, 200, 30);
        add(viewTimeslotButton);

        viewTimeslotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewTimeSlots viewTimeSlots = new ViewTimeSlots();
                viewTimeSlots.setVisible(true);
            }
        });

        bookAppointmentButton = new JButton("Book an Appointment");
        bookAppointmentButton.setBounds(100, 150, 200, 30);
        add(bookAppointmentButton);

        bookAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookAppointment bookAppointment = new BookAppointment();
                bookAppointment.setVisible(true);
            }
        });

        cancelAppointmentButton = new JButton("Cancel Appointment");
        cancelAppointmentButton.setBounds(100, 200, 250, 30);
        add(cancelAppointmentButton);

        cancelAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CancelAppointment cancelAppointment = new CancelAppointment();
                boolean result = cancelAppointment.cancelAppointment();
                if (result) {
                    System.out.println("Appointment cancelled.");
                } else {
                    System.out.println("Error cancelling appointment.");
                }
            }
        });

        medicalrecordButton = new JButton("Track Personal Medical Record");
        medicalrecordButton.setBounds(100, 250, 250, 30);
        add(medicalrecordButton);

        medicalrecordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicalRecord medicalrecord = new MedicalRecord();
                medicalrecord.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
