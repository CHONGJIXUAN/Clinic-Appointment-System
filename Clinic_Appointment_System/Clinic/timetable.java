package Assignment.Clinic;

import javax.swing.*;

import java.awt.event.*;

public class timetable extends JFrame {
    private JButton addTimeSlotButton;
    private JButton editTimeSlotButton;
    private JButton removeTimeSlotButton;

    public timetable() {
        setTitle("Clinic Staff");
        setSize(500, 400);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to the Time Table!");
        welcomeLabel.setBounds(150, 20, 200, 30);
        add(welcomeLabel);

        addTimeSlotButton = new JButton("Add Time Slot");
        addTimeSlotButton.setBounds(50, 170, 200, 30);
        add(addTimeSlotButton);

        addTimeSlotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AddTimeSlot addTimeSlot = new AddTimeSlot();
                addTimeSlot.setVisible(true);
            }
        });

        editTimeSlotButton = new JButton("Edit Time Slot");
        editTimeSlotButton.setBounds(250, 170, 200, 30);
        add(editTimeSlotButton);

        editTimeSlotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditTimeSlot editTimeSlot = new EditTimeSlot();
                editTimeSlot.setVisible(true);
            }
        });

        removeTimeSlotButton = new JButton("Remove Time Slot");
        removeTimeSlotButton.setBounds(50, 220, 200, 30);
        add(removeTimeSlotButton);

        removeTimeSlotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoveTimeSlots removeTimeSlot = new RemoveTimeSlots();
                removeTimeSlot.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
